# broadcast operation
# - the operation will be performed with every member of vector
# - all mathematical, comparison and logical operations in R are 
#   broadcast operations

# vector of numbers
numbers = c(10, 20, 30, 40, 50)

# mathematical operators

# add 20 in every member of numbers
# [30, 40, 50, 60, 70]
cat("numbers + 20 = ", numbers + 20)

# subtract 5 from every member of numbers
cat("numbers - 5 = ", numbers - 5)

# divide every member of numbers by 2
cat("numbers / 2 = ", numbers / 2)

# multiply every member of numbers by 2
cat("numbers * 2 = ", numbers * 2)

# get remainder by dividing every member by 3
cat("numbers % 3 = ", numbers %% 3)


# comparison operators

# check if every member is equal to 10
cat("numbers == 10 = ", numbers == 10)

# check if every member is not equal to 10
cat("numbers != 10 = ", numbers != 10)

# check if every member is greater than 30
cat("numbers > 30 = ", numbers > 30)

# check if every member is less than 30
cat("numbers < 30 = ", numbers < 30)

# check if every member is greater than or equal to 30
cat("numbers >= 30 = ", numbers >= 30)

# check if every member is less than or equal to 30
cat("numbers <= 30 = ", numbers <= 30)


# Logical operations

v1 = c(T, F, T, F)
v2 = c(F, T, T, F)

# this is deprecated
# - non broadcast operator
# v1[1] && v2[1]
# cat("v1 && v2 = ", v1 && v2)
cat("v1[1] && v2[1] = ", v1[1] && v2[1])

# [v1[1] & v2[1], v1[2] & v2[2] ..]
cat("v1 & v2 = ", v1 & v2)

# [v1[1] | v2[1], v1[2] | v2[2] ..]
cat("v1 | v2 = ", v1 | v2)


