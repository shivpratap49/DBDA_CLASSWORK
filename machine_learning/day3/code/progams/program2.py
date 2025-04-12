import numpy as np
import pandas as pd


def function1():
    # series of numbers
    s1 = pd.Series([10, 20, 30, 40, 50])
    print(s1)

    # positive indexing
    print(f"s1[0] = {s1[0]}")
    print(f"s1[1] = {s1[1]}")

    # negative indexing
    # since the negative index does not exist, the following line
    # would raise an exception
    # print(f"s1[-1] = {s1[-1]}")

    print("-" * 80)

    s2 = pd.Series([10, 20, 30, 40, 50], index=[-1, -200, -323, -456, -598])
    print(s2)
    print(f"s2[-1] = {s2[-1]}")
    print(f"s2[-200] = {s2[-200]}")
    print(f"s2[-323] = {s2[-323]}")


# function1()


def function2():
    # series of numbers
    s1 = pd.Series([10, 20, 30, 40, 50])
    print(s1)

    # multiple integer indexing
    # since multiple index positions will return multiple values, the return
    # type is a series
    print(f"s1[[0, 1, 3]] = {s1[[0, 1, 3]]}")

    # boolean indexing
    # [10, 40]
    print(f"s1[[True, False, False, True, False]] = {s1[[True, False, False, True, False]]}")

    print(f"s1.values = {s1.values}, type = {type(s1.values)}")


# function2()


def function3():
    # filtering
    salaries = pd.Series([30, 35, 40, 56, 23, 45, 89, 34, 50, 90])

    # find the salaries above 70K
    # filtering would return a series with values and original index positions
    print(f"salaries above 70K = {salaries[salaries > 70]}")


# function3()
