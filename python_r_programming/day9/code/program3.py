# function
# - referred as global function
# - declared outside any class
# - also known as procedure

# method
# - function declared inside a class
# - every object method inside the class must accept first parameter
#   as object of the same class
#   - conventionally the parameter name is 'self'
#   - self is not a keyword
#   - you may replace self with any variable without changing class behavior
#   - similar to this in Java or C++


class Person:
    def print_person(self):
        print(f"name = {getattr(self, 'name')}")
        print(f"address = {getattr(self, 'address')}")
        print('-' * 80)


p1 = Person()
setattr(p1, 'name', 'person1')
setattr(p1, 'address', 'pune')

# POP style
# print_person(p1)

# OOP style
# Person.print_person(p1)
p1.print_person()

p2 = Person()
setattr(p2, 'name', 'person2')
setattr(p2, 'address', 'mumbai')

# POP style
# print_person(p2)

# OOP style
# Person.print_person(p2)
p2.print_person()


# this line does not work anymore
# since the print_person is not a global function anymore
# there is no way invalid parameter can be passed to print_person
# print_person(10)

# numbers = list([10, 20, 30, 40, 50])
# numbers = [10, 20, 30, 40, 50]
# # list.append(numbers, 60)
# numbers.append(60)
