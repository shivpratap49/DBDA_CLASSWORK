from flask import Flask
import json


# Flask(__name__) is creating an object of Flask class
app = Flask(__name__)


@app.route("/products", methods=["GET"])
def get_products():
    with open("products.json", "r") as file:
        data = file.read()

        # converting json to list of dictionaries
        products = json.loads(data)
        return products


@app.route("/test", methods=["POST"])
def post_test():
    print("inside post_test()")
    return "post method tested"

# host: 127.0.0.1
# port: 4000
# debug: False
app.run(port=4000, debug=True)
