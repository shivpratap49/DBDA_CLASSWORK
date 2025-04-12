
# closure
# - outer function returning inner function's reference
# - inner function remembers the outer function's context (members)
def outer():
    print("inside outer function")

    def another_inner():
        print(f"inside another_inner")

    # local / inner / nested
    def inner():
        print("inside inner function")

    return inner


# result = inner
# result = outer()
# print(f"result = {result}, type = {type(result)}")

# inner function is getting called outside the outer function
# with function reference
# result()

# inner function can not be called using function name outside
# the outer function
# inner()


def function1():
    # <h1>header 1</h1>
    def print_header1(data):
        print(f"<h1>{data}</h1>")

    # <h2>header 2</h2>
    def print_header2(data):
        print(f"<h2>{data}</h2>")

    # <div>div 1</div>
    def print_div(data):
        print(f"<div>{data}</div>")

    print_header1('Sunbeam')
    print_header2('Courses')
    print_div("there are courses on web security and data analysis")


# function1()


def function2():
    def print_tag_and_data(tag, data):
        print(f"<{tag}>{data}</{tag}>")

    print_tag_and_data('h1', 'Sunbeam')
    print_tag_and_data('h11', 'Institute')
    print_tag_and_data('h2', 'Courses')
    print_tag_and_data('div', 'There are two courses....')


# function2()


def create_tag(tag):
    def print_tag_and_data(data):
        print(f"<{tag}>{data}</{tag}>")

    return print_tag_and_data


# h1 = create_tag('h1')
# # print(f"h1 = {h1}, type = {type(h1)}")
# h1('Sunbeam')
#
# h2 = create_tag('h2')
# h2('Courses')
# h1('Institute')
#
# div = create_tag('div')
# div('data 1')
# div('data 2')
# h2('Faculties')


def function3():
    for index in range(1, 11):
        print(f"5 x {index} = {5 * index}")


# function3()


def create_number_table(number):
    def inner():
        for index in range(1, 11):
            print(f"{number} x {index} = {number * index}")

    return inner


# number_table_5 = create_number_table(5)
# number_table_5()

# number_table_13 = create_number_table(13)
# number_table_13()
