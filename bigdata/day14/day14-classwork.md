
## Airflow
* Email Sending
    * https://hevodata.com/learn/airflow-emailoperator/
    * https://www.google.com/landing/2step/
    * https://support.google.com/accounts/answer/185833
* Add smtp settings in airflow.cfg
    ```
    [smtp]
    smtp_host=smtp.gmail.com
    smtp_starttls=False
    smtp_ssl=True
    smtp_user=sendfrom@gmail.com
    smtp_password=********
    smtp_port=465
    smtp_mail_from=sendfrom@gmail.com
    ```
