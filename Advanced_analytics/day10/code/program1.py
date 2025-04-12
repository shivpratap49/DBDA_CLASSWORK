from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import json


def main():
    driver = webdriver.Firefox()
    driver.get("https://www.nseindia.com/market-data/live-equity-market")
    time.sleep(5)
    table = driver.find_element(By.ID, "equityStockTable")
    tbody = table.find_element(By.TAG_NAME, "tbody")
    rows = tbody.find_elements(By.TAG_NAME, "tr")
    stock_data = []
    for row in rows:
        print(row)
        columns = row.find_elements(By.TAG_NAME, "td")
        stock_data.append({
            "quote": columns[0].text,
            "open": columns[1].text,
            "high": columns[2].text,
            "low": columns[3].text,
            "previousClose": columns[4].text
        })

    with open("stock_data.json", "w") as file:
        file.write(json.dumps(stock_data))

    driver.close()


if __name__ == '__main__':
    main()

