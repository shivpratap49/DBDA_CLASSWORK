# scripting

- automating command execution
- file which contains the commands to be executed
- in linux, it is known as shell scripting as the program will use the shell's features to add programming techniques (variables, functions, loops etc)
- it is also known as bash scripting as the shell to be used to execute the script is bash (which is standard shell on most of the modern linux distros)

## she-bang header

- the first line of a script which tells the shell, which interpreter is needed to execute the script
- it starts with #! <interpreter executable path>
- it MUST be the first line of the script
- e.g. #! /usr/bin/python3

## function

- block of statements with a name
- types
  - built-in functions
    - echo: used to print the string on console (stdout)
    - expr: used to evaluate an expression (operators)
    - read: used to read input from user (using keyboard)
  - user defined functions

## variable

- identifier which stores a value (in memory)
- it may change its value
- declaration
  - <variable name>=<variable value>
- e.g.
  - num=100
- to read value of a variable use $ along with the variable name
  - echo $num

## operators

- mathematical operations

  - addition
    - e.g. addition=$(expr $num1 + $num2)
  - subtraction
    - e.g. subtraction=$(expr $num1 - $num2)
  - division with integer result
    - e.g. division=$(expr $num1 / $num2)
  - division with float result
    - e.g. division=$(echo "scale=2; $num1 / $num2" | bc)
  - multiplication
    - e.g. multiplication=$(expr $num1 \* $num2)

- relational operators
  - greater than: -gt
  - less than: -lt
  - greater than or equals to: -ge
  - less than or equals to: -le
  - equal equals to: -eq
  - no equals to: -ne

## conditional statements (if..else)

```bash

# syntax
# if [ <condition> ]
# then
#   if block
# else
#   else block
# fi


# syntax
# if [ <condition> ]; then
#   if block
# else
#   else block
# fi

```

## array

- collection of values
- use () to create an array
- e.g.
  - numbers=(10 20 30 40 50)
  - cities=("pune" 'satara' karad)

## loop statements

- for..in loop

  - used to get all the value by iterating over an array
  - syntax:

  ```bash

  # for <temp variable> in ${<collection>[@]}
  # do
  #     # code here
  # done

  ```

- traditional for loop

  - getting the values using their index positions
  - syntax:

  ```bash

    # for index in ${!<collection>[@]}
    # do
    #     # code here
    # done

  ```

- while loop

## user defined function

- block of statements with a name
- syntax

```bash

# function definition
function <function name> {
    # function body
}

# function call
<function name>

```
