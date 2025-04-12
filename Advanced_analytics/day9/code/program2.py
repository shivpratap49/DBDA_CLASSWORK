import requests
import json


def main():
    # source
    URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo"

    # send GET request
    response = requests.get(URL)
    with open("stock.json", "w") as file:
        file.write(response.text)


def process_data():
    with open("stock.json", "r") as file:
        data = file.read()
    json_data = json.loads(data)
    time_series_data = json_data.get('Time Series (5min)')

    # collect the stock data here
    stock_data = []
    for key in time_series_data.keys():
        values = time_series_data[key]
        item = {
            "time": key,
            "open": values["1. open"],
            "high": values["2. high"],
            "low": values["3. low"],
            "close": values["4. close"],
            "volume": values["5. volume"]
        }
        stock_data.append(item)

    print(stock_data)
    with open("processed_data.json", "w") as file:
        file.write(json.dumps(stock_data))

    with open("processed_data.csv", "w") as file:
        file.write("time,open,high,low,close,volume\n")
        for item in stock_data:
            file.write(f"{item['time']},{item['open']},{item['high']},{item['low']},{item['close']},{item['volume']}\n")


if __name__ == '__main__':
    # main()
    process_data()
