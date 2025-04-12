# functional programming concepts
# - the functions are considered to be the first class citizens
#   - functions are treated as variables
#   - a variable can be declared of type function
# - a function can be passed as an argument to another function
# - a function can be returned as a return value of a function
# - e.g. python, JS, Swift, Kotlin

# in python, if multiple function are defined with same name
# then only the last one (bottom most) will be preserved and
# rest of the function definitions will be discarded

# variable of type int
num = 200
print(f"num = {num}, type = {type(num)}")

# creating another variable using existing one
my_num = num
print(f"my_num = {my_num}, type = {type(my_num)}")

num = 300
print(f"num = {num}, type = {type(num)}")
print(f"my_num = {my_num}, type = {type(my_num)}")


# function definition
# - behind the scene, python will declare a variable
#   named function1 with the type function
def function1():
    """this is a sample function"""
    print("inside function1")
    print("another line added in function1")


# function call
function1()
print(f"function1 = {function1}, type = {type(function1)}")

# create a new variable using existing one
# function alias
# - another name given to the existing function
my_function1 = function1
my_function1()
print(f"my_function1 = {my_function1}, type = {type(my_function1)}")


def function2():
    pass


print(f"function2 = {function2}, type = {type(function2)}")
# function2()


def function3():
    print("1. inside function3")


def function3():
    print("2. inside function3")


function3()
