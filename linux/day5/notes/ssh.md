# ssh

- stands for secure shell
- protocol which uses port 22
- it uses client-server architecture

```bash

# install ssh
> sudo apt-get install openssh-server

# get the ip address of remote machine
> ip addr show
> ip a

# password-based login
# connect other machine using ssh
# > ssh <username>@<remote machine ip address>
> ssh nuser@192.168.227.145


# password-less login
# - login without entering password every time

# all these commands must be executed on client machine
# step 1:
# - generate a ssh key pair
# - pair: private (decryption) + public (encryption) key
# - this command will generate two files in /home/<current user>/.ssh directory
#   named id_rsa (private) and id_rsa.pub (public)
> ssh-keygen

# step 1.1: optionally required (if server is running ubuntu)
# - execute this command on server
> sudo mkdir /home/nuser
> sudo chown -R nuser:nuser /home/nuser

# step 2:
# - share client's public key with server
# > ssh-copy-id <username>@<remote machine ip address>
> ssh-copy-id nuser@192.168.227.145

```
