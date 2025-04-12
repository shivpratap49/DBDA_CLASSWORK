# vim

## modes

- view mode
  - read only mode used to read the contents
  - default mode
- insert mode
  - write mode used to add the contents
- visual mode
  - read only mode used to select contents

```bash

# install vim
> sudo apt-get install -y vim

# launch vim
# > vim <file name>

```

## vim configuration commands

```bash

# make the line numbers visible
> esc + :set number + (press enter)

```

### create a vim configuration file

- create a new file named .vimrc in your home directory
- add the configurations
- save the file

```bash

# create file in home directory
> vim ~/.vimrc


```

## editing commands

```bash

# exit vim
> esc + : + q + (press enter)

# quit vim without saving the changes
> esc + : + q! + (press enter)

# quit vim with saving the changes
> esc + : + wq + (press enter)

# save the changes
> esc + : + w + (press enter)

# go to a line number
# > esc + : <line number> (press enter)
> esc + :1  (press enter)

# go to the last line
> esc + shift + g

# go to the first line
> esc + gg

# switch from view mode to insert mode
> esc + i

# add a new line
> esc + o

# copy (yank) one line
> esc + yy

# copy (yank) n number of lines
# > esc + <n>yy
> esc + 2yy

# cut or delete one line
> esc + dd

# cut or delete n number of lines
# > esc + <n>dd
> esc + 2dd

# paste the copies contents
> esc + p

# undo the last change
> esc + u

# redo the last change
> ctrl + r

# jump to the next word
> esc + w
> esc + shift + w

# jump to the previous word
> esc + b
> esc + shift + b

# delete the current word
> esc + dw

```

## editing multiple files

```bash

# open multiple files in different panes (Vertically)
# > vim <file1> <file2> -O
> vim myfile1.txt myfile2.txt -O

# open multiple files in different panes (Horizontally)
# > vim <file1> <file2> -o
> vim myfile1.txt myfile2.txt -o


# switch between the panes
> esc + ctrl + ww

# save all the files at the same time
> esc :wa + (press enter)

# quit vim from all the files
> esc :qa + (press enter)

```
