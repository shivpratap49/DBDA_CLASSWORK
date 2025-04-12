class Address:
    def __init__(self, city, state, country):
        self.__city = city
        self.__state = state
        self.__country = country

    def print_address(self):
        print(f"city = {self.__city}")
        print(f"state = {self.__state}")
        print(f"country = {self.__country}")


class Person:
    def __init__(self, name, age, city, state, country):
        self.__name = name
        self.__age = age

        # create an object of Address class to store address
        # Person has-an address
        self.__address = Address(city, state, country)

    def print_info(self):
        print(f"name = {self.__name}")
        print(f"age = {self.__age}")

        # printing the person address
        # Address.print_address(self.__address)
        self.__address.print_address()


class School:
    def __init__(self, name, level, city, state, country):
        self.__name = name
        self.__level = level

        # create an object of Address class to store address
        # School has-an address
        self.__address = Address(city, state, country)

    def print_info(self):
        print(f"name = {self.__name}")
        print(f"level = {self.__level}")

        # printing the school address
        self.__address.print_address()


# p1 = Person("person1", 20, "pune", "MH", 'India')
# p1.print_info()
# print('-' * 80)
# print(p1.__dict__)

# s1 = School("School1", "College", "mumbai", "MH", "India")
# s1.print_info()
