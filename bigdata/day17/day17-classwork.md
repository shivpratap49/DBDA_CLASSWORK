
### Run Hadoop MR Job

```sh
> hadoop jar $HADOOP_HOME/share/hadoop/tools/lib/hadoop-streaming-3.3.2.jar\
    -files mapper.py,reducer.py\
    -mapper mapper.py\
    -reducer reducer.py\
    -input /user/nilesh/wordcount/input\
    -output /user/nilesh/wordcount/output
```

### HBase 

```ruby
create 'people', 'name', 'info'

describe 'people'

put 'people', '001', 'name:fname', 'Nilesh'
put 'people', '001', 'name:lname', 'Ghule'
put 'people', '001', 'name:sal', 'Mr'

put 'people', '001', 'info:email', 'nilesh@gmail.com'
put 'people', '001', 'info:mobile', '9527331338'

put 'people', '002', 'name:fname', 'Nitin'

put 'people', '002', 'info:email', 'nitin@gmail.com'
put 'people', '002', 'info:mobile', '9881208115'
put 'people', '002', 'info:fax', '24260308'

put 'people', '003', 'name:fname', 'Prashant'
put 'people', '003', 'name:lname', 'Lad'

put 'people', '003', 'info:email', 'prashant@gmail.com'

put 'people', '004', 'name:fname', 'Sunbeam'

put 'people', '004', 'info:website', 'sunbeaminfo.com'


put 'people', '007', 'name:fname', 'James'
put 'people', '007', 'name:lname', 'Bond'
put 'people', '007', 'name:sal', 'Mr'

put 'people', '007', 'info:company', 'Universal Exports'

put 'people', '006', 'name:fname', 'Mayur'
put 'people', '006', 'info:company', 'Sunbeam'

# get each cell value
# > get 'table', 'rowid', 'column'
get 'people', '007', 'info:company'

get 'people', '007', 'name'

# get row
# > get 'table', 'rowid'
get 'people', '002'

# full table scan
scan 'people'

# row filtering
# startrow included, endrow excluded
scan 'people', { STARTROW => '002', ENDROW => '004' }

# projection
scan 'people', { COLUMNS => ['name:fname', 'name:lname'] }

scan 'people', { COLUMNS => ['name:fname', 'info:mobile'] }

scan 'people', { STARTROW => '002', ENDROW => '004', COLUMNS => ['name:fname'] }

# delete
get 'people', '001'

delete 'people', '001', 'name:email'

delete 'people', '002', 'info:fax'

disable 'people'

# ----

enable 'people'

put 'people', '008', 'name:fname', 'Superman'

put 'people', '008', 'info:addr', 'Crypton'

disable 'people'
```

```ruby
create 'emp', { NAME => 'name' }, {  NAME => 'sal', VERSIONS => 3 }

describe 'emp'

put 'emp', '001', 'name', 'Smith'
put 'emp', '001', 'sal', '800'
put 'emp', '002', 'name', 'John'
put 'emp', '002', 'sal', '1000'
put 'emp', '003', 'name', 'King'
put 'emp', '003', 'sal', '5000'
put 'emp', '004', 'name', 'Scott'
put 'emp', '004', 'sal', '2500'

put 'emp', '001', 'sal', '950'

get 'emp', '001'

put 'emp', '001', 'sal', '990'

get 'emp', '001'

get 'emp', '001', { COLUMNS => ['sal'], VERSIONS => 3 }

put 'emp', '001', 'sal', '1000'

get 'emp', '001', { COLUMNS => ['sal'], VERSIONS => 3 }

disable 'emp'

enable 'emp'

put 'emp', '001', 'sal', '900'

get 'emp', '001', { COLUMNS => ['sal'], VERSIONS => 3 }

disable 'emp'
```

