# multilevel inheritance
# - a derived class acts a base class for other derived class(es)

class Person:
    pass


class Employee(Person):
    pass


class Manager(Employee):
    pass
