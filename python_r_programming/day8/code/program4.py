def log(function):
    # print("inside log function")

    def inner(*args, **kwargs):
        # print("inside inner function")
        with open("logs.txt", "a") as file:
            file.write(f"calling : {function.__name__}\n")
            file.write(f"args = {args}\n")
            file.write(f"kwargs = {kwargs}\n")
            file.write('-' * 80)
            file.write('\n')

        function(*args, **kwargs)

    return inner


def function1(p1, p2):
    pass


# inner_function_reference = log(function1)
# inner_function_reference(10, 20)

# int num = 100;
# num: int = 100;

@log
def add(p1, p2):
    print(f"{p1} + {p2} = {p1 + p2}")


@log
def divide(p1, p2):
    print(f"{p1} / {p2} = {p1 / p2}")


@log
def make_square(number):
    print(f"square of number = {number ** 2}")


add(10, 20)
# inner_function_reference = log(add)
# inner_function_reference(10, 20)

print('-' * 80)

divide(10, 20)
# inner_function_reference = log(divide)
# inner_function_reference(10, 0)

print('-' * 80)

make_square(4)


@log
def function2():
    print("inside function2")


function2()