# class
# - collection of data and member functions (methods) associated with the data
# - template or blueprint used to create objects
# - to create a class, use keyword class

# object
# - also known as instance of a class
# - collection of data (attribute-value pair)
# - can be created only from a class
# - gets a memory to store the data
# - creation of an object is also known as instantiation of a class
# - every object must have an identity (every object is unique)
#   - when a new object gets created, it will always get a new memory address
# - store all the data in dictionary format

# built-in functions
# - setattr(<reference>, <attr name>, <value>)
#   - used to add a new attribute with its value in an object
#   - also used to update the value of an attribute
# - getattr(<reference>, <attr name>)
#   - used to get a value of an attribute from an object

# empty class
class Person:
    pass


# create an object of Person
# p:
# - reference
# - which stores the address of the object of type Person
# - gets stored on stack
# Person():
# - used to create an object of type Person
# - the object's memory will be allocated on heap section
p = Person()
print(f"p = {p}, type = {type(p)}")

# add person's name
setattr(p, "first_name", "steve")
setattr(p, "last_name", "jobs")

# get the data from the object
print(f"first name = {getattr(p, 'first_name')}")
print(f"last name = {getattr(p, 'last_name')}")


class Mobile:
    pass


# create first object
m1 = Mobile()
print(f"m1 = {m1}, type = {type(m1)}")
setattr(m1, 'model', 'iPhone 15 Pro Max')
setattr(m1, 'company', 'Apple')
print(f"model: {getattr(m1, 'model')}")
print(f"company: {getattr(m1, 'company')}")

# create second object
m2 = Mobile()
print(f"m2 = {m2}, type = {type(m2)}")
setattr(m2, 'mobile_model', 'S23')
setattr(m2, 'mobile_company', 'Samsung')
print(f"model: {getattr(m2, 'mobile_model')}")
print(f"company: {getattr(m2, 'mobile_company')}")
print(f"dictionary format = {m2.__dict__}")


# this line will create an object without a reference
# - such object is known as anonymous object
# - such objects can be used only once as there no reference
#   to refer the object again
# print(f"address of an object = {Mobile()}")


def test_function():
    print(f"inside test_function")


import threading

# threading.Thread() creates an object of Thread class
# t1 = threading.Thread(target=test_function)
# t1.start()

# threading.Thread() will create an anonymous object
# threading.Thread(target=test_function).start()
Mobile()
Mobile()
Mobile()

