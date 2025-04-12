#import package pymongo
from pymongo import MongoClient

# connect with mongo DB on port 27017
client=MongoClient('mongodb://localhost:27017')


#connect with database named as 'dbda'
db=client['dbda']

#connect with collection named as 'emp'
emp=db['emp']

#Print all the employee data from emp collection
# emps=emp.find()
# for e in emps:
#     # print(e)
#     print(e['_id'],'-',e['ename'],'-',e['job'],'-',e['sal'])

# Print all the employee data from emp collection
def getAllEmpInfo():
    emps = emp.find()
    for e in emps:
        # print(e)
        print(e['_id'], '-', e['ename'], '-', e['job'], '-', e['sal'])
# getAllEmpInfo()
# Print info of all MANAGER from emp collection using python function getAllManagers()
def getAllManagers():
    criteria = {'job':'MANAGER'}
    managers = emp.find(criteria)
    for e in managers:
        print(e['_id'], '-', e['ename'], '-', e['job'], '-', e['sal'])
# getAllManagers()

#### add new emp as _id=101 , ename='nita' , job:"MANAGER" ,
#  sal:2000  , deptno:20
def addNewEmp():
    newEmp={'_id':101,'ename':'nita', 'job':"MANAGER",'sal':2000, 'deptno':20}
    emp.insert_one(newEmp)
    print("Emp added...")

# addNewEmp()


#### Remove emp having id = 7566
def deleteEmp():
    emp.delete_one({'_id':7566})
    print("Emp deleted....")

deleteEmp()
getAllManagers()

