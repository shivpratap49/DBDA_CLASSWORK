# Data frame
# - two dimensional collection
# - represents the data in tabular format
# - contains (horizontal) rows and (vertical) columns
# - list of lists

# vectors represent the columns of data frame
names = c("person1", "person2", "person3", "person4")
ages = c(30, 40, 10, 50)
addresses = c("mumbai", "pune", "satara", "karad")

# create a data frame
# here: name, age and address are the column names
df.persons = data.frame(
  name=names,
  age=ages,
  address=addresses
)
print(df.persons)
cat("type of df.persons: ", typeof(df.persons), ", class: ", class(df.persons))
  
  

# create a data frame to store cars information
df.cars = data.frame(
  model=c("triber", "nano", "XUV7", "X5"),
  company=c("renault", "tata", "mahindra", "BMW"),
  price=c(10, 2.5, 20, 45)
)
print(df.cars)



# getwd()
# - used to get the current working directory

# read csv file into a data frame
# csv: command separated values
# read.csv(): used to read the data from csv file
df.salary = read.csv("salary_data.csv")
print(df.salary)
cat("class of salary = ", class(df.salary))




  