# socket
# - gateway to communicate with other machines
# - requires
#   - ip address / host name of the machine
#   - a port number to be associated

# port number
# - integer value assigned to every process by OS
# - used to communicate with the process
# - types
#   - reserved ports
#     - well known ports
#       - all ports < 1024
#       - e.g. http (80), https (443), dns (52) etc.
#     - reserved ports
#       - which are used by famous servers
#       - e.g. mysql (3306), mongodb (27017), redis (6379) etc.
#   - non-reserved ports
#     - ports which are > 1024 and not reserved
#     - OS randomly assigns port to every process running in OS

# import the socket module
import socket

# stream: sequence of bytes

# create a socket
# server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# close the socket
# server_socket.close()

# using this ip address, only processed on same machine will be able
# to communicate with the server
# HOST = "127.0.0.1"

# using this ip address, all processed running on this machine or
# other machines in the network can communicate with the server
HOST = "0.0.0.0"
PORT = 4000

# create a socket
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:

    # bind the socket to the host name / address and port number
    server_socket.bind((HOST, PORT))
    print(f"server started listening on port 4000")

    while True:
        # start listening for incoming requests
        server_socket.listen()

        # this is a blocking function
        # - unless there is a client sending a request to connect this server
        #   this line wont let the program to continue the execution
        connection, info = server_socket.accept()
        print(f"New Connection from: {info}")

        # receive the data from client
        data = connection.recv(1024)
        data_str = data.decode('utf-8')
        print(f"data = {data}, {data_str}")

    print("end of the server")