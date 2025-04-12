# Lambda function
# - anonymous: the one which does not have any name

# named function
# - here get_square is the name of the function
def get_square(number):
    return number ** 2


print(f"square of 5 = {get_square(5)}")


# lambda function
get_square_of_number = lambda number: number ** 2
# print(f"square of 5 = {get_square_of_number(5)}")
# print(f"square of 5 = {5 ** 2}")
# print(f"get_square_of_number = {get_square_of_number}, type = {type(get_square_of_number)}")


cube = lambda n: n ** 3
# print(f"cube of 5 = {cube(5)}")

multiply = lambda x, y: x * y
make_f = lambda t: (t * (9/5)) + 32
print(f"36 in f = {make_f(36)}")


def function1():
    test_lambda = lambda x: x ** 2
    print(f"test_lambda = {test_lambda}")

    def inner():
        pass

    print(f"inner = {inner}")


function1()
