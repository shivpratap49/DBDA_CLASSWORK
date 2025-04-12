# List Indexing
# - positive indexing
#   - using positive index value to get a value from list
# - range(): used to generate sequential values (numbers)
#   - returns a generator which generate the values
#   - start: the starting position (default 0)
#   - stop: upper bound (not included in the list)
#   - step: count to generate the next value (default 1)


def function1():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]

    # get all the values
    print(f"value at 0 => {numbers[0]}")
    print(f"value at 1 => {numbers[1]}")
    print(f"value at 2 => {numbers[2]}")
    print(f"value at 3 => {numbers[3]}")
    print(f"value at 4 => {numbers[4]}")

    # this will raise an exception named IndexError
    # print(f"value at 5 => {numbers[5]}")

    # this will raise an exception named TypeError
    # print(f"value at 1.5 => {numbers[1.5]}")


# function1()


def function2():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]

    # list of index positions
    index_positions = [1, 2, 3]

    # for number in numbers:
    #     print(f"number = {number}")

    for index in index_positions:
        print(f"value at {index} = {numbers[index]}")


# function2()


def function3():
    # list of strings
    names = ["steve jobs", "bill gates", "steve balmer", "elon musk"]
    index_positions = [0, 1, 2, 3]

    for index in index_positions:
        print(f"name at {index} = {names[index]}")


# function3()


def function4():
    # generate a sequence of values from 0 to 10
    # index_positions = list(range(0, 10))
    # print(index_positions)

    print(f"range(0, 10, 1) => {list(range(0, 10, 1))}")
    print(f"range(0, 10) => {list(range(0, 10))}")
    print(f"range(10) => {list(range(10))}")

    print('-' * 80)

    print(f"range(0, 10, 2) => {list(range(0, 10, 2))}")
    print(f"range(1, 10, 2) => {list(range(1, 10, 2))}")
    print(f"range(10, 0, -1) => {list(range(10, 0, -1))}")


# function4()


def function5():
    # list of numbers
    numbers = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

    # generate a sequence of index positions
    # index_positions = range(0, len(numbers), 2)

    for index in range(0, len(numbers), 2):
        print(f"value at {index} = {numbers[index]}")


# function5()


def function6():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]

    for number in numbers:
        print(f"number = {number}")

    print('-' * 80)

    for index in range(len(numbers)):
        print(f"value at {index} = {numbers[index]}")


# function6()

