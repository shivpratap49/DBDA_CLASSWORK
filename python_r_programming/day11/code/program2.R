# variable
# - memory used to store a value

# using same syntax as python
num.1 = 200
print(num.1)

# trick: the arrow head always will point to the varible name
# using single headed arrow (left)
num.2 <- 200
print(num.2)

# using double headed arrow (left)
num.3 <<- 200
print(num.3)

# using single headed arrow (right)
200 -> num.4
print(num.4)

# using double headed arrow (right)
200 ->> num.5
print(num.5)

num.6 = 800
print(num.6)

# used to print value with constant string on console
cat("num.6 = ", num.6)

# used to get a formatted string
paste("num.6 = ", num.6)

# used to get a formatted string
paste0("num.6 = ", num.6)
# print(f"num.6 = {num.6}")


