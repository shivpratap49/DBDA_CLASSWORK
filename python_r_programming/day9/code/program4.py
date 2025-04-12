# function
# - block of code which can be reused
# - types
#   - global function
#     - function declared outside any class
#     - also known as procedure
#   - method
#     - function declared inside a class
#     - types
#       - initializer
#         - used to initialize the object
#         - name of initializer is always '__init__'
#         - gets called automatically immediately after
#           creation of an object
#         - gets called for every object of that class
#           including anonymous object
#         - similar to constructor in other language
#         - types
#           - default initializer
#             - parameterless
#           - custom initializer
#             - which accepts at least one parameter
#       - facilitator
#         - used to add a facility in the class
#         - also known as utility methods
#         - .e.g can_vote(), print_info()
#       - setter
#         - also known as mutator
#         - used to update/modify an attribute
#         - conventionally, setter method starts with 'set'
#       - getter
#         - also known as inspector
#         - used to get value of an attribute
#         - conventionally, getter method starts with 'get'

class Person:
    # default initializer
    def __init__(self):
        print("inside __init__")
        setattr(self, 'name', '')
        setattr(self, 'address', '')
        setattr(self, 'age', '')

    def init_info(self, name, address, age):
        setattr(self, 'name', name)
        setattr(self, 'address', address)
        setattr(self, 'age', age)

    def print_info(self):
        print(f"name: {getattr(self, 'name')}")
        print(f"age: {getattr(self, 'age')}")
        print(f"address: {getattr(self, 'address')}")


# p1 = Person()
# setattr(p1, 'name', 'person1')
# setattr(p1, 'address', 'pune')
# setattr(p1, 'age', 30)
# p1.print_info()

# p2 = Person()
# p2.init_info('person2', 'mumbai', 20)
# p2.print_info()


# - allocates memory to store the object
# - allocates memory for reference which in turn stores the address
#   of the object
# - calls the initializer method
#   Person.__init__(p3)
# p3 = Person()
# p3.init_info('person3', 'satara', 40)
# p3.print_info()


class Mobile:
    def __init__(self, model, company, price=0):
        setattr(self, 'model', model)
        setattr(self, 'company', company)
        setattr(self, 'price', price)

    def print_info(self):
        print(f"Mobile [model: {getattr(self, 'model')}, company: {getattr(self, 'company')}, price: {getattr(self, 'price')}]")


m1 = Mobile('iPhone 15 Pro Max', 'Apple', 206000)
m1.print_info()

m2 = Mobile(company='Samsung', model='S23')
m2.print_info()
