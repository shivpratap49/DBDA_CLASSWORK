import socket
import time
import threading

HOST = '0.0.0.0'
PORT = 4000


def handle_client(connection, info):
    print(f"NEW CONNECTION [{info}]")
    time.sleep(5)
    data = connection.recv(1024)
    print(f"received from client: {data}")


with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
    server_socket.bind((HOST, PORT))
    print(f"Server started listening on port {PORT}")
    while True:
        server_socket.listen()
        connection, info = server_socket.accept()

        # parallel execution of handling the client
        t = threading.Thread(target=handle_client, args=(connection, info))
        t.start()

        # sequential execution of handling client
        # handle_client(connection, info)
