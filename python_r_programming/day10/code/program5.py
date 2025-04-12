
# class Person:
# class Person():
class Person(object):
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def print_info(self):
        print("-- person details --")
        print(f"name = {self.name}")
        print(f"age = {self.age}")

    def can_vote(self):
        print(f"can vote = {self.age >= 18}")


# Employee is-a Person
class Employee(Person):
    def __init__(self, name, age, salary):
        # initialize the base class object
        Person.__init__(self, name, age)
        self.__salary = salary

    def print_info(self):
        print(f"-- employee details --")
        print(f"salary = {self.__salary}")
        print(f"name = {self.name}")
        print(f"age = {self.age}")

        # calling the parent class method
        # self.can_vote()
        Person.can_vote(self)


p1 = Person("person1", 20)
print(p1.__dict__)
p1.print_info()

print('-' * 80)

e1 = Employee("employee1", 30, 20.50)
print(e1.__dict__)
e1.print_info()

