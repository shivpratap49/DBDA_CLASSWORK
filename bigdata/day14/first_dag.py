
from datetime import datetime, timedelta

from airflow import DAG
from airflow.operators.bash import BashOperator

# create DAG object with suitable config
dag_arg = {
    "owner": "nilesh",
    "retries": "3",
    "retry_delay": timedelta(minutes=2)
}

f_dag = DAG(
    dag_id = "first_dag_v2",
    schedule_interval = "@daily",
    start_date = datetime(2024, 12, 25),
    catchup = True,
    default_args = dag_arg
)

task1 = BashOperator(
    task_id = "first_task",
    bash_command = 'sleep 3 && echo "This is First Task."',
    dag = f_dag
)

task2 = BashOperator(
    task_id = "second_task",
    bash_command = 'sleep 5 && echo "This is Second Task."',
    dag = f_dag
)

task3 = BashOperator(
    task_id = "third_task",
    bash_command = 'sleep 2 && echo "This is Third Task."',
    dag = f_dag
)

## task1 >> task2 >> task3
# task3.set_upstream(task2)
# task2.set_upstream(task1)

## task1 >> [task2, task3]
# task3.set_upstream(task1)
# task2.set_upstream(task1)

[task1, task2] >> task3
# task3.set_upstream(task1)
# task3.set_upstream(task2)
