# one-to-one relationship
# e.g. Car has-an engine, Person has-a Car


class Engine:
    def __init__(self, power, version, expensive=False):
        self.__power = power
        self.__version = version
        self.__expensive = expensive

    def print_engine_info(self):
        print(f"power = {self.__power} hp")
        print(f"version = {self.__version}")

    def is_expensive(self):
        return self.__expensive


class Car:
    def __init__(self, model, company, engine_power, engine_version):
        self.__model = model
        self.__company = company

        # Car has-an engine
        self.__engine = Engine(engine_power, engine_version, True)

    def print_info(self):
        print(f"model = {self.__model}")
        print(f"company = {self.__company}")
        print(f"-- engine details --")
        self.__engine.print_engine_info()
        print(f"is engine expensive = {self.__engine.is_expensive()}")


car1 = Car("triber", "renault", 999, "v2")
car1.print_info()


class Bike:
    def __init__(self, model, company, engine_power, engine_version):
        self.__model = model
        self.__company = company
        self.__engine = Engine(engine_power, engine_version)

    def print_info(self):
        print(f"model = {self.__model}")
        print(f"company = {self.__company}")
        self.__engine.print_engine_info()
        print(f"is engine expensive = {self.__engine.is_expensive()}")


b1 = Bike("Meteor", "Royal Enfield", 350, "v6")
b1.print_info()

