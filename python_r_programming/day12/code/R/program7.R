# factors
# - collection which stores the data as categories
# - represents categorical data
# - e.g. c("red", "yellow", "pink", "red", "pink", "white", "white", "red", "yellow", "red")

# vector of character data
colors = c("red", "yellow", "pink", "red", "pink", "white", "white", "red", "yellow", "red")
print(colors)

# create a factor of data
factor.colors = factor(colors)
print(factor.colors)
print(unique(colors))

# create a factor with replacement of values
# - one hot encoding technique
# - convert a character data into numeric one

factor.colors2 = factor(colors, 
                  levels = c("red", "yellow", "white", "pink"),
                  labels = c(10, 20, 30, 40))
print(factor.colors2)


names = c("steve", "james", "elon", "steve", "james", "joe", "jenefer")

factor.names = factor(names)
print(factor.names)

factor.names2 = factor(names, 
                   levels = c("steve", "james", "elon", "joe"), 
                   labels = c(1, 2, 3, 4))
print(factor.names2)


# install a package globally
install.packages('caret')
install.packages('dplyr')

# load or import a package
library(caret)






