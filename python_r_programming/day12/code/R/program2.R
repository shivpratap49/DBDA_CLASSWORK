# List
# - with temporary names

l1 = list(
  numbers=c(10, 20, 30, 40),
  names=c("steve jobs", "bill gates")
)
print(l1)
print(l1[[1]])
print(l1$numbers)
print(l1$numbers[2:3])
print(l1$names)
print(l1$names[2])


l2 = list(
  prime=c(3, 5, 7, 11, 13, 17),
  names=c("James Clear", "Joe Dispenza", "Brian Tracy"),
  books=c("The Alchemist", "Atomic Habits"),
  phones=c("iPhone 16 pro", "Samsung S23"),
  watches=c("Apple Watch series 10", "Asus Xen Watch", "Sony Smart Watch")
)

# [5, 7, 13, 17]
print(l2$prime[c(2:3, 5:6)])
print(l2$prime[c(2, 3, 5, 6)])
print(l2$prime[c(-1, -4)])

# "James Clear"
# ["The Alchemist", "Atomic Habits"]
# "Samsung S23"
# "Apple Watch series 10"

