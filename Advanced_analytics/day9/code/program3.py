import requests
import json


# URL = "https://api.open-meteo.com/v1/forecast?latitude=18.58&longitude=73.74&past_days=10&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m"
# get the data from above API and save in a csv file with output format
# date,time,temperature,humidity,wind_speed


def main():
    URL = "https://api.open-meteo.com/v1/forecast?latitude=18.58&longitude=73.74&past_days=10&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m"
    response = requests.get(URL)
    with open("weather_data.json", "w") as file:
        file.write(response.text)


def process_data():
    with open("weather_data.json", "r") as file:
        data = file.read()
        json_data = json.loads(data)

    # collect the data here
    temperature_data = []

    # get all temperature data
    temp_data = json_data.get("hourly")

    # read all the values
    time_list = temp_data.get("time")
    temperature_list = temp_data.get("temperature_2m")
    humidity_list = temp_data.get("relative_humidity_2m")
    wind_speed_list = temp_data.get("wind_speed_10m")

    # create a csv file from the data
    with open("weather_data.csv", "w") as file:
        file.write("date,time,temperature,humidity,wind_speed\n")
        for i in range(len(time_list)):
            # get both date and time in the form of 2024-09-14T00:00
            date_time = time_list[i]
            parts = date_time.split('T')
            file.write(f"{parts[0]},{parts[1]},{temperature_list[i]},{humidity_list[i]},{wind_speed_list[i]}\n")


if __name__ == '__main__':
    # main()
    process_data()