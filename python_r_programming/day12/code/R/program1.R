# List
# - multi-dimensional collection made up with vectors
# - types
#   - without temporary names
#   - with temporary names


# list of 2 vectors
l1 = list(
  c(10, 20, 30, 40, 50),
  c(60, 70, 80, 90, 100)
)
print(l1)
cat("type = ", typeof(l1), ", class = ", class(l1))

# get the first vector from list
# [10, 20, 30, 40, 50]
print(l1[[1]])

# get the value 10
print(l1[[1]][1])

# get the value 40
print(l1[[1]][4])

# get the second vector from list
# [60, 70, 80, 90, 100]
print(l1[[2]])

# get value 80
print(l1[[2]][3])


# to create a list, vectors may have different sizes
l2 = list(
  c(10, 20),
  c(30, 40, 50),
  c(60, 70, 80, 90)
)
print(l2)


# to create a list, different vectors may contain different
# type of values 
l3 = list(
  c(10, 20, 30, 40, 50),
  c("steve jobs", "bill gates", "elon musk"),
  c(T, F),
  c(10.50, 69.90, 45.70)
)
print(l3)

# [T, F]
print(l3[[3]])

# "steve jobs"
print(l3[[2]][1])

# 30
print(l3[[1]][3])

# 69.90
print(l3[[4]][2])

# ["bill gates", "elon musk"]
print(l3[[2]][c(2, 3)])
print(l3[[2]][-1])
print(l3[[2]][2:3])

# [30, 40, 50]
print(l3[[1]][c(3, 4, 5)])
print(l3[[1]][c(-1, -2)])
print(l3[[1]][3:5])

# FALSE
print(l3[[3]][2])



