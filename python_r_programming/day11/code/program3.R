# Data types
# - Vector: one dimensional collection of similar values

# Vector of numeric / double value(s)
num = 200
cat("num = ", num)
cat("type of num = ", typeof(num))
cat("class of num = ", class(num))

# vector of double / numeric
salary = 15.50
cat("salary = ", salary)
cat("type of salary =", typeof(salary))
cat("class of salary =", class(salary))

# vector of integer
int.varible = 200L
cat("int.varible = ", int.varible)
cat("type of int.varible =", typeof(int.varible))
cat("class of int.varible =", class(int.varible))

# vector of character
# first.name = 'steve'
first.name = "steve"
print(first.name)
cat("first.name = ", first.name)
cat("type of first.name = ", typeof(first.name))
cat("class of first.name = ", class(first.name))


# vector of Logical
# can.vote = TRUE
can.vote = T
# can.vote = FALSE
# can.vote = F
cat("can.vote = ", can.vote)
cat("type of can.vote = ", typeof(can.vote))
cat("class of can.vote = ", class(can.vote))


# vector of raw values
# mostly it is used to store characters from other language(s)
# my.var = charToRaw("India")
my.var = charToRaw("नमस्ते")
reversed.chars = rawToChar(my.var)
print(reversed.chars)
cat("my.var = ", my.var)
cat("type of my.var = ", typeof(my.var))
cat("class of my.var = ", class(my.var))

# vector of complex values
my.var2 = 10 + 5i
print(my.var2)
cat("my.var2 = ", my.var2)
cat("type of my.var2 = ", typeof(my.var2))
cat("class of my.var2 = ", class(my.var2))

print("hello hell")
