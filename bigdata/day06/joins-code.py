
emp = [ {empno:1, ename:ABC, deptno:10, ...}, {}, ... ]
dept = [ {deptno:1, dname:XYZ, ...}, {}, ... ]

# matching dept & emp == inner join
for d in dept:
    for e in emp:
        if e['deptno'] == d['deptno']:
            print(e['ename'], d['dname'])

# matching dept & emp + extra depts == left join
for d in dept:
    found = 0
    for e in emp:
        if e['deptno'] == d['deptno']:
            print(e['ename'], d['dname'])
            found = 1
    if found == 0:
        print('NULL', d['dname'])

# left join + where clause
temp = []
for d in dept:
    found = 0
    for e in emp:
        if e['deptno'] == d['deptno']:
            temp += (e['ename'], d['dname'], d['deptno'])
            found = 1
    if found == 0:
        temp += (None, d['dname'], d['deptno'])

for t in temp:
    if t[2] == 40:
        print(t)

# left join with additional cond in on clause
temp = []
for d in dept:
    found = 0
    for e in emp:
        if e['deptno'] == d['deptno'] and d['deptno'] == 40:
            temp += (e['ename'], d['dname'], d['deptno'])
            found = 1
    if found == 0:
        print(None, d['dname'], d['deptno'])
