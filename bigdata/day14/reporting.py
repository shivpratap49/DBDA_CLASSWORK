from datetime import datetime, timedelta

from airflow import DAG
from airflow.operators.bash import BashOperator
from airflow.operators.email import EmailOperator
from airflow.operators.python import PythonOperator
from airflow.providers.apache.hive.operators.hive import HiveOperator
from airflow.sensors.filesystem import FileSensor


def clean_stores_data():
    import re

    import pandas as pd

    def remove_dollar(amount:str):
        return float(amount.replace('$', ''))
    
    def clean_store_location(st_loc:str):
        return re.sub(r'[^\w\s]', '', st_loc).strip()
    
    def clean_product_id(pd_id:str):
        matches = re.findall(r'\d+', pd_id)
        if matches:
            return matches[0]
        return pd_id

    # load csv data    
    df = pd.read_csv('/tmp/input/stores.csv')
    # clean csv data
    df['STORE_LOCATION'] = df['STORE_LOCATION'].map(lambda x: clean_store_location(x))
    df['PRODUCT_ID'] = df['PRODUCT_ID'].map(lambda x: clean_product_id(x))
    df['MRP'] = df['MRP'].map(lambda x: remove_dollar(x))
    df['DISCOUNT'] = df['DISCOUNT'].map(lambda x: remove_dollar(x))
    df['SP'] = df['SP'].map(lambda x: remove_dollar(x))
    df['CP'] = df['CP'].map(lambda x: remove_dollar(x))
    # save cleaned data
    df.to_csv('/tmp/input/clean_stores.csv', index=False)


dag_args = {
    'owner': 'nilesh',
    'retries': '3',
    'retry_delay': timedelta(minutes=5)
}

with DAG(
    dag_id='report_v1',
    default_args=dag_args,
    schedule_interval='@daily',
    start_date=datetime(2024, 12, 30),
    catchup=True
) as dag:
    task1 = FileSensor(
        task_id='check_input_file',
        filepath='/tmp/input/stores.csv',
        poke_interval=30
    )
    task2 = PythonOperator(
        task_id='clean_input_csv',
        python_callable=clean_stores_data
    )
    task3 = BashOperator(
        task_id='delete_stores_csv',
        bash_command='rm /tmp/input/stores.csv'
    )
    task4 = HiveOperator(
        task_id='create_transactions_table',
        hive_cli_conn_id='hive_db',
        hql=r"""
        CREATE TABLE IF NOT EXISTS store_transactions(
            store_id INT, store_location STRING, product_category STRING, product_id INT,
            mrp FLOAT, cp FLOAT, discount FLOAT, sp FLOAT, sdate DATE
        )
        ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
        STORED AS TEXTFILE
        TBLPROPERTIES('skip.header.line.count'='1');
        """
    )
    task5 = HiveOperator(
        task_id='load_transactions_data',
        hive_cli_conn_id='hive_db',
        hql=r"""
        LOAD DATA LOCAL INPATH '/tmp/input/clean_stores.csv'
        INTO TABLE store_transactions;
        """
    )
    task6 = BashOperator(
        task_id='delete_clean_stores_csv',
        bash_command='rm /tmp/input/clean_stores.csv'
    )
    task7 = HiveOperator(
        task_id='delete_store_profits_table',
        hive_cli_conn_id='hive_db',
        hql=r"""
        DROP TABLE IF EXISTS store_profits;
        """
    )
    task8 = HiveOperator(
        task_id='store_profit_summary',
        hive_cli_conn_id='hive_db',
        hql=r"""
        CREATE TABLE store_profits AS
        SELECT store_location, SUM(sp - cp) AS profit FROM store_transactions
        GROUP BY store_location;
        """
    )
    task9 = HiveOperator(
        task_id='delete_category_profits_table',
        hive_cli_conn_id='hive_db',
        hql=r"""
        DROP TABLE IF EXISTS category_profits;
        """
    )
    task10 = HiveOperator(
        task_id='category_profit_summary',
        hive_cli_conn_id='hive_db',
        hql=r"""
        CREATE TABLE category_profits AS
        SELECT product_category, SUM(sp - cp) AS profit FROM store_transactions
        GROUP BY product_category;
        """
    )
    task11 = EmailOperator(
        task_id='send_email',
        to=['nilesh.sharing@gmail.com', 'yashgaikwad475@gmail.com'],
        subject='New Data Ingested',
        html_content=r"""
        Dear Manager,
            Today's data is uploaded into data warehouse and
            profit summary is calculated. You can see it via
            PowerBI dashboard.
        """
    )

task1 >> task2 >> task3 >> task4 >> task5 >> task6 >> task7 >> task8 >> task11
