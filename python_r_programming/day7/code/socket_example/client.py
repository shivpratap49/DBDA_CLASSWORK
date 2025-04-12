import socket
import json

HOST = "127.0.0.1"
PORT = 4000

# message = input("enter your message")
message = {"name": "amit", "message": "this is a message from amit"}
message_str = json.dumps(message)

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    # client_socket.bind((HOST, PORT))
    client_socket.connect((HOST, PORT))

    # send data to server
    # encode method will convert string to byte form
    client_socket.send(message_str.encode('utf-8'))