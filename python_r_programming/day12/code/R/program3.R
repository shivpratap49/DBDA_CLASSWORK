# Matrix
# - two dimensional collection
# - types
#   - column first
#     - create columns first and then rows
#   - row first
#     - create rows first and then columns

# param1: vector of values
# param2: no of rows
# param3: no of columns
# column-first matrix
# m1 = matrix(c(10, 20, 30, 40), nrow = 2, ncol = 2, byrow = F)
m1 = matrix(c(10, 20, 30, 40), nrow = 2, ncol = 2)
print(m1)

# get value 10
print(m1[1, 1])

# get value 40
print(m1[2, 2])

# get the first row
print(m1[1, ])

# get the first column
print(m1[, 1])


# row-first matrix
# m2 = matrix(c(10, 20, 30, 40), 2, 2, T)
m2 = matrix(data = c(10, 20, 30, 40), nrow = 2, ncol = 2, byrow = T)
print(m2)


# recycling the values
# - if the number of values are not sufficient to construct 
#   the matrix, R repeats the values
m3 = matrix(c(10, 20, 30, 40), nrow = 4, ncol = 4)
print(m3)

print(m3[2, ])
print(m3[, 2])

# get the values from 3rd and 4th column of 2nd row
print(m3[2, 3:4])


# get the values from 2nd and 3rd column of 1st, 2nd and 3rd rows
print(m3[1:3, c(2, 3)])

# since the number of values (4) are not in the multiple of
# no of rows (3), matrix will generate a "warning"
# still the matrix will be constructed
m4 = matrix(c(10, 20, 30, 40), nrow = 3, ncol = 3)
print(m4)


m5 = matrix(1:5 * 30, nrow=5, ncol = 5)

# get the 1st and 3rd column
print(m5[, c(1, 3)])

# get the 2nd and 5th row
print(m5[c(2, 5), ])

# get the value at 3rd row and 5th column
print(m5[3, 5])

# get the values from 2nd and 4th rows and 5th and 4th columns
print(m5[c(2, 4), c(5, 4)])

# get the values from 1, 2, 3 rows and 3, 4 columns
print(m5[1:3, 3:4])
print(m5[c(-4, -5), c(-1, -2, -5)])






  
  
  