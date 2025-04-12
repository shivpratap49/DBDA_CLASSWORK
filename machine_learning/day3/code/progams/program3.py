import numpy as np
import pandas as pd


def function1():
    # series of numbers
    s1 = pd.Series([10, 20, 30, 40, 50])
    print(s1)

    print("-" * 80)

    # data frame using numbers
    df = pd.DataFrame([10, 20, 30, 40, 50])
    print(df)


# function1()


def print_data_frame_info(df):
    print(df)
    print(f"#dimensions = {df.ndim}")
    print(f"data types = {df.dtypes}")
    print(f"shape = {df.shape}")
    print("-" * 80)


def function2():
    # data frame using multiple collections
    # this will create a row-first table
    df1 = pd.DataFrame([
        [10, 20, 30],
        [40, 50, 60]
    ])
    print_data_frame_info(df1)

    df2 = pd.DataFrame([
        [10, 40],
        [20, 50],
        [30, 60]
    ])
    print(df2)
    print("-" * 80)

    # get the first column
    print(df2[0])

    # get the first column's first row
    print(df2[0][0])
    print(df2[1])


# function2()


def function3():
    # data frame using list of dictionaries
    df = pd.DataFrame([
        {"name": "person1", "age": 30, "address": "pune"},
        {"name": "person2", "age": 40, "address": "mumbai"},
        {"name": "person3", "address": "satara", "age": 50},
        {"age": 60, "address": "karad", "name": "person4"}
    ])

    print(df)
    print(df['name'])
    print(df['age'])


# function3()


def function4():
    df = pd.DataFrame([
        {"model": "iPhone 15", "company": "apple", "price": 1.2},
        {"model": "iPhone 15 Pro", "company": "apple", "price": 1.5},
        {"model": "iPhone 15 Pro Max", "company": "apple", "price": 1.9},
        {"model": "One Plus 13", "company": "One Plus", "price": 0.5},
        {"model": "S24 Ultra", "company": "samsung"},
        {"model": "M15", "company": "samsung", "price": 0.2},
        {"model": "Edge15", "company": "Motorola", "price": 0.3},
        {"model": "Xenphone", "company": "Asus", "price": 0.3},
        {"model": "Torch", "company": "BlackBerry", "price": 0.7}
    ])
    print(df)
    print("-" * 80)

    # get all the columns
    print(f"columns = {df.columns}")

    # get rows and columns from data frame
    print(f"shape = {df.shape}")
    rows, columns = df.shape
    print(f"rows = {rows}, columns = {columns}")
    print("-" * 80)

    # get the general information about the data frame
    print(df.info())
    print("-" * 80)

    # get statistical information about the data frame
    # this analysis is available only for the numeric columns
    print(df.describe())
    print("-" * 80)

    # get first few (5) records
    print(df.head())
    print("-" * 80)

    # get first 2 records
    print(df.head(2))
    print("-" * 80)

    # get last few (5) records
    print(df.tail())
    print("-" * 80)

    # get last 2 records
    print(df.tail(2))
    print("-" * 80)

    # get all models
    # returns one series (column)
    print(df['model'])
    print("-" * 80)

    # get all models and companies
    # used for re-arranging the columns
    # returns a data frame
    print(df[['model', 'company']])
    print("-" * 80)

    # create a data frame with columns price, model and company
    df_new = df[['price', 'model', 'company']]
    print(df_new)


# function4()

