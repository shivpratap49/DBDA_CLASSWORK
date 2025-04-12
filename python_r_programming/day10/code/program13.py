# __str__()
# - method is used to convert the object to a string
# - by default object class adds this method to every class in python
# - the default implementation of __str__ will print the reference info

class Person:
    def __init__(self, name):
        self.__name = name

    def print_info(self):
        print(f"name = {self.__name}")

    # override the __str__()]
    # - convert your object to string
    def __str__(self):
        return f"Person [name={self.__name}]"


# this is an object of class int
num = 200
print(f"num = {num.__str__()}, type = {type(num)}")
print(f"num = {num}, type = {type(num)}")

salary = 15.50
print(f"salary = {salary.__str__()}")
print(f"salary = {salary}")

name = "steve"
print(f"name = {name.__str__()}")
print(f"name = {name}")

numbers = [10, 20]
print(f"numbers = {numbers}")
print(f"numbers = {numbers.__str__()}")

p1 = Person("person1")
print(f"p1 = {p1.__str__()}, type = {type(p1)}")
print(f"p1 = {p1}, type = {type(p1)}")

# print(f"parent of int = {int.__base__}")
