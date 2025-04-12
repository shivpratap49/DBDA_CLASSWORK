import numpy as np


def function1():
    # multi-dimensional list
    numbers_list = [
        [10, 20],
        [30, 40],
        [50, 60]
    ]
    print(f"numbers_list = {numbers_list}, type = {type(numbers_list)}")

    # multi-dimensional array
    numbers_array = np.array([
        [10, 20],
        [30, 40],
        [50, 60]
    ])
    print(f"numbers_array = {numbers_array}, type = {type(numbers_array)}")


# function1()


def print_array_info(array):
    print(array)
    print(f"no of dimensions = {array.ndim}")
    print(f"no of items in array = {array.size}")
    print(f"memory required to store every item = {array.itemsize} bytes")
    print(f"total memory required to store the whole array = {array.itemsize * array.size} bytes")
    print(f"total memory required to store the whole array = {array.nbytes} bytes")
    print(f"data type of every item = {array.dtype}")
    print(f"shape of array = {array.shape}")
    print("-" * 80)


def function2():
    # 2d array
    a1 = np.array([
        [10, 20],
        [30, 40],
        [50, 60]
    ])
    print_array_info(a1)
    print(a1[0])
    print(a1[0][0])

    # every row must have same number of columns
    # a2 = np.array([
    #     [10, 20],
    #     [30, 40, 50],
    #     [60, 70, 80, 90]
    # ])
    # print_array_info(a2)


# function2()


def function3():
    # 1d array
    a1 = np.array([10, 20, 30, 40, 50, 60])
    print_array_info(a1)

    # 2d array
    a2 = a1.reshape([2, 3])
    print_array_info(a2)

    # 2d array
    a3 = a1.reshape([3, 2])
    print_array_info(a3)

    # 2d array
    a4 = a1.reshape([1, 6])
    print_array_info(a4)

    # 2d array
    a5 = a1.reshape([6, 1])
    print_array_info(a5)


function3()
