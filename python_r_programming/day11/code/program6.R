# range(start, stop, step)
# range operator
# - used to generate a vector of sequential values
# - syntax
#   start:stop
# - the stop (upper bound) will be INCLUDED in the result
# - 1:10 => c(1, 2, ... 10)


numbers = 1:10
cat("numbers = ", numbers)

numbers = c(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

# [10, 20, 30, 40]
cat("numbers[1:4] = ", numbers[1:4])

# [50, 60, 70]
cat("numbers[5:7] = ", numbers[5:7])

# [80, 90, 100]
cat("numbers[8:10] = ", numbers[8:10])

# this line works in python
# in R, the start parameter is mandatory
# cat("numbers[:4] = ", numbers[:4])

# this line works in python
# in R, the stop parameter is mandatory
# cat("numbers[8:] = ", numbers[8:])

# this line works in python
# in R, the start and stop parameters are mandatory
# cat("numbers[:] = ", numbers[:])