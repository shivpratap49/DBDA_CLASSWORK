numbers=(10 20 30 40 50)

# for..in loop
for value in ${numbers[@]}
do
  echo "value = $value"
done

echo ""


# traditional for loop
for index in ${!numbers[@]}
do
  echo "value at position $index = ${numbers[$index]}"
done

