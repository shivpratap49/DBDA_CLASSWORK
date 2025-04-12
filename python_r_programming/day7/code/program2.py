# filter(function reference, collection)
# - used to filter value(s) based on a condition
# - function MUST accept only one parameter
# - function MUST return a boolean result
# - always returns collection with same or less size than original collection
# - steps:
#   - runs a loop on the collection
#   - call the function (the one which is passed as param),
#     pass value at every iteration
#   - check the return value from function
#   - if the returned value is True,
#     it adds the original value to a temporary collection
#   - when the loop stops, returns the temporary collection
# RULE:
# - always perform filter() first and then map()

def function1():
    # list of numbers
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    # get only even numbers from the collection

    # create a collection to store the result
    even_numbers = []

    # iterate over the collection
    for number in numbers:

        # perform the condition
        if number % 2 == 0:

            # only when the condition is True
            # add the original value to the result collection
            even_numbers.append(number)

    print(f"numbers = {numbers}")
    print(f"even numbers: {even_numbers}")


# function1()


def function2():
    # list of numbers
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    def is_even(number):
        return number % 2 == 0

    even_numbers = []
    for number in numbers:
        if is_even(number):
            even_numbers.append(number)

    print(f"numbers = {numbers}")
    print(f"even numbers: {even_numbers}")


# function2()


def function3():
    # list of numbers
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    is_even = lambda n: n % 2 == 0
    even_numbers = list(filter(is_even, numbers))
    print(f"even_numbers = {even_numbers}")


# function3()


def function4():
    # list of numbers
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    # get all odd values
    is_odd = lambda n: n % 2 != 0
    odd_numbers = list(filter(is_odd, numbers))
    print(f"odd numbers = {odd_numbers}")


# function4()


def function5():
    # list of dictionaries
    persons = [
        {"name": "person1", "age": 30, "address": "pune"},
        {"name": "person2", "age": 10, "address": "mumbai"},
        {"name": "person3", "age": 50, "address": "satara"},
        {"name": "person4", "age": 90, "address": "karad"},
    ]

    # get the persons eligible for voting
    # select * from persons where age >= 18
    can_vote = lambda p: p['age'] >= 18
    persons_eligible_for_voting = list(filter(can_vote, persons))
    print(f"persons_eligible_for_voting = {persons_eligible_for_voting}")

    # get the persons NOT eligible for voting
    can_not_vote = lambda p: p['age'] < 18
    persons_not_eligible_for_voting = list(filter(can_not_vote, persons))
    print(f"persons_not_eligible_for_voting = {persons_not_eligible_for_voting}")


# function5()


def function6():
    # list of dictionaries
    persons = [
        {"name": "person1", "age": 30, "address": "pune"},
        {"name": "person2", "age": 10, "address": "mumbai"},
        {"name": "person3", "age": 50, "address": "satara"},
        {"name": "person4", "age": 90, "address": "karad"},
    ]

    # get the persons eligible for voting
    can_vote = lambda p: p['age'] >= 18
    persons_eligible_for_voting = list(filter(can_vote, persons))
    print(f"persons_eligible_for_voting = {persons_eligible_for_voting}")

    # select name from persons where age >= 18
    # get names of persons eligible for voting
    get_name = lambda p: p['name']
    names = list(map(get_name, persons_eligible_for_voting))
    print(f"names = {names}")


function6()

