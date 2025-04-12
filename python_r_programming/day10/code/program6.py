# inheritance
# - a parent class shares all public and protected members
#   with child class(es)
# - a parent class CAN NOT share private member (because of name
#   mangling the members can not be accessed inside child class)
# - every derived class object contains an object of base class
#   - Employee class object will contain an object of Person class
# - all public/protected members (data and methods) of parent class
#   can be accessed within derived class
# - but parent class can NOT access anything from child class

# initializer
# - every class must contain an initializer
# - if explicit (user default) initializer is missing,
#   then compiler adds implicit initializer (default) in the class


# root class
# - in python, is object class (defined by python system)
# - in python, every class is derived from object class directly or
#   indirectly
# - python3 has added the root class behavior
# - is need to add
#   - memory management feature in every instance
#   - utility methods like __str__()

class Person(object):
    def __init__(self):
        self.__name = "person1"
        self.age = 20


# Employee is-a Person
# Employee class is derived from Person class
# Employee is a subclass of Person (super class)
# Employee is a derived class of Person (base class)
# Employee is a child class of Person (parent class)
class Employee(Person):
    # def __init__(self):
    #   # adding a Person class object inside Employee object
    #   Person.__init__(self)

    def print_info(self):
        print(f"age = {self.age}")
        # __name can not be accessed here as it is private member of Person class
        # print(f"name = {self.__name}")


print(f"Employee's base class = {Employee.__base__}")

p1 = Person()

# Employee.__init__(e1)
e1 = Employee()
print(f"p1 = {p1.__dict__}")
print(f"e1 = {e1.__dict__}")
e1.print_info()

print(f"Person = {Person.__dict__}")
print(f"Employee = {Employee.__dict__}")
