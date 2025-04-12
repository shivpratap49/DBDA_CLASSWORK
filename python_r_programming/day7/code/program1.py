# functional programming using Python
# - functions are considered as first class citizens
# - function can be passed as an argument to another function
#   - e.g. map, filter, reduce
#   - map(function reference, collection):
#     - used to process every value inside a collection
#     - function MUST accept only one parameter
#     - always returns collection with same size as that of the parameter
#     - steps:
#       - runs a loop on the collection
#       - call the function (the one which is passed as param),
#         pass value at every iteration
#       - get the return value from function
#       - adds the return value to a temporary collection
#       - when the loop stops, returns the collection containing all
#         processed values
# - function can be returned as return value of a function


def function1():
    # list of numbers
    numbers = [1, 2, 3, 4, 5]

    # square of each number
    squares = []

    # iterate over the collection
    for number in numbers:

        # processing every value
        square = number ** 2

        # collect the processed value in another collection
        squares.append(square)

    print(f"numbers = {numbers}, squares = {squares}")


# function1()


def function2(param):
    print(f"inside function2")
    print(f"param: {param}, type = {type(param)}")

    # make a call to the function
    param()


# param: 10, type: int
# function2(10)

# num = 10
# function2(num)

# param = function1, type = function
# function2(function1)


def function3():
    numbers = [1, 2, 3, 4, 5]

    def get_square(number):
        return number ** 2

    squares = []
    for number in numbers:
        square = get_square(number)
        squares.append(square)

    print(f"squares = {squares}")


# function3()


def function4():
    numbers = [1, 2, 3, 4, 5]

    def get_square(number):
        print(f"inside get_square, number = {number}")
        return number ** 2

    squares = list(map(get_square, numbers))
    print(f"squares = {squares}")


# function4()


def function5():
    numbers = [1, 2, 3, 4, 5]

    def get_cube(number):
        return number ** 3

    cubes = list(map(get_cube, numbers))
    print(f"cubes = {cubes}")


# function5()


def function6():
    numbers = [1, 2, 3, 4, 5]

    get_square = lambda n: n ** 2
    squares = list(map(get_square, numbers))
    print(f"squares = {squares}")

    cubes = list(map(lambda n: n ** 3, numbers))
    print(f"cubes = {cubes}")


# function6()


def function7():
    temperatures = [32, 30, 34, 36, 38]

    # get_f = lambda t: 32 + (t * (9/5))
    # temperatures_f = list(map(get_f, temperatures))
    # print(f"temperatures_f = {temperatures_f}")

    temperatures_f = list(map(lambda t: 32 + (t * (9 / 5)), temperatures))
    print(f"temperatures_f = {temperatures_f}")


# function7()


def function8():
    numbers = [(1, 1), (2, 4), (3, 9), (4, 16), (5, 25)]

    process_value = lambda t: f"number: {t[0]}, square: {t[1]}"
    result = list(map(process_value, numbers))
    print(f"result = {result}")


# function8()


def function9():
    # list of dictionaries
    persons = [
        {"name": "person1", "age": 30, "address": "pune"},
        {"name": "person2", "age": 10, "address": "mumbai"},
        {"name": "person3", "age": 50, "address": "satara"},
        {"name": "person4", "age": 90, "address": "karad"},
    ]

    # get every person's name from persons collection
    # ["person1", "person2", "person3", "person4"]
    get_name = lambda p: p['name']
    names = list(map(get_name, persons))
    print(f"names = {names}")

    # get every person's name and address
    # [{"name": "person1", "address": "pune"}, ....]

    # select name from persons
    get_name_and_address = lambda p: {"name": p['name'], "address": p['address']}
    result = list(map(get_name_and_address, persons))
    print(f"result = {result}")


# function9()
