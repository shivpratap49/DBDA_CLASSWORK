# iterating over a vector
numbers = c(10, 20, 30, 40, 50)
for (number in numbers) {
  cat("number = ", number, "\n")
}

colors = c("red", "yellow", "green", "brown")
for (color in colors) {
  cat("color = ", color, "\n")
}

# indexing
# - getting the values with index positions
# - types
#   - positive
#     - the vectors starts the index from 1
#     - index 1 stores the first value of vectors
#     - index len(vector) will store the last value

# indexes = 1,  2,  3,  4,  5
numbers = c(10, 20, 30, 40, 50)
cat("numbers[1] = ", numbers[1])
cat("numbers[2] = ", numbers[2])
cat("numbers[3] = ", numbers[3])
cat("numbers[4] = ", numbers[4])
cat("numbers[5] = ", numbers[5])


#   - negative
#     - return the whole vector except the position
#     - -1 means, return all the values in vector except the first one
#     - used to exclude the index position

# [20 30 40 50]
cat("numbers[-1] = ", numbers[-1])

# [10 30 40 50]
cat("numbers[-2] = ", numbers[-2])

# [10 20 40 50]
cat("numbers[-3] = ", numbers[-3])



# - getting multiple values using multiple index positions

# get the values on 1st, 3rd and 5th index positions
# [10 30 50]
cat("numbers[c(1, 3, 5)] = ", numbers[c(1, 3, 5)])

# [50, 10, 40]
cat("numbers[c(5, 1, 4)] = ", numbers[c(5, 1, 4)])

# [20, 40]
cat("numbers[c(-1, -3, -5)] = ", numbers[c(-1, -3, -5)])

# [10, 30, 40]
cat("numbers[c(-5, -2)] = ", numbers[c(-5, -2)])

# this line will produce error
# as R does not allow to mix positive and negative index positions
# cat("numbers[c(-1, 5)] = ", numbers[c(-1, 5)])

# this line will produce no output
cat("numbers[0] = ", numbers[0])

# this line does not raise any error
# it ignores 0 and returns the result as per negative index calculation
# [20 30 40 50]
cat("numbers[c(-1, 0)] = ", numbers[c(-1, 0)])


# - multiple logical indexing
#   - getting the values using the logical index positions
#   - use True if value at the index is required
#   - use False if value at the index is NOT required

# [10, 30, 50]
cat("numbers[c(T, F, T, F, T)] =", numbers[c(T, F, T, F, T)])

# [20, 50]
cat("numbers[c(F, T, F, F, T)] = ", numbers[c(F, T, F, F, T)])



my.values = c(30, 20, 10, 40, 50, 60, 70)

# [20, 10, 40]
# [40, 50]
# [50, 60, 70]
# [30, 10, 40, 70]
# [10, 40, 60, 70]
# [20, 50, 60]

# if the index is not present in vector, you get NA value
# NA: predefined value, Not Available
# cat("my.values[20] =", my.values[20])









