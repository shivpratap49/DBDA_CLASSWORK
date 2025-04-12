
from datetime import datetime, timedelta

from airflow import DAG
from airflow.operators.bash import BashOperator
from airflow.operators.empty import EmptyOperator

# create DAG object with suitable config
dag_arg = {
    "owner": "nilesh",
    "retries": "3",
    "retry_delay": timedelta(minutes=2)
}

with DAG(
    dag_id = "second_dag",
    schedule_interval = "@daily",
    start_date = datetime(2024, 12, 29),
    catchup = True,
    default_args = dag_arg
) as dag:
    
    task1 = BashOperator(
        task_id = "first_task",
        bash_command = 'sleep 3 && echo "This is First Task."'
    )

    task2 = BashOperator(
        task_id = "second_task",
        bash_command = 'sleep 5 && echo "This is Second Task."'
    )

    task3 = BashOperator(
        task_id = "third_task",
        bash_command = 'sleep 2 && echo "This is Third Task."'
    )

    start_task = EmptyOperator(task_id = "start_task")

    stop_task = EmptyOperator(task_id = "stop_task")


start_task >> [task1, task2] >> task3 >> stop_task

