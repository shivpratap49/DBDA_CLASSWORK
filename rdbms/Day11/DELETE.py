import mysql.connector

mydb = mysql.connector.connect(
    host = "localhost",
    username = "root",
    password = "root",
    database = "classwork_db"
)

mycursor = mydb.cursor()
sql = "DELETE FROM emp WHERE empno = %s"
val = (8000,)
mycursor.execute(sql,val)
mycursor.close()
mydb.commit()