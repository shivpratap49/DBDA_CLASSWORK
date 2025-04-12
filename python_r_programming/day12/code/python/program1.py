# exception or error handling
# exception
# - run time condition (error) which is not expected
# - types
#   - error
#     - run time condition that can NOT be handled
#     - once an application observes the error, the application will terminate
#     - e.g. not having enough memory while running an application,
#            hardware failure etc.
#   - exception
#     - run time condition that can be handled
#     - application can execute alternate code if it observes exception
#     - if the exception is handled, the application does not crash
#     - e.g. ZeroDivisionError, FileNotFoundError etc.

# exception handling
# try block
# - contains the code which may raise an exception
# - may contain one or more lines of code
# - every try block must be associated with at least one except block
# except block
# - which gets called when application observes an exception
# - try block may get associated with more than one except blocks
# - there has to be one and only one generic exception block
# - this block never gets called if there is no exception raised in the application
# else block
# - contains the code which needs to execute when there is no exception raised
# - gets called in case of NO exception
# - only one else block is allowed per try block
# finally block
# - contains the code which needs to get executed in both the conditions
#   - there is an exception being raised
#   - there is an exception NOT being raised
# - only one finally block is allowed per try block

# Exception
# - is a base class for all exception in python

def divide(p1, p2):
    try:
        result = p1 / p2
        print(f"result = {result}")

        # file = open('file1.txt', 'r')
        # print(f"data = {file.read()}")

    except ZeroDivisionError:
        # gets called only if there is an exception
        # specific block
        print("zero division error: exception is handled")
    except FileNotFoundError:
        # gets called only if there is an exception
        # specific block
        print("file not found: exception is handled")
    except:
        # gets called only if there is an exception
        # generic exception block
        print(f"this is a generic exception block")
    else:
        # gets called only if there is NO exception
        print(f"result = {result}")
    finally:
        # file.close()
        print("finally block called")


# divide(10, 0)


# custom exception
class InvalidAgeException(Exception):
    pass


def function1():
    age = int(input("enter age: "))
    if age > 100:
        # raising an exception
        # raise: raises an object of Exception class
        raise InvalidAgeException()

    print(f"age = {age}")


try:
    function1()
except InvalidAgeException:
    print("invalid age entered")



