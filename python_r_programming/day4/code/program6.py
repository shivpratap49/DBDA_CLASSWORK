# Set
# - collection of unique values stored in unordered fashion
# - uses hash function to store the values
#  - hash function
#    - used to calculate the position/index of a value
# - mutable collection: you can add a value dynamically


def function1():
    # list of numbers
    l1 = [10, 20, 10, 20, 10, 20, 10, 20]
    print(f"l1 = {l1}, type = {type(l1)}")

    # tuple of numbers
    t1 = 10, 20, 10, 20, 10, 20, 10, 20
    print(f"t1 = {t1}, type = {type(t1)}")

    # tuple of numbers
    t2 = (10, 20, 10, 20, 10, 20, 10, 20)
    print(f"t2 = {t2}, type = {type(t2)}")

    # set of numbers
    s1 = {30, 10, 20, 10, 20, 10, 20, 10, 20}
    print(f"s1 = {s1}, type = {type(s1)}")


# function1()


def function2():
    # empty list
    l1 = []
    print(f"l1 = {l1}, type = {type(l1)}")

    # empty tuple
    t1 = ()
    print(f"t1 = {t1}, type = {type(t1)}")

    # this is not an empty set, rather it is an empty dictionary
    # s1 = {}

    # empty set
    s1 = set()
    print(f"s1 = {s1}, type = {type(s1)}")


# function2()


def function3():
    # set of values
    s1 = {10, 20, 30, 40, 50}
    s2 = {40, 50, 60, 70, 80}

    print(f"s1 intersection s2 = {s1.intersection(s2)}")
    print(f"s2 intersection s1 = {s2.intersection(s1)}")
    print("-" * 80)

    print(f"s1 union s2 = {s1.union(s2)}")
    print(f"s2 union s1 = {s2.union(s1)}")
    print("-" * 80)

    print(f"s1 subtraction s2 = {s1 - s2}")
    print(f"s2 subtraction s1 = {s2 - s1}")
    print("-" * 80)


# function3()


def function4():
    # list of strings
    names = ["steve", "steve", "steve", "bill", "bill", "elon", "sundar"]
    print(names)

    # find the unique names
    unique_names = set(names)
    print(unique_names)

    # adding a new value
    unique_names.add("mark")
    unique_names.add("marc")
    unique_names.add("brian")
    unique_names.add("brian")
    print(unique_names)


# function4()


def function5():
    # set (mutable)
    s1 = {10, 20, 30, 40}
    s1.add(60)
    print(s1)

    # fronzenset: immutable
    s2 = frozenset([10, 20, 30, 40, 50, 10, 20, 30, 40, 50])
    print(s2)

    # frozenset can not be mutated
    # s2.add(60)


function5()

