# data frame

# read the data from csv file
df = read.csv("employees.csv")
print(df)

# get the number of rows
print(nrow(df))

# get the number of columns
print(ncol(df))

# get the column names
print(colnames(df))

# get the row names
print(rownames(df))

# read first few (6) records from the data frame
print(head(df))

# read first 3 records from the data frame
print(head(df, 3))

# read last few (6) records from the data frame
print(tail(df))

# read last 3 records from the data frame
print(tail(df, 3))

# describe the data frame
# get general information about the data frame
print(str(df))

# get statistical information about the data frame
print(summary(df))


