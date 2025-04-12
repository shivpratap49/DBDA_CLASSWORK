from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import json

URL = "file:///Volumes/MyData/Sunbeam/2024/sept/dbda/adv-analytics/day10/code/login.html"

driver = webdriver.Firefox()
driver.get(URL)
time.sleep(3)

# find the input for email
input_email = driver.find_element(By.ID, "email")
input_email.send_keys("test@test.com")
time.sleep(3)

# find the input for password
input_password = driver.find_element(By.ID, "password")
input_password.send_keys("test")
time.sleep(3)

# find the login button
button_login = driver.find_element(By.CLASS_NAME, "btn-success")
button_login.click()
time.sleep(3)

# find the table
table = driver.find_element(By.TAG_NAME, "table")
tbody = table.find_element(By.TAG_NAME, "tbody")
rows = tbody.find_elements(By.TAG_NAME, "tr")
lawyers = []
for row in rows:
    columns = row.find_elements(By.TAG_NAME, "td")
    lawyers.append({
        "name": columns[2].text,
        "enrollmentNo": columns[3].text,
        "taluka": columns[4].text,
        "district": columns[5].text
    })

with open("lawyers.json", "w") as file:
    file.write(json.dumps(lawyers))

driver.close()
