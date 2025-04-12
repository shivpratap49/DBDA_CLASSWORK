# calculate simple interest
echo "enter principle: "
read p

echo "enter duration: "
read n

echo "enter interest rate: "
read r


# numerator_tmp=$(expr $n \* $p)
# numerator=$(expr $numerator_tmp \* $r)
# echo "numerator = $numerator"

#numerator=$(echo "$n * $p * $r" | bc)
#si=$(echo "scale=2; $numerator / 100" | bc)

si=$(echo "scale=2; ($n * $p * $r) / 100" | bc)
echo "simple interest = $si"
