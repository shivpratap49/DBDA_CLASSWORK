# pip3 install requests
import requests


def main():
    # send a GET request and get the response
    response = requests.get("http://localhost:4000/products")
    products = response.json()
    for product in products:
        print(f"| {product['title']:<15} | {product['price']:^5} | {product['description']} |")

    # send a POST request
    # response = requests.post("http://localhost:4000/test")
    # print(response.text)

    # send a GET request
    # response = requests.get("https://dummy.restapiexample.com/api/v1/employees")
    # print(response.text)


if __name__ == '__main__':
    main()


