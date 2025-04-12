# List Slicing
# - getting a sequentially indexed values
# - always returns a new list
# - syntax
#   - collection[start:stop:step]
#   - default value of start is 0
#   - default value of stop is last position
#   - default value of step is 1


def function1():
    # list of numbers
    numbers = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

    # [20, 30, 40, 50]
    final_values = []
    for index in range(1, 5):
        final_values.append(numbers[index])

    print(f"final values = {final_values}")


# function1()


def function2():
    # list of numbers
    numbers = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

    # [20, 30, 40, 50]
    print(f"numbers[1:5] = {numbers[1:5]}")
    print(f"numbers[1:5:1] = {numbers[1:5:1]}")

    print('-' * 80)

    # [10, 20, 30, 40, 50]
    print(f"numbers[0:5:1] = {numbers[0:5:1]}")
    print(f"numbers[0:5] = {numbers[0:5]}")
    print(f"numbers[:5] = {numbers[:5]}")

    print('-' * 80)

    # [70, 80, 90, 100]
    print(f"numbers[6:10:1] = {numbers[6:10:1]}")
    print(f"numbers[6:10] = {numbers[6:10]}")
    print(f"numbers[6:] = {numbers[6:]}")

    print('-' * 80)

    # get the values on even and odd positions
    print(f"numbers[0:10:2] = {numbers[0:10:2]}")
    print(f"numbers[1:10:2] = {numbers[1:10:2]}")

    print('-' * 80)

    # get all values
    print(f"numbers[0:10:1] = {numbers[0:10:1]}")
    print(f"numbers[0:10] = {numbers[0:10]}")
    print(f"numbers[0:] = {numbers[0:]}")
    print(f"numbers[:] = {numbers[:]}")

    print('-' * 80)

    # return a new list with reserved order of the values
    print(f"numbers[::-1] = {numbers[::-1]}")


function2()

