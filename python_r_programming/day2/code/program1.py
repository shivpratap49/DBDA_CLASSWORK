
# variable creation
my_var = 20

# assignment
my_var = 40


num: int = 20
print(f"num = {num}, type = {type(num)}")

# here the str hint will be safely ignored
# the str hint is made for IDE (PyCharm)
name: str = 450
print(f"name = {name.upper()}")

# the data type of my_var is str not the boolean
# my_var: bool = "test"
