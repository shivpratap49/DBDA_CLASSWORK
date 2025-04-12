# check if a number is even or odd

echo "enter a number: "

# create a new variable named number and read the input given by user
read number

# if (number % 2 == 0)
if [ $(expr $number % 2) -eq 0 ]
then
  echo "$number is an even number"
else
  echo "$number is not an even number"
fi
