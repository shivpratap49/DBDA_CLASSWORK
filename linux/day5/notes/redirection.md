# redirection

- input redirection (<)

  - instead of getting input from stdin (keyboard) get the input from a file
  - e.g. wc < /tmp/data.txt

- output redirection (> or >>)

  - sending the output to a file instead of displaying on stdout (console)
  - e.g. ls > /tmp/files.txt (this will overwrite the contents of files.txt)
  - e.g. ls >> /tmp/files.txt (this will append to the files.txt)

- error redirection (2>)
  - sending the error(s) to a file instead of displaying on stderr (console)
  - e.g. ls /etc/myfile 2> /tmp/error.txt

# pipeline

- getting an output of a command (process) and sending it as input to another command (process)
- e.g. cat /tmp/data.txt | wc -l

# grep

- gnu regular expression parser
- used to find / search the contents of a file
- e.g. cat /etc/passwd | grep root
