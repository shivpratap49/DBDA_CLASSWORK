import numpy as np
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
import json


def function1():
    # read the data from a csv file into a data frame
    df = pd.read_csv('Salary_Data.csv')
    print(df)

    # get all the column names
    print(df.columns)
    print("-" * 80)

    # get general info
    print(df.info())
    print("-" * 80)

    # get stats analysis
    print(df.describe())
    print("-" * 80)

    # get first 10 records
    print(df.head(10))
    print("-" * 80)

    # get last 15 records
    print(df.tail(15))
    print("-" * 80)

    # get all experiences
    print(df['YearsExperience'])
    print("-" * 80)

    # get all salaries
    print(df['Salary'])
    print("-" * 80)

    # create a new data frame with salary and experience order
    df_new = df[['Salary', 'YearsExperience']]
    print(df_new)


# function1()


def function2():
    url = "https://www.accuweather.com/en/in/pune/204848/daily-weather-forecast/204848"
    driver = webdriver.Firefox()
    driver.get(url)
    divisions = driver.find_elements(By.CLASS_NAME, "daily-wrapper")
    data = []
    for division in divisions:
        h2 = division.find_element(By.CLASS_NAME, "date")
        day = h2.find_element(By.CLASS_NAME, "dow").text
        date = h2.find_element(By.CLASS_NAME, "sub").text

        div_temp = division.find_element(By.CLASS_NAME, "temp")
        high_temp = div_temp.find_element(By.CLASS_NAME, "high").text.replace("°", "")
        low_temp = div_temp.find_element(By.CLASS_NAME, "low").text.replace("°", "").replace("/", "")

        # print(f"day: {day}, date: {date}, high: {high_temp}, low: {low_temp}")
        data.append({
            "day": day,
            "date": date,
            "high": high_temp,
            "low": low_temp
        })

    driver.close()

    with open("temperature_data.json", "w") as file:
        file.write(json.dumps(data))


# function2()


def function3():
    df = pd.read_json("temperature_data.json")
    print(df)
    # df.to_excel("temperatures.xlsx")
    df.to_csv("temperatures.csv")


function3()
