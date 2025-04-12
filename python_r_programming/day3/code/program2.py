# inner function
# - function declared inside another function
# - can access all the members (local variables/parameters)
#   of outer function
# - outer function can NOT access any member of inner function

def function0():
    print("inside function0")


# global function
def function1():
    print("inside function1")

    # scope: local
    num = 200
    print(f"num = {num}")
    function0()

    # nested / local / inner function
    # scope: local
    def my_function():
        print("inside my_function")
        print(f"num = {num}")

        # scope: local to my_function
        name = "steve"
        print(f"name = {name}")
        function0()

        # scope: local to my_function
        def another_level_of_inner_function():
            print("inside another_level_of_inner_function")
            function0()

        another_level_of_inner_function()

    # my_function()

    def my_function2():
        print("inside my_function2")
        function1()

    # name is local to my_function
    # it can not be accessed outside the my_function
    # print(f"name = {name}")

    # my_function2()


# function1()

# num is not accessible outside function1
# print(f"num = {num}")

# since my_function is local to function1,
# it can not be called outside function1
# my_function()


def global_function():
    print("inside global_function")

    # def global_function():
    #     print("inside global_function -> global_function")
    #
    # global_function()


# global_function()


# scope: global
my_var = 200


def outer():
    print("inside outer")

    global my_var
    my_var = 500

    # scope: local to outer
    num = 200
    print(f"1. num = {num}")

    def inner():
        print("inside inner")

        # creating a local scoped variable to inner function
        num = 500
        print(f"num = {num}")

    inner()
    print(f"2. num = {num}")

    def inner2():
        print("inside inner2")

        global my_var
        my_var = 600

        # refer the outer function's variable
        nonlocal num

        # creating a local scoped variable to inner function
        num = 500
        print(f"num = {num}")

    inner2()
    print(f"3. num = {num}")

outer()
