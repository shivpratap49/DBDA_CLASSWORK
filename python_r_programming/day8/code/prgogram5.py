# decorator
# - closure which will be called before a function (automatically)
# - is a function returning inner function reference
# - requirements
#   - outer function (log) must accept a function type parameter
#   - inner function must be a variable length argument function
#   - inner function must make a call to the function parameter
#     received in outer function

def log(function):
    def inner(*args, **kwargs):
        with open("logs.txt", "a") as file:
            file.write(f"calling {function.__name__}\n")
            file.write(f"parameters = {args}, {kwargs}\n")
            file.write('-' * 80)
            file.write("\n")

            # call the function
            function(*args, **kwargs)

    return inner


@log
def function1():
    print("inside function1")


@log
def function2(p1):
    print("inside function2")
    print(f"p1 = {p1}")


@log
def function3(p1, p2):
    print("inside function2")
    print(f"p1 = {p1}, p2 = {p2}")


function1()
function2(20)
function3(20, 40)
