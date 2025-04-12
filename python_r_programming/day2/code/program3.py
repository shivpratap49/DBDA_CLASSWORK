# type conversion

# explicit type conversion

# anything to int

# float to int
print(f"30.50 in int => {int(30.50)}")

# boolean to int
print(f"True in int => {int(True)}")
print(f"False in int => {int(False)}")

# str to int
print(f"'20' in int => {int('20')}")

# it is not possible to convert test to int,
# the application will crash here
# print(f"'test' in int => {int('t')}")
# print(f"None in int => {int(None)}")

# anything to float

# int to float
print(f"20 in float => {float(20)}")

# boolean to float
print(f"True in float => {float(True)}")
print(f"False in float => {float(False)}")

# str to float
print(f"'20' in float => {float('20')}")
print(f"'20.0' in float => {float('20.0')}")

# it is not possible to convert test to float,
# the application will crash here
# print(f"'test' in float => {float('t')}")
# print(f"None in float => {float(None)}")

# anything to string
print(f"20 in string => {str(20)}")
print(f"20.0 in string => {str(20.0)}")
print(f"True in string => {str(True)}")
print(f"False in string => {str(False)}")

# anything to boolean

# any non-zero value will get converted to True
# only zero will get converted to False
print(f"1 in bool => {bool(1)}")
print(f"0 in bool => {bool(0)}")
print(f"100 in bool => {bool(100)}")
print(f"-100 in bool => {bool(-100)}")

# string to boolean
# any non-empty string will be converted to True
# only empty string will be converted to False
print(f"'True' in bool => {bool('True')}")
print(f"'False' in bool => {bool('False')}")
print(f"'Anything' in bool => {bool('Anything')}")

print(f"'' in bool => {bool('')}")