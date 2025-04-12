# List collection
# - operations
#   - index(value): used to get the first occurrence of a value
#   - index(value, start): used to get the first occurrence from start position
#   - count(value): used to return the number of occurrence(s) of a value
#   - sort(): used to sort the list in ascending order
#   - sort(reverse=True): used to sort the list in descending order
#   - reverse(): used to reverse the order of the list
#   - copy(): used to deep copy the list

def function1():
    # list of numbers
    numbers = [10, 20, 30, 40, 30, 50, 30]

    # get the count of the 30
    print(f"30 is present {numbers.count(30)} times")

    # get the index of first occurrence of 30
    print(f"30 is present on {numbers.index(30)} index")
    # print(f"30 is present on {numbers.index(30, 0)} index")

    # get the index of second occurrence of 30
    print(f"30 is present on {numbers.index(30, 3)} index")

    # get the index of third occurrence of 30
    print(f"30 is present on {numbers.index(30, 5)} index")


# function1()


def function2():
    # list of numbers
    numbers = [40, 10, 20, 50, 30]
    print(numbers)

    # sort the values in ascending order
    numbers.sort()
    print(numbers)

    # sort the value in descending order
    numbers.sort(reverse=True)
    print(numbers)


# function2()


def function3():
    # list of numbers
    numbers = [40, 10, 20, 50, 30]
    print(numbers)

    # reverse the list
    numbers.reverse()
    print(numbers)


# function3()


def function4():
    # list of numbers
    numbers1 = [10, 20, 30, 40, 50]
    print(f"numbers1 = {numbers1}")

    # create a new list using existing one
    # this will copy the reference and both numbers1 and numbers2
    # will refer the same memory location
    # if one is updated, you will see the changes in the second one as well
    # also referred as shallow copy
    numbers2 = numbers1
    print(f"numbers2 = {numbers2}")

    numbers1.append(60)
    print(f"numbers1 = {numbers1}")
    print(f"numbers2 = {numbers2}")


# function4()


def function5():
    # list of numbers
    numbers1 = [10, 20, 30, 40, 50]
    print(f"numbers1 = {numbers1}")

    # create a NEW copy of existing list
    # also referred as deep copy
    numbers2 = numbers1.copy()
    print(f"numbers2 = {numbers2}")

    numbers1.append(60)
    print(f"numbers1 = {numbers1}")
    print(f"numbers2 = {numbers2}")


function5()
