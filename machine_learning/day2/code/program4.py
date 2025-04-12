import numpy as np


def function1():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])

    # positive indexing
    print(f"a1[0] = {a1[0]}")
    print(f"a1[1] = {a1[2]}")
    print(f"a1[a1.size - 1] = {a1[a1.size - 1]}")


# function1()


def function2():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])

    # negative indexing
    print(f"a1[-1] = {a1[-1]}")
    print(f"a1[-2] = {a1[-2]}")
    print(f"a1[-a1.size] = {a1[-a1.size]}")


# function2()


def function3():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])

    # multiple indexing
    print(f"a1[[0, 1, 4]] = {a1[[0, 1, 4]]}")

    # [30, 40, 10]
    print(f"a1[[2, 3, 0]] = {a1[[2, 3, 0]]}")

    # [50, 40, 40]
    print(f"a1[[-1, 3, -2]] = {a1[[-1, 3, -2]]}")


# function3()


def function4():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])

    # [20, 40]

    # positive integer indexing
    print(f"a1[[1, 3]] = {a1[[1, 3]]}")

    # negative integer indexing
    print(f"a1[[-4, -2]] = {a1[[-4, -2]]}")

    # boolean indexing
    print(f"a1[[False, True, False, True, False]] = {a1[[False, True, False, True, False]]}")


# function4()


def function5():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])

    # [20, 30, 40]
    print(f"a1[1:4] = {a1[1:4]}")

    # [20, 30, 40, 50]
    print(f"a1[1:] = {a1[1:]}")

    # [10, 20, 30]
    print(f"a1[:3] = {a1[:3]}")

    # [10, 20, 30, 40, 50]
    print(f"a1[:] = {a1[:]}")


# function5()

