# vectors with multiple values
# - c()
#   - combine multiple values in a vector

# vector of double / numeric
numbers = c(10, 20, 30, 40, 50, 10, 20, 30, 40, 50)
cat("numbers =", numbers)
cat("type of numbers =", typeof(numbers))
cat("class of numbers =", class(numbers))


# vector of integer values
int.values = c(10L, 20L, 30L, 40L, 50L)
cat("int.values = ", int.values)
cat("type of int.values = ", typeof(int.values))
cat("class of int.values = ", class(int.values))

# vector of characters
countries = c("india", "usa", "uk", "japan")
cat("countries = ", countries)
cat("type of countries = ", typeof(countries))
cat("class of countries = ", class(countries))

# vector of Logical
men.can.vote = c(TRUE, FALSE, T, F, T, F)
cat("men.can.vote = ", men.can.vote)
cat("type of men.can.vote = ", typeof(men.can.vote))
cat("class of men.can.vote = ", class(men.can.vote))


# vector of complex
complex.values = c(10+5i, 20+10i)
cat("complex.values = ", complex.values)
cat("type of complex.values = ", typeof(complex.values))
cat("class of complex.values = ", class(complex.values))

# vector raw values
raw.values = c(charToRaw("नमस्ते"), charToRaw("अलविदा"))
cat("raw.values = ", raw.values)
cat("type of raw.values = ", typeof(raw.values))
cat("class of raw.values = ", class(raw.values))

# vector of mixed values
# - the vector will convert all the values to a common data type
# - common: the largest data type, in which R can convert all the values
my.vector = c(10, 20L, "test", FALSE)
cat("my.vector = ", my.vector)
cat("type of my.vector = ", typeof(my.vector))
cat("class of my.vector = ", class(my.vector))

# vector of double/numeric
my.vector2 = c(10, 20L, 30L, 40, 50)
cat("my.vector2 = ", my.vector2)
cat("type of my.vector2 = ", typeof(my.vector2))
cat("class of my.vector2 = ", class(my.vector2))

