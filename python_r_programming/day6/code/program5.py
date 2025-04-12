def function1():
    # import the module my_math_operations
    import my_math_operations

    # call the required function
    my_math_operations.add(30, 40)
    my_math_operations.subtract(20, 40)
    print(f"PI = {my_math_operations.PI}")


# function1()


def function2():
    # import my_math_operations with an alias mo
    import my_math_operations as mo

    # call the required function
    mo.add(30, 40)
    mo.subtract(20, 40)
    print(f"PI = {mo.PI}")


# function2()


def function3():
    # import required entities from a module
    from my_math_operations import add, subtract
    # from my_math_operations import subtract

    add(30, 40)
    subtract(30, 10)


# function3()


def add(p1, p2):
    print(f"inside program5 (add)")
    print(f"{p1} + {p2} = {p1 + p2}")


def function4():
    from my_math_operations import add as mo_add
    mo_add(10, 20)
    add(40, 50)


function4()
