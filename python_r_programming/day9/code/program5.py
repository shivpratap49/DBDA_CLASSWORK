class Car:
    def __init__(self, model, company):
        self.model = model
        setattr(self, 'company', company)

    def test_method(self):
        print(f"inside test method")

    def print_info(self):
        print(f"model = {getattr(self, 'model')}")
        print(f"company = {self.company}")

        # call this class another method
        # print(f"test_method = {getattr(self, 'test_method')}")
        # getattr(self, 'test_method')()
        print(self.test_method)
        self.test_method()


c1 = Car('triber', 'renault')
print(f"dictionary format = {c1.__dict__}")
setattr(c1, "price", 10)
setattr(c1, 'color', 'silver')
print(f"dictionary format = {c1.__dict__}")
delattr(c1, 'price')
print(f"dictionary format = {c1.__dict__}")
c1.print_info()

# c1.print_info = <function body>
# c1.my_method()


# def function1():
#     pass

print(Car.__dict__)


# # function alias or function reference
# my_function = function1
# num = 200
