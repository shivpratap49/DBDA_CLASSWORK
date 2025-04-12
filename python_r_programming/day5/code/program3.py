# string
# - collection of characters
# - immutable object
# - can be declared using
#   - single quotes
#   - double quotes
#   - triple single/double quotes

def function1():
    """this is a doc string of function1"""
    print(f"inside function1")


# function1()
# print(f"docstring => {function1.__doc__}")
# print(print.__doc__)


def function2():
    s1 = 'this is a string'
    print(f"s1 = {s1}")

    s2 = "this is a string"
    print(f"s2 = {s2}")

    s3 = """this is a string"""
    print(f"s3 = {s3}")

    s4 = '''this is a string'''
    print(f"s4 = {s4}")


# function2()


def function3():
    # use single quotes inside a string which is declared using double quotes
    dialog1 = "arnold once said, 'Trust me! I will be back!'"
    print(f"dialog1 = {dialog1}")

    # escape inner double quotes inside a string which is declared using double quotes
    dialog2 = "arnold once said, \"Trust me! I will be back!\""
    print(f"dialog2 = {dialog2}")

    # use double quotes inside a string which is declared using single quotes
    dialog3 = 'arnold once said, "Trust me! I will be back!"'
    print(f"dialog3 = {dialog3}")

    # escape inner single quotes inside a string which is declared using single quotes
    dialog4 = 'arnold once said, \'Trust me! I will be back!\''
    print(f"dialog4 = {dialog4}")


# function3()


def function4():
    # collection of characters
    s1 = "  This Is A String. This is a string.  "
    print(f"s1 = {s1}")

    # convert all the characters to lower case
    print(f"lower case: {s1.lower()}")

    # convert all the characters to upper case
    print(f"upper case: {s1.upper()}")

    # remove all the left and right white spaces
    print(f"stripped string: {s1.strip()}")

    # replace a substring with another string
    # this will replace all occurrences of String with Apple
    # replace is a case-sensitive function
    # String and string are different values
    print(f"replacing String with Apple: {s1.replace('String', 'Apple')}")


# function4()


def function5():
    url = "https://google.com/index.html?key=iphone"

    # split the string based on a string
    parts = url.split("?")
    print(f"parts = {parts}")

    # get the query string
    query_string = parts[1]

    # get the protocol
    parts = parts[0].split(':')
    print(f"parts = {parts}")
    protocol = parts[0]

    # get the domain name and path
    parts = parts[1].split('/')
    print(f"parts = {parts}")
    domain_name = parts[2]
    path = parts[3]

    print(f"url = {url}")
    print(f"protocol: {protocol}, domain name = {domain_name}, path = {path}, query string = {query_string}")


# function5()


def function6():
    # string
    s1 = "I love Apple products"

    # positive indexing
    print(f"s1[0] = {s1[0]}")

    # negative indexing
    print(f"s1[-1] = {s1[-1]}")

    # slicing
    print(f"s1[7:12] = {s1[7:12]}")
    print(f"s1[:12] = {s1[:12]}")
    print(f"s1[13:] = {s1[13:]}")
    print(f"s1[::2] = {s1[::2]}")
    print(f"s1[::-1] = {s1[::-1]}")

    # convert the string data into a list
    str_list = list(s1)
    print(f"str_list = {str_list}")


# function6()


def function7():
    # list of numbers
    dummy_list = ['10', '12', '56', '60', '90']
    # dummy_list = ('10', '12', '56', '60', '90')

    # convert list to a string
    s1 = str(dummy_list)
    print(f"s1 = {s1}")

    # get all values of list and convert them to a string
    s2 = ''.join(dummy_list)
    print(f"s2 = {s2}")

    s3 = '-'.join(dummy_list)
    print(f"s3 = {s3}")

    s4 = '-*-'.join(dummy_list)
    print(f"s4 = {s4}")


# function7()


def function8():
    # string formatting
    s1 = "Apple"
    print(f"no alignment = {s1}")

    # left aligned string
    print(f"left alignment = |{s1:<11}|")

    # right aligned string
    print(f"left alignment = |{s1:>11}|")

    # center aligned string
    print(f"left alignment = |{s1:^11}|")

    persons = [
        {"name": "person1", "age": 30, "address": 'pune'},
        {"name": "person2", "age": 20, "address": 'karad'},
        {"name": "person3", "age": 50, "address": 'mumbai'},
        {"name": "person4", "age": 90, "address": 'nashik'},
    ]
    print("")

    print('_' * 37)
    print(f"|{'Name':^13}|{'Age':^7}|{'Address':^13}|")
    print('-' * 37)

    for person in persons:
        print(f"|{person['name']:^13}|{person['age']:^7}|{person['address']:^13}|")

    print('_' * 37)


# function8()


def function9():
    num = 1500.63454546
    print(f"num = {num}")

    # print only 2 decimal digits
    print(f"num = {num:.2f}")

    # print with + symbol
    print(f"num = {num:+}")

    # print the value in scientific format
    print(f"num = {num:e}")

    # print the value in scientific format
    print(f"num = {num:E}")


# function9()


def function10():
    num = 2000

    # print the value in decimal number system
    print(f"num = {num}")
    print(f"num = {num:n}")

    # print the value in octal number system
    print(f"num = {num:o}")

    # print the value in hexa-decimal number system
    print(f"num = {num:x}")

    # print the value in hexa-decimal number system
    print(f"num = {num:X}")


# function10()



