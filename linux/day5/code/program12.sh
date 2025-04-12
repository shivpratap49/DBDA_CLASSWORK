# array of numbers
numbers=(10 20 30 40 50)
#numbers=()
echo "numbers = ${numbers[@]}"

# append a value to an array
numbers+=(60)
echo "numbers = ${numbers[@]}"

# append a value to an array
numbers+=(70)
echo "numbers = ${numbers[@]}"

# get input from user and append to the end of the array
echo "enter number: "
read number
numbers+=($number)
echo "numbers = ${numbers[@]}"
