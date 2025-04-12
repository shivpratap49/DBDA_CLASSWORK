# multi-dimensional collection
# - collection of collections
# - list of lists
# - list of tuples
# - tuple of tuples
# - tuple of lists

# mutable vs immutable
# - mutable is slower than immutable
# - mutable need to keep the track of all the values which can be mutated

# list vs tuple
# - list uses linked list to store the values
#   tuple use flat list to store the values
# - list is slower as it has to traverse the linked list to get a value
#   tuple is faster as it can directly jump to the location
# - the values in a list are not stored contiguously
#   in tuple, the values are stored contiguously


def function1():
    # single dimensional collection
    numbers = [10, 20, 30, 40, 50]
    # print(f"value at 3rd position = {numbers[3]}")
    for number in numbers:
        print(f"number = {number}")

    print('-' * 80)

    # list of lists
    # size: 3x3
    numbers2 = [
        [10, 20, 30],
        [40, 50, 60],
        [70, 80, 90]
    ]
    # print(f"value at [1][0] = {numbers2[1][0]}")

    for values in numbers2:
        for value in values:
            print(value)
        print()


# function1()


def function2():
    # single dimensional
    # numbers2 = [30, 40, 50, 60]
    # numbers2.pop()

    # there is NO restriction to have same number of columns in every row
    # - a collection may have different columns per row
    # list of lists
    numbers = [
        [10, 20],
        [30, 40, 50, 60],
        [70, 80, 90]
    ]
    print(numbers)

    # append a new list
    numbers.append([100, 110, 120, 130, 140, 150])
    print(numbers)

    print(f"value at numbers[1] = {numbers[1]}")
    print(f"value at numbers[1][3] = {numbers[1][3]}")
    # remove value 60 (from [1][3])
    numbers[1].pop()
    print(numbers)

    # insert value  85 between 80 and 90
    numbers[2].insert(2, 85)
    print(numbers)


# function2()


def function3():
    # list of tuples
    numbers = [
        (10, 20),
        (30, 40, 50, 60),
        (70, 80, 90)
    ]
    print(numbers)

    # append a new tuple at the end
    numbers.append((100, 110, 120, 130, 140, 150))
    print(numbers)

    # CAN NOT remove value 60 as the values are stored in a tuple
    # numbers[1].pop()
    # print(numbers)


# function3()


def function4():
    # tuple of tuples
    numbers = (
        (10, 20),
        (30, 40, 50, 60),
        (70, 80, 90, 100)
    )
    print(numbers)

    # CAN NOT append a new tuple at the end
    # numbers.append((100, 110, 120, 130, 140, 150))
    # print(numbers)

    # CAN NOT remove value 60 as the values are stored in a tuple
    # numbers[1].pop()
    # print(numbers)


# function4()


def function5():
    # tuple of lists
    numbers = (
        [10, 20],
        [30, 40, 50, 60],
        [70, 80, 90, 100]
    )

    # CAN NOT append a new tuple at the end
    # numbers.append((100, 110, 120, 130, 140, 150))
    # print(numbers)

    # CAN NOT remove value 60 as the values are stored in a tuple
    numbers[1].pop()
    print(numbers)

    # this will remove all the values from last collection [70, 80, 90, 100]
    # but it will keep the empty list at the end
    # and it is not possible to remove this list since tuple is immutable
    numbers[2].clear()
    print(numbers)


# function5()


def function6():
    # tuple of numbers
    t1 = (10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

    # positive indexing
    print(f"value at 5th index = {t1[5]}")

    # negative indexing
    print(f"last value = {t1[-1]}")

    # slicing
    print(f"t1[:5] = {t1[:5]}")
    print(f"t1[5:] = {t1[5:]}")
    print(f"t1[:] = {t1[:]}")


function6()