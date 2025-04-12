
num1=100
num2=50

# greater than
if [ $num1 -gt $num2 ]
then
  echo "inside if block"
  echo "$num1 > $num2"
else
  echo "inside else block"
  echo "$num1 < $num2"
fi

# less than
if [ $num1 -lt $num2 ]
then
  echo "inside if block"
  echo "$num1 < $num2"
else
  echo "inside else block"
  echo "$num1 > $num2"
fi



# equls to
if [ $num1 -eq $num2 ]; then
  echo "$num1 == $num2"
else
  echo "$num1 != $num2"
fi












