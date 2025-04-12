# Matrix 
# - with dimnames
# - dimnames
#   - dimension names
#   - it is a list of two vectors having names of rows and columns

m1 = matrix(c(
  "person1", 30, "pune",
  "person2", 40, "mumbai",
  "person3", 10, "satara",
  "person4", 50, "karad"
), nrow = 4, ncol = 3, byrow = T)
print(m1)

# get the first person's address
print(m1[1, 3])

# get the third person's age
print(m1[3, 2])


# the list contains the 
# - first vector having row names
# - second vector having columns name
dimnames = list(
  c("person1", "person2", "person3", "person4"), 
  c("name", "age", "address")
)

m2 = matrix(c(
  "person1", 30, "pune",
  "person2", 40, "mumbai",
  "person3", 10, "satara",
  "person4", 50, "karad"
), nrow = 4, ncol = 3, byrow = T, dimnames = dimnames)
print(m2)

# get the first person's address
print(m2["person1", "address"])

# get the third person's age
print(m2["person3", "age"])

m3 = matrix(c(
  "triber", "renault", 10,
  "nano", "tata", 2.5,
  "XUV7", "mahindra", 20,
  "X5", "BMW", 45
), nrow = 4, ncol = 3, byrow = T)

print(m3)

# get all models
print(m3[, 1])

# get all companies
print(m3[, 2])

# get all prices
print(m3[, 3])

# get triber's all info (model, company, price)
print(m3[1, ])

# get X5's price
print(m3[4, 3])

# get mahindra's model name
print(m3[3, 1])

# get nano's price
print(m3[2, 3])

# get XUV7's company and price
print(m3[3, 2:3])
print(m3[3, c(2,3)])
print(m3[3, -1])




m4 = matrix(c(
  "triber", "renault", 10,
  "nano", "tata", 2.5,
  "XUV7", "mahindra", 20,
  "X5", "BMW", 45
), nrow = 4, ncol = 3, byrow = T, 
dimnames = list(
  c("triber", "nano", "xuv7", "x5"),
  c("model", "company", "price")
))

print(m4)

# get all models
print(m4[, "model"])

# get all companies
print(m4[, "company"])

# get all prices
print(m4[, "price"])

# get triber's all info (model, company, price)
print(m4["triber", ])

# get X5's price
print(m4["x5", "price"])

# get mahindra's model name
print(m4["xuv7", "model"])

# get nano's price
print(m4["nano", "price"])

# get XUV7's company and price
print(m4["xuv7", c("company", "price")])













