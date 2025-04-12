
from datetime import datetime, timedelta

from airflow import DAG
from airflow.providers.mysql.operators.mysql import MySqlOperator

# create DAG object with suitable config
dag_arg = {
    "owner": "nilesh",
    "retries": "3",
    "retry_delay": timedelta(minutes=2)
}

with DAG(
    dag_id = "third_dag",
    schedule_interval = "@daily",
    start_date = datetime(2024, 12, 27),
    catchup = True,
    default_args = dag_arg
) as dag:

    create_table_task = MySqlOperator(
        task_id = "create_table_task",
        mysql_conn_id = "mysql_default",
        sql = """
        CREATE TABLE IF NOT EXISTS dbda_test(
            mid INT PRIMARY KEY AUTO_INCREMENT,
            msg VARCHAR(150),
            mtime TIMESTAMP
        )
        """
    )

    insert_data_task = MySqlOperator(
        task_id = "insert_data_task",
        mysql_conn_id = "mysql_default",
        sql = r"""
        INSERT INTO dbda_test(msg, mtime)
        VALUES ('Running: {{ dag.dag_id }} at {{ ts }}', NOW())
        """
    )

create_table_task >> insert_data_task
