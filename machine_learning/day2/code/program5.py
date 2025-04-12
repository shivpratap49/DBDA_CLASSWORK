import numpy as np


# broadcast operations
# - operations performed on every element of an array
# - mathematical and comparison operations are broadcast


def function1():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])

    # mathematical operations
    print(f"a1 + 15 = {a1 + 15}")
    print(f"a1 - 15 = {a1 - 15}")
    print(f"a1 / 15 = {a1 / 15}")
    print(f"a1 // 15 = {a1 // 15}")
    print(f"a1 * 15 = {a1 * 15}")


# function1()


def function2():
    # array of numbers
    a1 = np.array([10, 20, 30])
    a2 = np.array([40, 50, 60])

    # mathematical operations
    # rule: both the arrays must have same shape
    print(f"a1 + a2 = {a1 + a2}")
    print(f"a1 - a2 = {a1 - a2}")
    print(f"a1 / a2 = {a1 / a2}")
    print(f"a1 // a2 = {a1 // a2}")
    print(f"a1 * a2 = {a1 * a2}")


# function2()


def function3():
    # array of numbers
    a1 = np.array([10, 20, 30])

    # comparison operations
    print(f"a1 == 10 => {a1 == 10}")
    print(f"a1 > 10 => {a1 > 10}")
    print(f"a1 < 10 => {a1 < 10}")
    print(f"a1 <= 10 => {a1 >= 10}")
    print(f"a1 <= 10 => {a1 <= 10}")
    print(f"a1 != 10 => {a1 != 10}")


# function3()


def function4():
    # filtering the values
    salaries = np.array([20, 50, 56, 60, 70, 80, 85])

    # find the salaries >= 70
    print(f"salaries >= 70 => {salaries >= 70}")
    print(f"salaries[salaries >= 70] => {salaries[salaries >= 70]}")

    print("-" * 80)

    for value in salaries:
        print(f"value = {value}")

    print("-" * 80)

    for index in range(salaries.size):
        print(f"salary = {salaries[index]}")
        

function4()
