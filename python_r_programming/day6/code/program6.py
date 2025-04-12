def function1():
    # import the whole module
    import my_math_operations

    # call the functions
    my_math_operations.add(30, 50)


# function1()


def function2():
    # import whole module with an alias
    import my_math_operations as mo

    # call the functions
    mo.add(40, 50)


# function2()


def add(p1, p2):
    print(f"inside program6 (add)")
    print(f"{p1} + {p2} = {p1 + p2}")


def function3():
    # import only required entities from a module
    from my_math_operations import add

    add(20, 30)
    add(50, 40)


# function3()


def function4():
    # import required entities with alias
    from my_math_operations import add as mo_add

    # called from my_math_operations
    mo_add(40, 50)

    # called from same program
    add(40, 50)


# function4()


if __name__ == '__main__':
    print(f"(program6) module name: {__name__}")

    import my_math_operations
    print(dir(my_math_operations))
    print(my_math_operations.__doc__)
    print(my_math_operations.__name__)
    print(my_math_operations.__file__)
    print(my_math_operations.__package__)
