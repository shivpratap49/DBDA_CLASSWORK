# get a temperator in celsius and convert it into fahrenheit
# formula: 32 + (temperature * (9/5))

echo "enter a termperature value in celsius: "
read temperature

temperature_f=$(echo "scale=2; 32 + ($temperature * (9/5))" | bc)
echo "$temperature in C = ${temperature_f} in F"

