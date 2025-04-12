# file IO
# operations
# - creating file
# - inserting data
# - appending data
# - opening a file
# - reading a file
# file types
# - text mode:
#   - this is default mode
#   - the data will be stored in ascii characters
#   - you can edit this file with any text editors
# - b binary/byte mode
#   - it requires special application to read the contents of the file
# file open modes
# - w (write):
#   - overwrite the contents inside the file
#   - if the file does not exist, it will be created first
#   - if the file exists, it will be opened for writing
# - a (append):
#   - append the contents to the file
#   - if the file does not exist, it will be created first
# - r (read):
#   - if the file does not exist, the application raises and exception
#     FileNotFoundError


def function1():
    # open: used to open a file
    # - param1: path or name of the file
    # - param2: mode + type
    file = open("my_file.txt", "wt")

    # write some contents
    file.write("India is my country. All indians are my brothers and sisters. I love my country.")

    # close the file
    # if the file is not closed, the data will NOT be saved on the disk
    file.close()


# function1()


def function2():
    # open the file in append mode
    file = open("my_file_new.txt", "a")

    # this time, the contents will be written at the end of the file
    file.write("These are new contents.")
    file.close()


# function2()


def function3():
    # open the file in read mode
    file = open("my_file_test.txt", "r")

    # read the file contents
    contents = file.read()
    print(f"contents: {contents}")

    # close file
    file.close()


# function3()


def function4():
    file = open("person_names.txt", "w")
    for i in range(5):
        name = input(f"enter person name {i}: ")
        # print(f"name = {name}")
        file.write(name)
        file.write(",")

    print("all person names are noted")


# function4()


def function5():
    file = open("person_names.txt", "r")

    # get all the contents of the file
    # names = file.read()
    # print(names)

    # read first 10 characters
    contents = file.read(10)
    print(f"contents = {contents}")

    # file close
    file.close()


# function5()


def function6():
    file = open("person_names.txt", "r")

    # store all found characters
    name_characters = []

    # infinite loop - never ending
    while True:
        # read one character at a time
        character = file.read(1)
        if character == ',':
            break
        name_characters.append(character)

    print(f"name: {name_characters}, {''.join(name_characters)}")

    file.close()


# function6()


def function7():
    file1 = open('my_file.txt', 'r')
    file2 = open('my_file_new.txt', 'r')

    print(f"file1: {file1.read()}")
    print(f"file2: {file2.read()}")

    file1.close()
    file2.close()


# function7()


def function8():
    file = open("my_binary_file.txt", "wb")
    file.write(b"This stored in binary file type")
    file.close()


# function8()


def function9():
    file = open("download.png", "rb")
    print(file.read())
    file.close()


# function9()


def function10():
    file = open("person_names.txt", "r")
    names = file.read()
    print(f"names = {names}, {names.split(',')}")
    file.close()


function10()
