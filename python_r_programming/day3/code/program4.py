# List collection
# - collection of similar or dissimilar values
# - uses Linked List to store the data
# - the list index starts from Zero
# functions:
# - len(): used to get the count of values in a list
# - append(): used to append (add a value at the end of the collection)
# - insert(): used to insert a value at any position in the list
# - extend(): used to add multiple values at the end of the collection

def function1():
    # declare an empty list using []
    list1 = []
    print(f"list1 = {list1}, type = {type(list1)}")

    # declare an empty list using list()
    # list() is a function used to convert any collection to list
    list2 = list([])
    print(f"list2 = {list2}, type = {type(list2)}")


# function1()


def function2():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(f"numbers = {numbers}, type = {type(numbers)}")
    print(f"value at 0 = {numbers[0]}")
    print(f"value at 1 = {numbers[1]}")
    print(f"value at 2 = {numbers[2]}")
    print(f"value at 3 = {numbers[3]}")
    print(f"value at 4 = {numbers[4]}")

    print(f"-" * 80)

    # list of strings
    countries = ["india", "usa", "uk", "japan"]
    print(f"countries = {countries}, type = {type(countries)}")
    print(f"value at 0 = {countries[0]}")
    print(f"value at 1 = {countries[1]}")
    print(f"value at 2 = {countries[2]}")
    print(f"value at 3 = {countries[3]}")

    print(f"-" * 80)

    # list of dissimilar values
    mixed_values = [10, 40.50, True, "india", "steve", 40, 15.60, False]
    print(f"mixed_values = {mixed_values}, type = {type(mixed_values)}")


# function2()


def function3():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(numbers)

    # get the length of list
    print(f"count of numbers = {len(numbers)}")

    # appending a value
    # adding a value at the end of the list
    numbers.append(60)
    print(numbers)

    numbers.append(70)
    print(numbers)

    numbers.append(80)
    print(numbers)


# function3()


def function4():
    # list of strings
    countries = ["india"]
    print(countries)

    # append a value
    countries.append("usa")
    print(countries)

    countries.append("uk")
    print(countries)

    countries.append("japan")
    print(countries)


# function4()


def function5():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(numbers)

    # insert 15 between 10 and 20
    numbers.insert(1, 15)
    print(numbers)

    # insert 25 between 20 and 30
    numbers.insert(3, 25)
    print(numbers)


# function5()


def function6():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(f"numbers = {numbers}, length = {len(numbers)}")

    # numbers.append([60, 70, 80, 90, 100])
    # numbers.append(60)
    # numbers.append(70)
    # numbers.append(80)
    # numbers.append(90)
    # numbers.append(100)

    # append 60, 70, 80, 90, 100
    numbers.extend([60, 70, 80, 90, 100])
    print(f"numbers = {numbers}, length = {len(numbers)}")


function6()

