def print_person(person):
    print(f"name = {person['name']}")
    print(f"age = {person['age']}")
    print(f"address = {person['address']}")
    print('-' * 80)


# data
person1 = {"name": "person1", "age": 30, "address": "pune"}
print_person(person1)

person2 = {"name": "person2", "age": 20, "address": "mumbai"}
print_person(person2)

# function print_person is totally dependent on type of data (dictionary
# having keys name, age and address)
# print_person(10)
# print_person({})

