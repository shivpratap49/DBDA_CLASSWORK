# dictionary
# - collection of key-value pairs


def function1():
    # dictionary
    person = {
        "age": 40,
        "can_vote": True,
        "name": "person1",
        "hobbies": ["watching movies", "reading books"],
        "address": {
            "house_no": 5,
            "city": "pune",
            "state": "MH"
        },
    }

    print(f"keys = {person.keys()}")
    print(f"values = {person.values()}")

    print(f"name = {person['name']}")

    # person2 = [40, "pune", "person2"]
    # print(f"name = {person2[0]}")


function1()
