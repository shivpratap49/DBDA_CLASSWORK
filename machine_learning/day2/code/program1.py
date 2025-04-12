# install the packages
# - pip3 install numpy pandas matplotlib seaborn scikit-learn pickle4
# - pip install numpy pandas matplotlib seaborn scikit-learn pickle4

# to install multiple packages
# - create a text file named requirements.txt
# - add the names of packages
# - use the command
#   - pip3 install -r requirements.txt
#   - pip install -r requirements.txt

# import the numpy package
import numpy as np
import sys

# ndarray
# - n-dimensional array
# - to create one, use np.array()


def function1():
    # list of numbers
    numbers_list = [10, 20, 30, 40, 50]
    print(f"numbers_list = {numbers_list}, type = {type(numbers_list)}")

    # tuple of numbers
    numbers_tuple = 10, 20, 30, 40, 50
    print(f"numbers_tuple = {numbers_tuple}, type = {type(numbers_tuple)}")

    # array of numbers
    # single dimension array
    numbers_array = np.array([10, 20, 30, 40, 50])
    print(f"numbers_array = {numbers_array}, type = {type(numbers_array)}")


# function1()


def print_array_info(array):
    print(f"no of dimensions = {array.ndim}")
    print(f"no of items in array = {array.size}")
    print(f"memory required to store every item = {array.itemsize} bytes")
    print(f"total memory required to store the whole array = {array.itemsize * array.size} bytes")
    print(f"total memory required to store the whole array = {array.nbytes} bytes")
    print(f"data type of every item = {array.dtype}")
    print(f"shape of array = {array.shape}")
    print(f"flags = {array.flags}")


def function2():
    # array of numbers
    # the size of every number is
    # - 8 bytes (64 bits) for 64-bit processor with 64-bit python version
    # - 4 bytes (32 bits) for 64-bit processor with 32-bit python version
    # - 4 bytes (32 bits) for 32-bit processor with 32-bit python version
    a1 = np.array([10, 20, 30, 40, 50])
    print_array_info(a1)

    print("-" * 80)

    a2 = np.array([10, 20, 30, 40, 50], dtype=np.int32)
    print_array_info(a2)

    print("-" * 80)

    a3 = np.array([10, 20, 30, 40, 50], dtype=np.int16)
    print_array_info(a3)

    print("-" * 80)

    a4 = np.array([10, 20, 30, 40, 50], dtype=np.int8)
    print_array_info(a4)


function2()


def function3():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]
    print(f"memory required to store single item = {sys.getsizeof(numbers[0])} bytes")
    print(f"total memory required to store the whole list = {sys.getsizeof(numbers[0]) * len(numbers)} bytes")


# function3()


def function4():
    # array of numbers
    a1 = np.array([1.5, 2.7, 3.8, 4.9, 5.0])
    print_array_info(a1)

    print("-" * 80)

    a2 = np.array([1.5, 2.7, 3.8, 4.9, 5.0], dtype=np.float32)
    print_array_info(a2)

    print("-" * 80)

    a3 = np.array([1.5, 2.7, 3.8, 4.9, 5.0], dtype=np.float16)
    print_array_info(a3)


# function4()


def function5():
    countries = np.array(["india", "usa", "uk", "japans", "china1234"])
    print_array_info(countries)


# function5()


def function6():
    a1 = np.array([10, 20, 30, 40, 50, 60])
    print(f"value at 0 = {a1[0]}")
    print(f"value at 1 = {a1[1]}")


function6()
