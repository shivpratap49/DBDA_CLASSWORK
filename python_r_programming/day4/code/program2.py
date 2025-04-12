# List Indexing
# - negative indexing
#   - using negative index positions
#   - -1: last position (len(list) - 1)
#   - -len(list): first position (0)

def function1():
    # list of numbers
    numbers = [10, 20, 30, 40, 50]

    # get the value using -ve index positions
    # -1 => len(list) - 1
    print(f"value at -1 = {numbers[-1]}")

    # -2 => len(list) - 2
    print(f"value at -2 = {numbers[-2]}")
    print(f"value at -3 = {numbers[-3]}")
    print(f"value at -4 = {numbers[-4]}")

    # -5 => len(list) - 5
    print(f"value at -5 = {numbers[-5]}")

    # get the first value
    print(f"first value (-len(numbers)) => {numbers[-len(numbers)]}")


function1()

