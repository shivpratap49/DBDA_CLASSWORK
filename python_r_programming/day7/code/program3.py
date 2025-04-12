# comprehension
# - replacement for map and filter
# - has simple syntax than map and filter
# - types
#   - list comprehension
#     - always returns a list
#   - tuple comprehension
#     - always returns a generator object
#   - dictionary comprehension
# - parts
#   - projection
#     - the value to be returned
#   - loop
#     - the for loop used to iterate over the collection
#   - selection or condition
#     - the condition used to filter the values
# - syntax
#   - [<projection> <loop> <selection>]
# - e.g.
#   - [n ** 2 for n in numbers]
#   - [n for n in numbers if n % 2 != 0]
#   - [n ** 2 for n in numbers if n % 2 != 0]



def function1():
    numbers = [1, 2, 3, 4, 5]
    # squares = []
    # for n in numbers:
    #     squares.append(n ** 2)

    # get_square = lambda n: n ** 2
    # squares = list(map(get_square, numbers))
    # print(f"squares = {squares}")

    # list comprehension replacing use of map()
    squares = [n ** 2 for n in numbers]
    print(f"squares = {squares}")

    cubes = [n ** 3 for n in numbers]
    print(f"cubes = {cubes}")

    result = [n * 10 for n in numbers]
    print(f"result = {result}")

    temperatures = [32, 30, 34, 36, 38]
    temperatures_f = [32 + (t * (9/5)) for t in temperatures]
    print(f"temperatures_f = {temperatures_f}")


# function1()


def function2():
    # list of numbers
    numbers = [1, 2, 3, 5, 6, 7, 8, 9, 10]

    # even_numbers = []
    # for n in numbers:
    #     if n % 2 == 0:
    #         even_numbers.append(n)

    # get all even numbers
    # is_even = lambda n: n % 2 == 0
    # even_numbers = list(filter(is_even, numbers))
    # print(f"even numbers = {even_numbers}")

    # list comprehension to replace a filter()
    even_numbers = [n for n in numbers if n % 2 == 0]
    print(f"even numbers = {even_numbers}")


# function2()


def function3():
    # list of numbers
    numbers = [1, 2, 3, 5, 6, 7, 8, 9, 10]

    # square of even numbers
    # is_even = lambda n: n % 2 == 0
    # even_numbers = list(filter(is_even, numbers))
    #
    # get_square = lambda n: n ** 2
    # squares = list(map(get_square, even_numbers))
    # print(f"even numbers = {even_numbers}, squares = {squares}")

    # even_numbers = [n for n in numbers if n % 2 == 0]
    # square_of_even_numbers = [n ** 2 for n in even_numbers]

    square_of_even_numbers = [n ** 2 for n in numbers if n % 2 == 0]
    print(f"square_of_even_numbers : {square_of_even_numbers}")

    # cube of odd numbers
    is_odd = lambda n: n % 2 != 0
    get_cube = lambda n: n ** 3
    cube_of_odd_numbers = [get_cube(n) for n in numbers if is_odd(n)]
    print(f"cube_of_odd_numbers = {cube_of_odd_numbers}")


# function3()


def function4():
    # list of dictionaries
    persons = [
        {"name": "person1", "age": 30, "address": "pune"},
        {"name": "person2", "age": 10, "address": "mumbai"},
        {"name": "person3", "age": 50, "address": "satara"},
        {"name": "person4", "age": 90, "address": "karad"},
    ]

    # get names of all persons
    names = [p['name'] for p in persons]
    print(f"names = {names}")

    # get the list of persons eligible for voting
    persons_eligible_for_voting = [p for p in persons if p['age'] >= 18]
    print(f"persons_eligible_for_voting = {persons_eligible_for_voting}")

    # get names of persons not eligible for voting
    names_of_persons_not_eligible_for_voting = [p['name'] for p in persons if p['age'] < 18]
    print(f"names_of_persons_not_eligible_for_voting = {names_of_persons_not_eligible_for_voting}")


# function4()


def function5():
    numbers = [1, 2, 3, 4, 5]

    # tuple comprehension
    squares = tuple(n ** 2 for n in numbers)
    print(f"squares = {squares}")


# function5()






