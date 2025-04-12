# EC2

- elastic compute cloud
- used to create virtual machines in AWS cloud
- virtual machine is called as EC2 instance

## EC2 instance

- name: ml-server
- AMI: Ubuntu Server 24.04 LTS
- Architecture: 64-bit (x86)
- instance type: t2.micro
- Key-pair
  - name: dbda-mar-24
  - type: RSA
  - format: .pem
- storage: 8GB (max 30GB)

## connect to the server

```bash

# connect using ssh command
# > ssh -i <pem file path> <user>@<public ip address>
> ssh -i ~/Downloads/dbda-mar-24.pem ubuntu@13.233.67.131

# if you get an error: WARNING: UNPROTECTED PRIVATE KEY FILE!
# change the permissions of pem file
> chmod 400 ~/Downloads/dbda-mar-24.pem


```

## configure the server

### general configuration

- please please please execute these commands on cloud machine

```bash

# update the apt repositories
> sudo apt-get update

```

### python configuration

```bash

# install pip3
> sudo apt-get install python3-pip

# install required packages
> pip3 install numpy pandas matplotlib scikit-learn seaborn flask pickle4 --break-system-packages

```

## upload the application to run on server

- please execute these commands on your machine

```bash

# go to the code directory
# archive the server directory (which contains the flask code)
> tar -cvf server.tar server

# upload the tar file to server
# scp: secure copy used to copy a file from one machine to another
# > scp -i <pem file path> <file to be uploaded> <user>@<public ip>:~/
> scp -i ~/Downloads/dbda-mar-24.pem server.tar ubuntu@13.233.67.131:~/

```

- please execute the following commands on server/cloud machine

```bash

# go to the home directory
> cd ~/

# confirm if server.tar file exists
> ls -l

# extract the server tar file
> tar -xvf server.tar

# run the server application for testing
> cd server
> python3 main.py

# if you get an error: Address already in use
> lsof -i :4000
# this will show the process id (PID) which is using port 4000
> kill -9 <PID from the above list>

```

### port configuration

```bash

# select the instance from the instances list
# go to the security tab below
# select the security group configured for selected machine
# security group is acting as a firewall for your virtual machine
# click the "Edit Inbound Rules" button
# inbound rules: the ports which are required to open
# click the button: Add rule
# - type: Custom TCP
# - Port Range: 4000
# - Source: Anywhere-IPv4 (0.0.0.0/0)
# click the save rules button

```

### node configuration

```bash

# install curl
> sudo apt-get install -y curl

# download the apt key
> curl -fsSL https://deb.nodesource.com/setup_22.x -o nodesource_setup.sh
> sudo bash nodesource_setup.sh

# update the apt repository
> sudo apt-get update

# install the latest version of nodejs
> sudo apt-get install -y nodejs

# confirm the node installation
> node -v

# install pm2
> sudo npm install -g pm2

# goto the server directory (where you have stored your code)
> cd ~/server

# start the server using pm2
> pm2 start main.py --interpreter python3

```
