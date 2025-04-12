# user input
# - input() is used to get an input from user
# - input() always returns string value

# membership operator (in)
# - used to check if the member is present in the collection (list/tuple)


def function1():
    first_name = input("Enter your first name: ")
    last_name = input("Enter your last name: ")
    age = input("Enter your age: ")
    email = input("Enter your email: ")

    print(f"name = {first_name} {last_name}")
    print(f"age = {age}")
    print(f"email = {email}")


# function1()


def function2():
    # get string input from user and convert to integer value
    n1 = int(input("Enter first number: "))
    n2 = int(input("Enter second number: "))

    addition = n1 + n2
    print(f"addition = {addition}")


# function2()


def function3():
    names = []

    for index in range(5):
        name = input(f"Enter {index + 1} name: ")
        names.append(name)

    print(f"names = {names}")


# function3()


def function4():
    # list of persons
    persons = []

    for index in range(2):
        name = input(f"Enter {index + 1} person's name: ")
        age = int(input(f"Enter {index + 1} person's age: "))

        persons.append({
            "name": name,
            "age": age
        })

    print(persons)


# function4()


def function5():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]

    print(f"is 50 present in numbers: {numbers.count(50)}")
    print(f"is 50 present in numbers: {50 in numbers}")
    print(f"is 50 present in numbers: {50 not in numbers}")

    print(f"is 100 present in numbers: {numbers.count(100)}")
    print(f"is 100 present in numbers: {100 in numbers}")
    print(f"is 100 present in numbers: {100 not in numbers}")


# function5()


def function6():
    s = "iPhone is an apple product"

    print(f"is apple present in the string : {'apple' in s}")
    print(f"is samsung present in the string : {'samsung' in s}")


# function6()

