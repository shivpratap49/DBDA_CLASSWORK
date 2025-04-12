# html
# - stands for hyper text markup language
# - used for designing the websites
# - made up of tags
# - standardized by W3C
# - also known as element
# - tag
#   - word enclosed by < and  >
#   - e.g. <span>, <h1>, <div>
#   - types
#     - opening tag:
#       - used to open data
#       - e.g. <span>
#     - closing tag:
#       - used to close the data
#       - uses / in the tag
#       - e.g. </span>
#     - root tag:
#       - used to start and end the html document
#       - e.g. <html>
#     - empty tag:
#       - tag without having any data
#       - e.g. <br/>, <hr/>
# - attribute
#   - more information about the tag
#   - e.g.
#     - id: used to identify the element uniquely
#     - class: used to add external CSS
#     - name: used to add name of the element
#     - style: used to add inline style

# import BeautifulSoup class from bs4 package
from bs4 import BeautifulSoup


data = """
<html>
    <head></head>
    <body>
        <h1>header 1</h1>
        <h2>header 2</h2>
        <div>this is first division</div>
        <div>this is second division</div>
        <span>this is first span</span>
        <span>this is second span</span>
    </body>
</html>
"""

# create a soup using html.parser to parse html
soup = BeautifulSoup(data, "html.parser")

# find h1
h1 = soup.find('h1')
print(f"header1 = {h1}")
print(f"header1 contents = {h1.text}")

# find h2
h2 = soup.find("h2")
print(f"h2 = {h2}, contents = {h2.text}")

# find first div
first_div = soup.find("div")
print(f"first_div = {first_div}, contents = {first_div.text}")

# find first span
first_span = soup.find("span")
print(f"first_span = {first_span}, contents = {first_span.text}")

print("-" * 80)

# find both the divisions
divisions = soup.find_all('div')
for div in divisions:
    print(f"contents = {div.text}")

print("-" * 80)

# find both the spans
spans = soup.find_all('span')
for span in spans:
    print(f"contents = {span.text}")

print("-" * 80)

# find the second div
print(f"second div = {divisions[1].text}")
