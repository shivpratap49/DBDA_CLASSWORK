# requirements
# - book
#   - add
#   - search by id/author
#   - delete a book
# - author
#   - search author
# - user
#   - register
#   - login
#   - borrow
#   - return
# eat the frog, brian tracy, ISBN23423432, 4.5
# {"title": "eat the frog", "author": "brian tracy", "isbn": "ISBN23423432", "ratings": 4.5}
# [{..}, {..}, {..}, ]

import json

# list of books
books = []

# list of users
users = []


def read_books():
    global books
    with open("data/books.json", "r") as file:
        # read the contents from file
        str_books = file.read()

        # convert the string to list of dictionaries
        temp_books = json.loads(str_books)
        books.extend(temp_books)


def save_books():
    with open("data/books.json", "w") as file:
        # convert the list of dictionaries to a string
        str_books = json.dumps(books)

        # save the books in json file
        file.write(str_books)


def add_book():
    print(f"-- adding a book book --")
    title = input("Enter title: ")
    price = float(input("Enter price: "))
    author = input("Enter author: ")
    isbn = input("Enter ISBN: ")
    ratings = float(input("Enter ratings: "))

    # create a dictionary for a book and append it to books list
    book = {
        "title": title,
        "price": price,
        "author": author,
        "isbn": isbn,
        "ratings": ratings
    }
    books.append(book)

    # persist the books
    save_books()
    print("Successfully added book to your library")


def delete_book():
    print(f"-- deleting book --")
    isbn = input("Enter the ISBN of book: ")
    index = 0
    for book in books:
        if book['isbn'] == isbn:
            # delete the book from books collection
            books.pop(index)
            break
        index += 1


def print_books(books_to_print):
    print(f"|{'ISBN':^10}|{'Title':^20}|{'Author':^20}|{'Price':^8}|{'Ratings':^10}|")
    print('-' * 74)
    for book in books_to_print:
        print(f"| {book['isbn']:<9}| {book['title']:<19}| {book['author']:<19}|{book['price']:^8}|{book['ratings']:^10}|")
    print('-' * 74)


def search_book():
    print(f"-- searching the books --")
    search_result = []
    isbn = input("Enter ISBN for searching: ")
    print(f"searching books with isbn: {isbn}")
    for book in books:
        if book['isbn'] == isbn:
            search_result.append(book)
            break
    if len(search_result) == 0:
        print(f"There is no book found with ISBN {isbn}")
    else:
        print_books(search_result)


def register_user():
    pass


def login_user():
    pass


def borrow_book():
    pass


def return_book():
    pass


def main():

    # restore the books from json file
    read_books()

    def print_menu():
        print("-- Welcome to Library Management System (LMS) --")
        print(f"Please select one of the options below")
        print(f"1. add a book")
        print(f"2. delete a book")
        print(f"3. search a book")
        print(f"4. register user")
        print(f"5. login user")
        print(f"6. borrow a book")
        print(f"7. return a book")
        print(f"8. all books")
        print(f"9. exit")
        choice = input("Enter your option: ")
        return choice

    # print the menu for user and get user's choice
    choice = print_menu()
    while choice != "9":
        if choice == "1":
            add_book()
        elif choice == "2":
            delete_book()
        elif choice == "3":
            search_book()
        elif choice == "4":
            register_user()
        elif choice == "5":
            login_user()
        elif choice == "6":
            borrow_book()
        elif choice == "7":
            return_book()
        elif choice == "8":
            print_books(books)

        # show the menu and get new user input
        choice = print_menu()


if __name__ == '__main__':
    main()
