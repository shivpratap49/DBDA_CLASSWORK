# function


# function definition
# parameterless function
# - does not accept any parameter
function my_function {
  echo "inside my_function"
}

# function call
# my_function


# parameterized function
function add_two_numbers {
  # read the first parameter
  n1=$1

  # read the second parameter
  n2=$2

  addition=$(expr $n1 + $n2)
  echo "addition = $addition"
}

# function call
# add_two_numbers 10 20


function multiply {
  multiplication=$(expr $1 \* $2)
  echo "multiplication = $multiplication"
}

multiply 30 50







