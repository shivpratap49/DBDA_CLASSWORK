# polymorphism
# - multiple forms of a single entity
# - types
#   - compile time or static
#     - can be implemented by function or method overloading
#     - is not supported in python
#   - run time or dynamic
#     - can be implemented by method overriding

# method overriding
# - calling the method from type of object
# - if the object is of base class, the method will be called from
#   base class and if the object is of derived class, then the method
#   will be called from the derived class
# - this can be achieved by implementing method in both base and
#   derived class with same name


class Person:
    def __init__(self, name, address, age):
        print(f"Person: self = {self}")
        self.name = name
        self.address = address
        self.__age = age

    def print_info(self):
        print(f"inside Person class print_info")
        print(f"name = {self.name}, address = {self.address}")


class Student(Person):
    def __init__(self, name, address, age, roll):
        print(f"Student: self = {self}")
        Person.__init__(self, name, address, age)
        self.roll = roll

    def print_info(self):
        print("inside Student print_info()")
        print(f"name = {self.name}, address = {self.address}, roll = {self.roll}")


s1 = Student('student1', 'pune', 20, 1)
print(f"s1 = {s1.__dict__}")
s1.print_info()

p1 = Person('person1', 'pune', 30)
p1.print_info()


