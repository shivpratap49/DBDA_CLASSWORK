# user management

```bash

# - find user information (user id and group id)
# - check if user exists in the system
# > id <username>
> id amitk

# check which user you are logged in with
> whoami

# add a user
# > sudo useradd <username>
> sudo useradd user1

# add a user with home directory
# > sudo useradd -d <home directory path> <username>
> sudo useradd -d /home/elsa elsa

# change current user password
> passwd

# change other user's password
# - using super user's permissions
# > sudo passwd <username>
> sudo passwd user1

# login with a user
# > su - <username>
> su - user1


# delete a user account
# NOTE: you CANNOT delete the current logged-in user
# > sudo userdel <username>
> sudo userdel user1

# delete a user with home directory
> sudo userdel -r user1

```

## exercise 1

```bash

# create a user elsa with password frozen (useradd)
> sudo useradd elsa
> sudo passwd elsa

# verify if the user got created successfully (id)
> id elsa

# login with elsa user (su)
> su elsa

# check the current user name (whoami)
> whoamiw

# delete the user account (userdel)
> sudo userdel elsa

```

# group management

- group is a group / collection of users
- used to assign common permissions to many users at a same time
- by default when a user gets created, system creates a new group with same name as user
- every user has one and only one primary group (by default same as user name)
- every user may be a part of one more secondary group(s)
- the group information is stored in /etc/group
- there are 4 columns
  - root:x:0:
  - column 1: group name
  - column 2: setting group password (not used anymore in modern linux)
  - column 3: group id
  - column 4: group description

```bash

# create a group
# > sudo groupadd <group name>
> sudo groupadd g1

# get the users parts of a group
# > groups <group name>
> groups user1

# delete a group
# NOTE: you can not delete a group if there is at least one primary user exists
# > sudo groupdel <group name>
> sudo groupdel g1

```

## exercise 2

```bash

# create a user named user2
> sudo useradd user2

# change the password of user2 to test
> sudo passwd user2

# create a group named devs
> sudo groupadd devs

# set devs as primary group of user2
# > sudo usermod -g <primary group name> <username>
> sudo usermod -g devs user2

# set devs as a secondary group of user2
# > sudo usermod -aG <primary group name> <username>
# -a: append
# -G: secondary group
> sudo usermod -aG devs user2


# verify the user information
> id user2

# delete user user2
> sudo userdel user2

# delete group devs
> sudo groupdel devs

```

## exercise 3

```bash

# create a user name elsa
> sudo useradd elsa

# create a group named frozen
> sudo groupadd frozen

# set frozen as primary group of elsa
> sudo usermod -g frozen elsa

# delete user elsa
> sudo userdel elsa

# delete group frozen
> sudo groupdel frozen

# delete group elsa
> sudo groupdel elsa

```

## exercise 4

```bash

# create users ana, elsa, olaf
> sudo useradd ana
> sudo useradd elsa
> sudo useradd olaf

# create a group frozen
> sudo groupadd frozen

# add ana, elsa and olaf to frozen (as secondary group)
> sudo usermod -aG frozen ana
> sudo usermod -aG frozen elsa
> sudo usermod -aG frozen olaf

# verify the membership using id and groups commands
> id ana
> groups elsa

# delete ana, elsa and olaf users
> sudo userdel ana
> sudo userdel elsa
> sudo userdel olaf

# delete frozen group
> sudo groupdel frozen

```

# permissions

- linux provides permissions
  - read (4)
  - write (2)
  - execute (1)

```bash

# get the permissions
# > ls -l <file name>
> ls -l tom_file

# change the permission
# > chmod <absolute number> <file name>

# this will set the permissions to r--------
> chmod 400 tom_file

# this will set the permissions to rw-rw----
> chmod 660 tom_file

# this will set the permissions to rwxrwxrwx
> chmod 777 tom_file

# change the ownership
# > chown <username>:<groupname> <file name>

# this will set the group of the file to tandj
> chown tom:tandj tom_file
> chown :tandj tom_file

# this will set the user to jerry and group to jerry
> sudo chown jerry:jerry tom_file
> sudo chown jerry tom_file

# this will set the group of the file to tandj
> sudo chgrp tandj tom_file

```

## exercise 4

```bash

# create a user named nuser with password test
> sudo useradd nuser
> sudo passwd nuser

# check the ip address of your machine
> ip addr show
> ip a

# check network connectivity
> ping <ip address>

# connect to the network machine using ssh
# > ssh <username>@<ip address>
> ssh nuser@<ip address>

# install open ssh server
> sudo apt-get install openssh-server

```
