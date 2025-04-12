import mysql.connector
mydb = mysql.connector.connect(
    host = "localhost",
    username = "root",
    password = "root",
    database = "classwork_db"
)

mycursor = mydb.cursor()
sql = "UPDATE emp SET sal = %s WHERE empno = %s"
val = (6000,8000)
mycursor.execute(sql,val)
mycursor.close()
mydb.commit()