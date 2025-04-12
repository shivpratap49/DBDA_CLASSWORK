"""this is a doc string"""

# module
# - any file with .py extension which contains python code
# - python code: collection of variables, constants, functions, classes etc.
# - unit of re-usability
# - the module which gets executed will always get a name as __main__
# - the module when gets imported, get a name same as file name
# types
# - standard libray modules
#   - installed by default when python gets installed
#   - developed by python code developers (internal)
#   - e.g. os, re, json, time etc.
# - custom modules
#   - developed by python developers (external) around the world
#   - need to get installed explicitly using pip/pip3
#   - e.g. numpy, pandas, matplotlib, scikit-learn, flask etc.
# built-in function
# dir(modulename)
# - returns list of functions/variables/constants which can be
#   imported from the module
# - returns contents of modules


def add(p1, p2):
    print(f"inside my_math_operations (add)")
    print(f"{p1} + {p2} = {p1 + p2}")


def subtract(p1, p2):
    print(f"inside my_math_operations (subtraction)")
    print(f"{p1} - {p2} = {p1 - p2}")


PI = 3.14


# execute the code only when this gets executed
# do not execute the code when this module gets imported in others
# this line is not entry point function in python
# python program does not have any entry point function
# python (interpreter) has an entry point function named PyMain()
if __name__ == "__main__":
    add(100, 200)
    print(f"(my_math_operations) module name: {__name__}")
