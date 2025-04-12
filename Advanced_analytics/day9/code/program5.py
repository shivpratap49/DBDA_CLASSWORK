from bs4 import BeautifulSoup

data = """
<html>
    <head></head>
    <body>
        <div id="div_1" class="d1">this is first division</div>
        <div class="d2">this is second division</div>
        <div class="d3">this is third division</div>
        
        <span id="s1">this is first span</span>
        <span name="s2">this is second span</span>
        
        <table>
            <thead>
                <tr>
                    <th>time</th>
                    <th>temperature</th>
                    <th>humidity</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>11:30</td>
                    <td>27</td>
                    <td>82</td>
                </tr>
                <tr>
                    <td>12:30</td>
                    <td>28</td>
                    <td>80</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
"""

# create a soup
soup = BeautifulSoup(data, "html.parser")

# find the div with id= "div_1"
div = soup.find("div", {"id": "div_1"})
print(f"contents of div with id = div_1 : {div.text}")

# find the div with class = "d3"
div = soup.find("div", {"class": "d3"})
print(f"contents of div with class = d3 : {div.text}")

# find the span id = "s1"
span = soup.find("span", {"id": "s1"})
print(f"contents of span with id = s1 : {span.text}")

# find the span with name = "s2"
span = soup.find("span", {"name": "s2"})
print(f"contents of span with name = s2 : {span.text}")

# read all values of time, temperature and humidity
tbody = soup.find("tbody")
rows = tbody.find_all("tr")
data = []
for row in rows:
    tds = row.find_all("td")
    item = {
        "time": tds[0].text,
        "temperature": tds[1].text,
        "humidity": tds[2].text
    }
    data.append(item)
print(data)