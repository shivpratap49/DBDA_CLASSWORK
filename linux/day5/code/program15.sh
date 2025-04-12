# case..in: similar to switch case
echo "enter a number between 1 to 5: "
read number


# 1: red, 2: black, 3: yellow, 4: white, 5: brown
case $number in
  1)
    echo "you have enterred red color"
    ;;

  2)
    echo "you have enterred black color"
    ;;

  3)
    echo "you have enterred yellow color"
    ;;

  4)
    echo "you have enterred white color"
    ;;

  5)
    echo "you have enterred brown color"
    ;;

  # if user enters anything other than 1 to 5
  # this is called as default case
  *)
    echo "this is invalid value, are you drunk ?"
    ;;
esac

