# Tuple
# - collection of similar or dissimilar values
# - immutable collection


def function1():
    # list of numbers
    l1 = [10, 20, 30, 40, 50]
    print(f"l1 = {l1}, type = {type(l1)}")

    l2 = list([10, 20, 30, 40, 50])
    print(f"l2 = {l2}, type = {type(l2)}")

    # tuple of numbers
    t1 = (10, 20, 30, 40, 50)
    print(f"t1 = {t1}, type = {type(t1)}")

    # create tuple using tuple()
    t2 = tuple([10, 20, 30, 40, 50])
    print(f"t2 = {t2}, type = {type(t2)}")

    # tuple of numbers
    t3 = 10, 20, 30, 40, 50
    print(f"t3 = {t3}, type = {type(t3)}")


# function1()


def function2():
    # create a list with one value
    l1 = [10]
    print(f"l1 = {l1}, type = {type(l1)}")

    # this is not a tuple with one value
    # instead, it will create int variable
    t1 = (10)
    print(f"t1 = {t1}, type = {type(t1)}")

    # this is not a tuple with one value
    # instead, it will create string variable
    t2 = ("test")
    print(f"t2 = {t2}, type = {type(t2)}")

    # create a tuple with one value
    t3 = (10,)
    print(f"t3 = {t3}, type = {type(t3)}")

    t4 = tuple([10])
    print(f"t4 = {t4}, type = {type(t4)}")


# function2()


def function3():
    # tuple of numbers
    numbers = (10, 20, 30, 40, 50)
    print(numbers)

    # append a value
    # numbers.append(60)
    # print(numbers)

    print(f"40 appears {numbers.count(40)} times")
    print(f"40 appears at {numbers.index(40)} position")


# function3()


def perform_math_operations(p1, p2):
    addition = p1 + p2
    subtraction = p1 - p2
    multiplication = p1 * p2
    division = p1 / p2

    # this line does not return multiple values
    # this line will create a tuple and send all the values
    # adding them to the newly created tuple
    return addition, subtraction, multiplication, division


# answers = perform_math_operations(20, 10)
# print(f"answers = {answers}, type = {type(answers)}")
# print(f"addition = {answers[0]}")

# function returns a tuple and it gets unpacked in different variables
# addition, subtraction, multiplication, division = perform_math_operations(20, 10)
# print(f"addition = {addition}")


def function4():
    # person = ["person1", 40, "pune", "person1@test.com"]
    # person = ("person1", 40, "pune", "person1@test.com")
    person = "person1", 40, "pune", "person1@test.com"
    print(f"name = {person[0]}")
    print(f"age = {person[1]}")
    print(f"address = {person[2]}")
    print(f"email = {person[3]}")


# function4()


def function5():
    numbers = (10, 20)

    # create a variable using value at a specific position
    # p1 = numbers[0]
    # p2 = numbers[1]

    # p1, p2 = numbers
    # p1, p2 = (10, 20)

    # tuple unpacking (extraction)
    # - reading values from tuple and creating variables to store them
    # - the values will be extracted from left to right
    p1, p2 = 10, 20
    print(f"p1 = {p1}, type = {type(p1)}")
    print(f"p2 = {p2}, type = {type(p2)}")


    # n1, n2, n3 = 100, 200, 300

    # error as the number of variables are not matching with
    # number of values
    # n1, n2 = 10, 20, 40
    # n1, n2 = 20


# function5()



