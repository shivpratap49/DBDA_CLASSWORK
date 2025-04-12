# for...else loop
# - else block gets called only when the for loop
# iterates over all the values without breaking in between

def function1():
    num = 23
    is_prime = True
    for number in range(2, num//2):
        if num % number == 0:
            is_prime = False
            break

    if is_prime:
        print(f"{num} is a prime number")
    else:
        print(f"{num} is NOT a prime number")


# function1()


def function2():
    numbers = [10, 20, 30, 40, 50]

    for number in numbers:
        print(f"number = {number}")
        if number == 100:
            break
    else:
        print("inside else block")


# function2()


def function3():
    num = 23
    for number in range(2, num // 2):
        if num % number == 0:
            print(f"{num} is NOT a prime number")
            break
    else:
        print(f"{num} is a prime number")


function3()
