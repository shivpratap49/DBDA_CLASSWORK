from pyhive import hive

# hive config
host_name = 'localhost'
port = 10000
user = 'nilesh'
password = ' '
db_name = 'edbda'

# get hive connection
conn = hive.Connection(host=host_name, port=port, username=user, password=password, database=db_name, auth='CUSTOM')

# get the cursor object
cur = conn.cursor()

# execute the sql query using cursor
sal = input('Enter minimum salary: ')
sql = "SELECT * FROM emp WHERE sal > %s"
cur.execute(sql, [sal])

# collect/process result
result = cur.fetchall()
for row in result:
    print(row)

# close the connection
conn.close()
