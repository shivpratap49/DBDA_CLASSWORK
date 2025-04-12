import requests

# source
URL = "https://jsonplaceholder.typicode.com/todos/"

# hit the API (send the GET request)
response = requests.get(URL)

# read the response
print(f"status code: {response.status_code}")
print(f"data: {response.json()}")

# process the response
todo_list = response.json()
for item in todo_list:
    print(item)

