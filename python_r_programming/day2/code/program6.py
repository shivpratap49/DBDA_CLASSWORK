# function

# function definition
# - declaration: function name along with the parameters
# - body
#   - block which contains the statements of the function
#   - declaration and body can not be separated
# parameterless function
# - which does not accept any parameters
def function1():
    """this is a sample function"""
    print("inside function1")


# function call
# invocation of the function
# function1()


# parameterized function
# - which accepts at least one parameter
def function2(parameter):
    print("inside function2")
    print(f"parameter = {parameter}, type = {type(parameter)}")


# function2(10)
# function2("test")
# function2(True)


def function3(p1, p2):
    print("inside function3")
    print(f"{p1} + {p2} = {p1 + p2}")


# function3(10, 20)
# function3("test1", "test2")
# function3("test1", 20)
# return_vaue = function3(20, 30)
# print(f"return_value = {return_vaue}")


# empty function
# - which does not do anything
# - which does not have any statement in the body (...)
# void function1() { }
def function4():
    # No operation
    # - nothing will happen here
    pass


# a function can return one and only one value
# - every function in python returns a value either implicitly or explicitly
# - every function by default returns None
def function5(p1, p2):
    print("inside function5")

    # get addition
    result = p1 + p2

    # send the result to the caller
    # return the value explicitly
    return result

    # this is unreachable statement
    # print("this is line after return statement")


# call the function
# capture the returned value in addition variable
# addition = function5(10, 20)
# print(f"addition = {addition}")


# global function
# outer function
def function6():
    print("inside function6")

    # nested function
    # inner function
    # local function
    def function7():
        print("inside function7")

    # it is accessible only inside function6
    function7()


function6()
# function7()