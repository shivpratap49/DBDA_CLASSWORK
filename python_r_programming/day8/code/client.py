import socket

HOST = '127.0.0.1'
PORT = 4000

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    client_socket.connect((HOST, PORT))
    client_socket.send(b'this is a test data')

