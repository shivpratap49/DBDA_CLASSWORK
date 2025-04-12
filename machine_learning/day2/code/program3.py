import numpy as np

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


def function1():
    # array of numbers
    a1 = np.array([10, 20, 30, 40, 50])
    print_array_info(a1)


# function1()


def function2():
    # create an array with arange
    # (start, stop, step)

    a1 = np.arange(0, 10)
    print(f"a1 = {a1}")

    # start has default value set to 0
    a2 = np.arange(10)
    print(f"a2 = {a2}")

    # step is 2
    a3 = np.arange(0, 10, 2)
    print(f"a3 = {a3}")


# function2()


def function3():
    # 1d array with 1 as float values
    a1 = np.ones(5)
    print(f"a1 = {a1}")

    # 1d array with 1 as int values
    a2 = np.ones(5, dtype=np.int8)
    print(f"a2 = {a2}")

    # 2d array with all ones
    a3 = np.ones([3, 2])
    print(f"a3 = {a3}")


# function3()


def function4():
    # 1d array with 0 as float values
    a1 = np.zeros(5)
    print(f"a1 = {a1}")

    # 1d array with 1 as int values
    a2 = np.zeros(5, dtype=np.int8)
    print(f"a2 = {a2}")

    # 2d array with all ones
    a3 = np.zeros([3, 2])
    print(f"a3 = {a3}")


# function4()


def function5():
    # array with random numbers
    a1 = np.random.random(5)
    print(f"a1 = {a1}")

    # array with random 5 integers between 10 and 20
    a2 = np.random.randint(10, 20, 5)
    print(f"a2 = {a2}")


# function5()


def function6():
    a1 = np.array([10, 20, 30, 40, 50])
    print(f"mean = {a1.mean()}")
    print(f"min = {a1.min()}")
    print(f"max = {a1.max()}")
    print(f"standard deviation = {a1.std()}")


# function6()
