## Introduction to Data Analysis

### Fundamentals of data analysis
![Screenshot](image1.png)

### Data wrangling

- Data wrangling is the process of preparing the data and getting it into a format that can be used for analysis

- The following are some issues we may encounter with our data:
  - **Human errors**: Data is recorded (or even collected) incorrectly, such as putting 100 instead of 1000, or typos. In addition, there may be multiple versions of the same entry recorded, such as New York City, NYC, and nyc
  - **Computer error**: Perhaps we weren't recording entries for a while (missing data)
  - **Unexpected values**: Maybe whoever was recording the data decided to use ? for a missing value in a numeric column, so now all the entries in the column will be treated as text instead of numeric values
  - **Incomplete information**: Think of a survey with optional questions; not everyone will answer them, so we have missing data, but not due to computer or human error
  - **Resolution**: The data may have been collected per second, while we need hourly data for our analysis
  - **Relevance of the fields**: Often, data is collected or generated as a product of some process rather than explicitly for our analysis. In order to get it to a usable state, we will have to clean it up
  - **Format of the data**: The data may be recorded in a format that isn't conducive to analysis, which will require that we reshape it
  - **Misconfigurations in data-recording process**: Data coming from sources such as misconfigured trackers and/or webhooks may be missing fields or passing them in the wrong order

---

## Working with Pandas

### Series
- provides a data structure for arrays of data of a single type, just like the NumPy array
- However, it comes with some additional functionality
- This one-dimensional representation can be thought of as a column in a spreadsheet
- We have a name for our column, and the data we hold in it is of the same type 
- **attributes**
  - index
  - values

### Data Frames
- builds upon the Series class; we can think of it as representing the spreadsheet as a whole
- It can have many columns, each with its own data type
- We can turn either of the NumPy representations we built of the example data into a DataFrame object
- **attributes**
  - df.dtypes
  - df.values
  - df.columns
  - df.empty
  - df.shape
- **methods**
  - df.head()
  - df.tail()
  - df.info()
  - df.describe()
- **column attributes**
  - df.col.unique()
  - df.col.value_counts()
- **selection**
  - With selection, we grab entire columns
  - e.g.
    - df.col
    - df['col']
    - df[['col1', 'col2']]
- **indexing**
  - df.loc[10:15, 'col1']
  - df.loc[10:15, ['col1', 'col2']]
  - df.iloc[10:15, 0]
  - df.iloc[10:15, [0, 1]]
  - df.iloc[10:15, 8:10]
  - df.at[10, 'col1']
  - df.iat[10, 0]
- **slicing**
  - When we want to extract certain rows (slices) from our dataframe, we use slicing
  - e.g.
    - df[100:103]
    - df[['col1', 'col2']][100:103]
- **filtering**
  - df.col > 2
  - df[df.mag >= 7.0]
  - df.loc[df.mag >= 7.0, ['col1', 'col2']]
  - conditions
    - df.place.str.contains('Alaska')
    - df.alert.notnull()
    - (df.place.str.contains('Alaska')) & (df.alert.notnull())
    - df.mag.between(6.5, 7.5)
- **adding columns**
  - df = df.pop('col1')
  - df = df.drop([0, 1])
  - df.drop([0, 1], inplace=True)


### Data Wrangling

- In practice, there are three common tasks involved in the data wrangling process:
  - Data cleaning
    - Addressing missing or invalid data
      - df.fillna(0)
      - df.fillna({'Team': 'no team', 'Salary': 0, 'First Name': 'no name'})
      - df1 = df.fillna(method='bfill')
      - df1 = df.fillna(method='ffill') 
      - df1 = df.replace(values, with_values)
    - Renaming
      - df.columns
      - df.rename(columns = {'value' : 'temp_C', 'attributes' : 'flags'}, inplace=True)
      - df.rename(str.upper, axis='columns')
    - Sorting and reordering
      - df.sort_values(by='temp_C', ascending=False)
      - df.sort_values(by=['temp_C', 'date'], ascending=False)
      - df.nlargest(n=5, columns='temp_C')
      - df.sample(5, random_state=0)
    - Data type conversions
      - df.loc[:,'date'] = pd.to_datetime(df.date)
    - Deduplicating data
    - Filtering to the desired subset of data
    - Merging dataframes
      - pd.merge(df1, df2, on='city')
      - df3 = pd.merge(df1, df2, on='city')
      - df3 = pd.merge(df1, df2, on='city', how='left')
      - df3 = pd.merge(df1, df2, on='city', how='left', indicator=True)
  - Data transformation
  - Data enrichment
    - **Adding new columns**: Using functions on the data from existing columns to create new values
    - **Binning**: Turning continuous data or discrete data with many distinct values into range buckets, which makes the column discrete while letting us control the number of possible values in the column
    - **Aggregating**: Rolling up the data and summarizing it
      - df.query()
      - df.groupby()
    - **Resampling**: Aggregating time series data at specific intervals