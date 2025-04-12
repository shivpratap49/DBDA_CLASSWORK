# type inspection
# - inspecting value stored inside a variable
# - all inspection functions start with is.*

num = 200
cat("is num vector of double = ", is.double(num))
cat("is num vector of integer = ", is.integer(num))
cat("is num vector of character = ", is.character(num))
cat("is num vector of raw = ", is.raw(num))
cat("is num vector of logical = ", is.logical(num))
cat("is num vector of complex = ", is.complex(num))


# type conversion
# - converting a value from one type to another
# - all conversion functions start with as.*
cat("200 in double = ", as.double(num))
cat("200 in integer = ", as.integer(num))

str.num = as.character(num)
cat("200 in character = ", str.num, ", type = ", typeof(str.num))
cat("200 in Logical = ", as.logical(num))
cat("0 in Logical = ", as.logical(0))
cat("-1 in Logical = ", as.logical(-1))



