n = int(input("Enter no\n"))
def p1():
    for i in range(0,n):
        print("*"*(i+1))
p1()
def p2():
    for i in range(n):
        print(" " * (n-i-1),end="")
        print("*"*(i+1))
p2()

# list1=list(range(1,n+1))
def p3():
    for i in range(n):
        print(" " *(n-i),end="")
        # print("*" * (i+list1[i]))
        print("*"* (2*i + 1))
p3()

def print_pyramid(rows):
    for i in range(1, rows + 1):
        # Print spaces
        for j in range(1, rows - i + 1):
            print(" ", end="")

        # Print stars
        for k in range(1, 2 * i):
            print("*", end="")
        # Move to the next line
        print()
# Define the number of rows for the pyramid
num_rows = 5
# Call the function to print the pyramid
print_pyramid(num_rows)


#printing diamond
import math
def p4():
    m= math.ceil(n/2)
    for i in range(m):
        print(" " *(m-i),end="")
        # print("*" * (i+list1[i]))
        print("*"* (2*i + 1))
    for q in range(n//2):
        print(" " * (2 * q + 1),end="")
        # print("*" * (i+list1[i]))
        print("*"* ((n//2)-q + 1))

# bychatgpt
def p5():
    # Define the number of rows for the diamond (odd number for symmetry)
    num_rows = 5

    # Upper part of the diamond
    for i in range(1, num_rows + 1, 2):
        print(" " * ((num_rows - i) // 2) + "*" * i)

    # Lower part of the diamond (excluding the center row for odd numbers)
    for i in range(num_rows - 2, 0, -2):
        print(" " * ((num_rows - i) // 2) + "*" * i)

p4()
p5()


