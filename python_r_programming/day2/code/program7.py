# scope
# - global
#   - entity is not declared inside any function
#   - can be accessed anywhere in the same file
# - local
#   - entity which is declared inside any function
#   - can be accessed within the same function in which it is declared

# scope: global
num = 200
print(f"1. outside of any function num = {num}")


def function1():
    print("inside function1")

    # function1 will create a local variable with same name as num
    # and set the value to 500
    # num = 500
    print(f"2. inside function1, num = {num}")

    # scope: local to function1
    my_var = 400
    print(f"my_var = {my_var}")


function1()


def function2():
    print("inside function2")

    # henceforth consider the num as global variable
    global num

    # modify the num value
    num = 500
    print(f"2. inside function1, num = {num}")


function2()
print(f"3. outside of any function num = {num}")


def function3():
    print("inside function3")
    print(f"num = {num}")


function3()


# since my_var is declared inside function1, it can be accessed
# only within function1
# print(f"my_var = {my_var}")
