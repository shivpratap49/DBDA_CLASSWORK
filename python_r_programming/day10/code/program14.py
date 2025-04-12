# operator overloading
# - providing different implementation for the default operators
# - this can be achieved by adding magic methods
#   - __add__(): for addition
#   - __sub__(): for subtraction
#   - __mul__(): for multiplication
#   - __truediv__(): for true division
#   - __floordiv__(): for floor division
# - the same functionality can be added for comparison operator as well
#   - __eq__(): for ==
#   - __ne__(): for !=
#   - __gt__(): for >
#   - __ge__(): for >=
#   - __lt__(): for <
#   - __le__(): for <=




class MyNumber:
    def __init__(self, value):
        self.__value = value

    def __str__(self):
        return f"MyNumber[{self.__value}]"

    def __add__(self, other):
        return self.__value + other.__value

    def __sub__(self, other):
        return self.__value - other.__value

    def __mul__(self, other):
        return self.__value * other.__value

    def __truediv__(self, other):
        return self.__value / other.__value

    def __floordiv__(self, other):
        return self.__value // other.__value

    def __gt__(self, other):
        return self.__value > other.__value

    def __ge__(self, other):
        return self.__value >= other.__value


num1 = 10
num2 = 20
print(f"num1 = {num1}, num2 = {num2}")

print(f"{num1} + {num2} = {num1.__add__(num2)}")
print(f"{num1} + {num2} = {num1 + num2}")

print('-' * 80)

n1 = MyNumber(10)
n2 = MyNumber(20)

print(f"n1 = {n1}, n2 = {n2}")
print(f"{n1} + {n2} = {n1.__add__(n2)}")
print(f"{n1} + {n2} = {n1 + n2}")

print(f"{n1} - {n2} = {n1.__sub__(n2)}")
print(f"{n1} - {n2} = {n1 - n2}")

print(f"{n1} * {n2} = {n1.__mul__(n2)}")
print(f"{n1} * {n2} = {n1 * n2}")

print(f"{n1} // {n2} = {n1 // n2}")
print(f"{n1} / {n2} = {n1 / n2}")

print(f"{n1} > {n2} = {n1 > n2}")
