from bs4 import BeautifulSoup


# https://weather.com/en-IN/weather/hourbyhour/l/377a54635df963caf716a0ee50166207a07dd9ce0337d9fbf4e14ef66b968a93

# read the html contents from file
with open("data.html", "r") as file:
    data = file.read()

soup = BeautifulSoup(data, "html.parser")

# find all the row parents
details_list = soup.find_all("details")

# extract time, temperature, rain_condition, precipitation, wind_speed
# from every row
data = []
for details_item in details_list:
    h2_time = details_item.find("h2", {"data-testid": "daypartName"})
    div_temperature = details_item.find("div", {"data-testid": "detailsTemperature"})
    div_rain_condition_parent = details_item.find("div", {"data-testid": "wxIcon"})
    span_rain_condition = div_rain_condition_parent.find("span")
    div_precip = details_item.find("div", {"data-testid": "Precip"})
    span_precip = div_precip.find("span")
    div_wind = details_item.find("div", {"data-testid": "wind"})
    span_wind = div_wind.find("span", {"data-testid": "Wind"})

    # create a dictionary with required info
    item = {
        "time": h2_time.text,
        "temperature": div_temperature.text,
        "rain_condition": span_rain_condition.text,
        "precipitation": span_precip.text,
        "wind_speed": span_wind.text.replace("\xa0", "")
    }
    data.append(item)

print(data)
