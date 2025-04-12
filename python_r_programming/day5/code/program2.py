# variable length argument function
# - to create a VA function
#   - use a parameter with * symbol
#   - def function(*args, **kwargs): ...
#   - args
#     - args is NOT a pointer
#     - is a tuple to collect all positional arguments
#     - args is just a parameter (you can replace args with any name)
#     - args is a tuple which collects all arguments
#   - kwargs:
#     - is a dictionary to collect all named arguments


def add2(p1, p2):
    result = p1 + p2
    print(f"addition = {result}")


# add2(10, 20)


def add(*args, **kwargs):
    print(f"args = {args}, type = {type(args)}")
    print(f"kwargs = {kwargs}, type = {type(kwargs)}")
    addition = 0
    for value in args:
        addition += value
    print(f"addition = {addition}")


# add(10)
# add(10, 20)
# add(10, 20, 30)
# add(10, 20, 30, 40)
# add(10, 20, 30, 40, 50)
# add(10, 20, 30, 40, 50, 60)
# add(value1=10, value2=20)
# add(10, 20, 30, value1=40, value2=50)

# invalid way to pass arguments
# add(value1=40, value2=50, 10, 20, 30)

def my_function(args):
    print(f"args = {args}, type = {type(args)}")


# my_function(10)
# my_function([10, 20])


def function1():
    print("hello world")
    print("hello world")
    print("hello world")
    print("hello world")
    print("hello world")

    print('-' * 80)

    print('hello world\n' * 5)

    print('-' * 80)

    for index in range(5):
        print("hello world")


# function1()


def function2(p1, p2):
    print("inside function2")
    print(f"p1 = {p1}, p2 = {p2}")


# positional arguments
# function2(10, 20)
# function2(20, 10)

# named arguments
# function2(p1=10, p2=20)
# function2(p2=20, p1=10)

# mixed
# first arguments must be positional and named will follow later
# function2(10, p2=20)

# this does not work
# function2(p2=20, 10)


# r: interest rate with default value of 7.5
# since r has a default value, caller need not to pass every time
# which makes the r parameter optional
def calculate_simple_interest(n, p, r=7.5):
    print("inside calculate_simple_interest")
    print(f"n = {n}, p = {p}, r = {r}")

    interest = (n * p * r) / 100
    print(f"interest = {interest}")


# since r value is passed, 9.5 will set considered as value of r
# calculate_simple_interest(10, 100000, 9.5)

# since r value is NOT passed,
# 7.5 (default value) will set considered as value of r
# calculate_simple_interest(5, p=100000)



