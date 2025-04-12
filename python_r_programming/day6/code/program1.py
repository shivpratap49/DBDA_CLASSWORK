def function1():
    first_name = input("enter first name: ")
    last_name = input("enter last name: ")
    email = input("enter your email: ")

    # dictionary
    person = {}
    person['first_name'] = first_name
    person['last_name'] = last_name
    person['email'] = email
    print(person)

    # immutable string
    # this is also known as string interpolation
    info = f"first name: {first_name}, last name: {last_name}, email: {email}"
    print(f"info = {info}")


# function1()


def function2():
    def add(p1, p2):
        return p1 + p2

    subtract = lambda p1, p2: p1 - p2
    multiply = lambda p1, p2: p1 * p2
    divide = lambda p1, p2: p1 / p2

    # dictionary of functions
    operations = {
        "add": add,
        "subtract": subtract
    }
    print(operations)

    print(f"10 + 20 = {operations['add'](10, 20)}")
    print(f"20 - 10 = {operations['subtract'](20, 10)}")
    print(f"-" * 80)

    # list of functions
    math_operations = [add, subtract, multiply, divide]
    print(math_operations)
    for operation in math_operations:
        # print(f"operation = {operation}")
        print(operation(10, 20))


# function2()


