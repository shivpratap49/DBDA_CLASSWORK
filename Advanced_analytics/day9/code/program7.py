# firefox web driver
# - https://github.com/mozilla/geckodriver/releases

# import webdriver from selenium to open a browser instance
from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import json
import csv

# create instance of web driver to open browser
driver = webdriver.Firefox()

# open browser and visit url
driver.get("https://weather.com/en-IN/weather/hourbyhour/l/377a54635df963caf716a0ee50166207a07dd9ce0337d9fbf4e14ef66b968a93")
# time.sleep(2)

# soup.find("div", {"class": "HourlyForecast--DisclosureList--MQWP6"})
div_parent = driver.find_element(By.CLASS_NAME, "HourlyForecast--DisclosureList--MQWP6")

# get the details tags
details_list = div_parent.find_elements(By.TAG_NAME, "details")
data = []
for details_item in details_list:
    h2_time = details_item.find_element(By.CLASS_NAME, "DetailsSummary--daypartName--kbngc")
    div_temperature = details_item.find_element(By.CLASS_NAME, "DetailsSummary--temperature--1kVVp")

    item = {
        "time": h2_time.text,
        "temperature": div_temperature.text.replace("°", "")
    }
    data.append(item)

print(data)

with open("temperature_list.json", "w") as file:
    file.write(json.dumps(data))

with open('temperature_list.csv', 'w', newline='') as csvfile:
    fieldnames = ['time', 'temperature']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
    for item in data:
        writer.writerow({
            'time': item['time'],
            'temperature': item['temperature']
        })


# close the browser
driver.close()

