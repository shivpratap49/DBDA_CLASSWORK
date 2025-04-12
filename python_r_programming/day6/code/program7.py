# standard library modules
import os


def function1():
    # list the contents of the module
    print(dir(os))

    # find the os name
    print(f"OS = {os.name}")

    # get current working directory
    print(f"current working directory: {os.getcwd()}")

    # create a new directory
    # - if directory already exists, app will raise an exception
    #   named FileExistsError
    # print(os.mkdir("test_directory"))

    # delete a file
    # if file does not exist, app will raise exception
    # named FileNotFoundError
    # os.unlink("download.png")


# function1()


