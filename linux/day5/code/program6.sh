
num1=99
num2=50

# addition 
# addition = num1 + num2
addition=$(expr $num1 + $num2)
echo "addition = $addition"

# subtraction
# subtraction = num1 - num2
subtraction=$(expr $num1 - $num2)
echo "subtraction = $subtraction"

# division
# - this division will always ignore the decimal result
#   and will return only integer part of the result
# division = num1 / num2
division=$(expr $num1 / $num2)
echo "division = $division"

# division
division=$(echo "scale=2; $num1 / $num2" | bc)
echo "division = $division"

# multiplication
# multiplication = num1 * num2
multiplication=$(expr $num1 \* $num2)
echo "multiplication = $multiplication"

# modulous
# modulus = num1 % num2
modulous=$(expr $num1 % $num2)
echo "modulous = $modulous"


















