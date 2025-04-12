# encapsulation
# - capsulating / binding both data and methods together
# - is achieved by using class
# abstraction
# - hiding the information from external access
# - is achieved by using private members
# conventions
# - these are not keywords
# public:
# - if an attribute has no underscore (_),
#   it is considered as public member
# - it can be accessed/updated outside the class
# protected:
# - if an attribute has only one underscore (_) as a prefix,
#   it is considered as protected member
# - it can be accessed only within the same class and all of its child classes
# private:
# - if an attribute has two underscores (__) as prefix,
#   it is considered as private member
# - it can be accessed only within the class it has declared in

# name mangling
# - used to change the name of attribute or method internally
# - this is compiler's feature
# - it is compiler version dependent
# - never use this feature directly in the code
#   never write the code which is dependent on compiler specific features


class Person:
    def __init__(self, name, address, age):
        # public members
        self.name = name
        self.address = address

        # private member
        self.__age = age

    def print_info(self):
        # can be accessed within the class
        print(f"name = {self.name}")
        print(f"address = {self.address}")

        # __age can be accessed only within the class
        print(f"age = {self.__age}")

    def can_vote(self):
        if self.__age >= 18:
            print(f"Yes {self.name} can vote")
        else:
            print(f"No {self.name} can NOT vote")

    def set_age(self, age):
        # validating the value
        if (age > 0) and (age <= 60):
            self.__age = age
        else:
            print(f"--- invalid age")

    def get_age(self):
        return self.__age


p1 = Person("person1", "pune", 10)
print(f"dictionary format = {p1.__dict__}")
# print(f"name = {p1.name}")
# print(f"address = {p1.address}")

# p1.__age = 11
p1.set_age(100000)
p1.print_info()

p1.set_age(40)
p1.print_info()


# since __age is a private member, it can not be accessed outside class
# print(f"age = {p1.__age}")

# do not write code like this
# it may work today might not work in future
# print(f"age = {p1._Person__age}")

# p1.print_info()
# p1.can_vote()
# p1.age = -100000
# p1.print_info()
print('-' * 80)

# p2 = Person("person2", "mumbai", 30)
# p2.print_info()
# p2.can_vote()
