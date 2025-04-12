import mysql.connector
mydb = mysql.connector.connect(
    host = "localhost",
    username = "root",
    password = "root",
    database = "classwork_db"
)

mycursor = mydb.cursor()
sql = "INSERT INTO emp(empno,ename,sal) VALUES(%s,%s,%s)"
val = (8001,"Anil",4000)
mycursor.execute(sql,val)
mycursor.close()
mydb.commit()
