# List collection
# - operations
#   - pop(): used to remove the last value
#   - pop(index): used to remove the value at the specified index
#   - remove(value): used to remove a value
#   - count(value): used to return the number of occurrence(s) of a value
#   - clear(): used to remove all the values from list

def function1():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(numbers)

    # remove the last value
    value_removed = numbers.pop()
    print(f"value removed = {value_removed}")
    print(numbers)

    numbers.pop()
    print(numbers)

    numbers.pop()
    print(numbers)

    numbers.pop()
    print(numbers)

    numbers.pop()
    print(numbers)

    # application will crash if the list is empty
    # make sure that the len of list is > 0 before calling pop()
    # numbers.pop()
    # print(numbers)


# function1()


def function2():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(numbers)

    # remove a value at 2nd position
    numbers.pop(2)
    print(numbers)

    # remove a value at 2nd position
    numbers.pop(2)
    print(numbers)

    # remove a value at 2nd position
    numbers.pop(2)
    print(numbers)

    # remove a value at 2nd position
    # if index does not exist, the application will crash with IndexError exception
    # numbers.pop(2)
    # print(numbers)


# function2()


def function3():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(numbers)

    # remove 30 from numbers list
    numbers.remove(30)
    print(numbers)

    # remove 30 from numbers list
    # if value does not exist, the application will crash with ValueError
    # make sure that the value exists before calling remove function
    # numbers.remove(30)
    # print(numbers)


# function3()


def function4():
    # list of numbers
    numbers = [10, 20, 30, 40, 30, 50, 30]
    print(numbers)

    # remove value 30
    # will remove the first occurrence of 30
    numbers.remove(30)
    print(numbers)

    # will remove the second occurrence of 30
    numbers.remove(30)
    print(numbers)

    # will remove the third occurrence of 30
    numbers.remove(30)
    print(numbers)


# function4()


def function5():
    # list of numbers
    numbers = [10, 20, 30, 40, 30, 50, 30]
    print(numbers)

    # get the number of occurrences of a value
    print(f"number of times value 30 is present = {numbers.count(30)}")
    print(f"number of times value 10 is present = {numbers.count(10)}")


# function5()


def function6():
    countries = ["india", "usa", "uk", "china", "japan"]
    print(countries)

    # remove china
    countries.remove("china")
    print(countries)


# function6()


def function7():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(numbers)

    # remove all the values from collection
    numbers.clear()
    print(numbers)


# function7()



