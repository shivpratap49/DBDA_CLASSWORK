# file IO
# using with block / syntax
# - with block automatically closes the file
# - developer does not required to call close() explicitly


def function1():
    # file = open("my_file.txt", "r")
    with open("my_file.txt", "r") as file:
        print(f"contents = {file.read()}")


# function1()


def function2():
    with open("my_file.txt", "w") as my_file:
        my_file.write("new contents written")


# function2()


def function3():
    with open("my_file.txt", "r") as file1:
        with open("my_file_new.txt", "r") as file2:
            with open("new_file.txt", "w") as final_file:
                final_file.write(file1.read())
                final_file.write('\n')
                final_file.write(file2.read())


function3()
