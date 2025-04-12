class Person:
    def __init__(self, name, age, address):
        self.__name = name
        self.__age = age
        self.__address = address

    def can_vote(self):
        if self.__age >= 18:
            print(f"{self.__name} can vote")
        else:
            print(f"{self.__name} can NOT vote")

    def print_info(self):
        print(f"name = {self.__name}")
        print(f"address = {self.__address}")
        print(f"age = {self.__age}")


# p1 = Person("person1", 20, "pune")
# p1.can_vote()
# p1.print_info()

# name = input("enter your name: ")
# address = input("enter your address: ")
# age = int(input("enter your age: "))
# p2 = Person(name, age, address)
# p2.can_vote()
# p2.print_info()

