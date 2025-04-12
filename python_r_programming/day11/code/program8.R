# filtering values from vectors

salaries = c(20, 30, 25, 28, 27, 35, 37, 39)

for (salary in salaries) {
  if (salary > 30) {
    cat("fire the employee whos salary = ", salary, "\n")
  }
}

# broacast comparison operator
cat("salaries > 30 = ", salaries > 30)

# find the salaries > 30
cat("salaries[c(F, F, F, F, F, T, T, T)] = ", salaries[c(F, F, F, F, F, T, T, T)])

# filtering the values based on a condition
cat("salaries[salaries > 30] = ", salaries[salaries > 30])






