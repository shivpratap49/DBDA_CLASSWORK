# dictionary
# - collection of key-value pairs
# - the keys must be unique
#   - if multiple values are added with same key, only the last
#     one will be kept (last one will override the older ones)
# - most of the times, dictionary will prefer to have keys in string data type
# - value in a dictionary can be of any data type


def function1():
    def print_person(person):
        print(f"name = {person[0]}")
        print(f"age = {person[1]}")
        print(f"address = {person[2]}")
        print("-" * 80)

    person1 = ["person1", 40, "pune"]
    print_person(person1)

    person2 = ["person2", 50, "karad"]
    print_person(person2)

    person3 = ["person3", "nashik", 30]
    print_person(person3)


# function1()


def function2():
    def print_person(person):
        print(f"name = {person['name']}")
        print(f"age = {person['age']}")
        print(f"address = {person['address']}")
        print("-" * 80)

    person1 = {"name": "person1", "age": 40, "address": "pune"}
    print_person(person1)

    person2 = {"age": 60, "address": "karad", "name": "person2"}
    print_person(person2)

    person3 = {"name": "person3", "address": "Nashik", "age": 20}
    print_person(person3)

    print(person3.keys())
    print(person3.values())


# function2()


def function3():
    # empty list
    l1 = []
    print(f"l1 = {l1}, type = {type(l1)}")

    # empty tuple
    t1 = ()
    print(f"t1 = {t1}, type = {type(t1)}")

    # empty set
    s1 = set()
    print(f"s1 = {s1}, type = {type(s1)}")

    # empty dictionary
    d1 = {}
    print(f"d1 = {d1}, type = {type(d1)}")


# function3()


def function4():
    mobile = {
        "model": "iPhone 15",
        "company": "Apple",
        "price": 150000,
        "price": 170000,
        "color": None,
        "configuration": {
            "ram": ("6GB", "6.5GB")
        }
    }
    print(mobile)

    # dictionary
    car = {}
    print(car)

    # add key-value pairs
    car['color'] = "red"
    car['model'] = "triber"
    car["price"] = 10
    car["location"] = {
        "latitude": 17.83,
        "longitude": 10.50
    }
    # car["latitude"] = 17.83
    # car["longitude"] = 10.50
    print(car)

    # add key which already exists
    car['color'] = 'silver'
    print(car)

    # remove a key-value pair using a key
    del car['location']
    print(car)


# function4()


def function5():
    # dictionary
    person = {
        "name": "person1",
        "age": 30,
        "address": "pune"
    }

    # read value of key using []
    print(f"name = {person['name']}")
    print(person["name"])

    # if the key does not exist, the application will raise an exception KeyError
    # print(f"hobbies = {person['hobbies']}")

    # read value of key using get()
    print(f"name = {person.get('name')}")

    # if the key does not exist, get() will return None instead of
    # raising an exception
    print(f"hobbies = {person.get('hobbies')}")
    print(person)


# function5()


def function6():
    # dictionary
    person = {
        "name": "person1",
        "age": 30,
        "address": "pune",
        "email": "person1@test.com",
        "weight": 90
    }

    # read all key-value pairs
    # for key in person:
    #     print(f"key = {key}, value = {person[key]}")

    # print(f"items = {person.items()}")

    # for item in person.items():
    #     # print(f"item = {item}")
    #
    #     # unpacking tuple
    #     key, value = item
    #     print(f"key = {key}, value = {value}")

    for key, value in person.items():
        print(f"key = {key}, value = {value}")


# function6()


def function7():
    # list of tuples
    # persons = [
    #     ("person1", 30, "pune"),
    #     ("person2", 40, "karad"),
    #     ("person3", 20, "nashik"),
    # ]

    # tuple of tuples
    persons = (
        ("person1", 30, "pune"),
        ("person2", 40, "karad"),
        ("person3", 20, "nashik"),
    )

    # print all the persons on console
    # for person in persons:
    #     # print(person)
    #     print(f"name = {person[0]}")
    #     print(f"age = {person[1]}")
    #     print(f"address = {person[2]}")
    #     print("-" * 80)

    # print all the persons on console
    # for person in persons:
    #     # unpack the tuple
    #     name, age, address = person
    #     print(f"name = {name}")
    #     print(f"age = {age}")
    #     print(f"address = {address}")
    #     print("-" * 80)

    # print all the persons on console
    for name, age, address in persons:
        print(f"name = {name}")
        print(f"age = {age}")
        print(f"address = {address}")
        print("-" * 80)


# function7()


def function8():
    # list of dictionaries
    persons = [
        {"name": "person1", "age": 30, "address": 'pune'},
        {"name": "person2", "age": 20, "address": 'karad'},
        {"name": "person3", "age": 50, "address": 'mumbai'},
        {"name": "person4", "age": 90, "address": 'nashik'},
    ]

    for person in persons:
        for key, value in person.items():
            print(f"{key} = {value}")
        print("-" * 80)


function8()

