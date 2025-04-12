import numpy as np
import pandas as pd

# pandas uses numpy behind the scene


def function1():
    # list of numbers
    numbers_list = [10, 20, 30, 40, 50]
    print(f"numbers_list = {numbers_list}, type = {type(numbers_list)}")

    # tuple of numbers
    numbers_tuple = 10, 20, 30, 40, 50
    print(f"numbers_tuple = {numbers_tuple}, type = {type(numbers_tuple)}")

    # array of numbers
    numbers_array = np.array([10, 20, 30, 40, 50])
    print(f"numbers_array = {numbers_array}, type = {type(numbers_array)}")

    # series of numbers
    numbers_series = pd.Series([10, 20, 30, 40, 50])
    print(numbers_series)
    print(f"type of numbers_series = {type(numbers_series)}")


# function1()


def print_series_info(s1):
    print(s1)
    print(f"# dimensions = {s1.ndim}")
    print(f"size = {s1.size}")
    print(f"shape = {s1.shape}")
    print(f"data type = {s1.dtype}")
    print(f"total memory required = {s1.nbytes} bytes")
    print(f"values = {s1.values}")
    print(f"indexes = {s1.index}")
    print("-" * 80)


def function2():
    # series using list
    s1 = pd.Series([10, 20, 30, 40, 50], dtype=np.int32)
    print_series_info(s1)

    # series using tuple
    s2 = pd.Series((10, 20, 30, 40, 50))
    print_series_info(s2)

    # series using set is not possible
    # this line will crash the application
    # as the set is unordered collection of unique values
    # s3 = pd.Series({10, 20, 30, 40, 50})
    # print_series_info(s3)

    # series using a dictionary
    s4 = pd.Series({"name": "person1", "age": 30, "address": "pune"})
    print_series_info(s4)


# function2()


def function3():
    # in Series, the qualitative data is using dtype as object
    models = pd.Series(["triber", "nano", "X5", "XUV700"])
    print(models)

    print(f"models[0] = {models[0]}")
    print(f"models[1] = {models[1]}")
    print(f"models[2] = {models[2]}")
    print(f"models[3] = {models[3]}")


# function3()


def function4():
    # in Series, the qualitative data is using dtype as object
    companies = ["renault", "tata", "BMW", "Mahindra"]

    # the values stored in the series are the models
    # and the index of every model is one company
    models = pd.Series(["triber", "nano", "X5", "XUV700"], index=companies)
    print(models)

    # since index 0 does not exist, the following line would raise an exception
    # print(models[0])

    # what is the model of tata
    # this would return only one value
    print(f"model of tata = {models['tata']}")

    # what is the model of mahindra
    # this would return only one value
    print(f"model of mahindra = {models['Mahindra']}")


# function4()


def function5():
    models = ["triber", "nano", "X5", "XUV700"]

    # the values stored in the series are the companies
    # and the index of every company is one model
    companies = pd.Series(["renault", "tata", "BMW", "Mahindra"], index=models)
    print(companies)

    # what is the name of company of triber model
    print(f"triber is manufactured by {companies['triber']}")


# function5()


def function6():
    companies = ["apple", "apple", "apple", "samsung", "xaomi"]
    models = pd.Series(
        ["iphone 16", "iphone 16 pro", 'iphone 16 pro max', "S23 Ultra", "Notebook"],
        index=companies)
    print(models)

    # what are the models manufactured by Apple
    # this would return a series having the models
    print(f"model(s) = {models['apple']}")


# function6()
