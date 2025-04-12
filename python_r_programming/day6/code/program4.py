# write an application to perform math operations based on user's choice

def add(p1, p2):
    print(f"{p1} + {p2} = {p1 + p2}")


def subtract(p1, p2):
    print(f"{p1} - {p2} = {p1 - p2}")


def multiply(p1, p2):
    print(f"{p1} * {p2} = {p1 * p2}")


def divide(p1, p2):
    print(f"{p1} / {p2} = {p1 / p2}")


def get_input_from_user():
    number1 = int(input("Enter first number: "))
    number2 = int(input("Enter second number: "))
    return number1, number2


def print_menu():
    while True:
        print(f"Welcome to math operation's application")
        print("Your options are: ")
        print(f"1. add")
        print(f"2. subtract")
        print(f"3. multiply")
        print(f"4. divide")
        print(f"5. exit")

        choice = input("Enter your option: ")
        print(f"you have entered: {choice}")

        if choice == "1":
            number1, number2 = get_input_from_user()
            add(number1, number2)
        elif choice == "2":
            number1, number2 = get_input_from_user()
            subtract(number1, number2)
        elif choice == "3":
            number1, number2 = get_input_from_user()
            multiply(number1, number2)
        elif choice == "4":
            number1, number2 = get_input_from_user()
            divide(number1, number2)
        else:
            print(f"bye bye..")
            break


print_menu()

