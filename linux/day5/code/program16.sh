# 1. print todays date
# 2. print this month's calendar
# 3. print the contents of /tmp directory
# 4. check if file /etc/passwd is present
# 5. exit


function show_menu_options {
  echo "welcome to our application"
  echo "1. print todays date"
  echo "2. print this months calendar"
  echo "3. print contents of /tmp directory"
  echo "4. check if /etc/passwd file is present"
  echo "5. exit"
  
  echo "enter your choice: "
  read choice
  
  # return the value to the caller
  # return keyword can return value only below 255
  return $choice
  
  # otherwise use echo $choice
  # echo $choice
}



function print_todays_date {
  echo "today is:  $(date)"
}

function print_calendar {
  cal
}


function print_tmp_directory_contents {
  echo "-- contents of /tmp directory --"
  ls /tmp/
}


function check_if_passwd_exists {
  # -f will check if file exists
  # -r will check if file is readable
  # -w will check if file is writable
  # -x will check if file is executable

  if [ -f /etc/passwd ]
  then
    echo "file is present"
  else
    echo "file does not exist"
  fi

  if [ -r /etc/passwd ]
  then
    echo "file is readble"
  else
    echo "file is NOT readable"
  fi

  if [ -w /etc/passwd ]
  then
    echo "file is writable"
  else
    echo "file is NOT writable"
  fi

  if [ -x /etc/passwd ]
  then
    echo "file is executable"
  else
    echo "file is NOT executable"
  fi

}


while true
do
  
  # show the menu and get the input
  # ch=$(show_menu_options)
  show_menu_options

  # get the return value from the function (choice)
  # $? returns the return value of last function called
  ch=$?
  # echo "choice = $ch"
  
  # check the choice and call the respective function
  case $ch in
    1)
      print_todays_date
      ;;
    2)
      print_calendar
      ;;
    3)
      print_tmp_directory_contents
      ;;
    4)
      check_if_passwd_exists
      ;;
    *)
      break
      ;;
  esac
done

