# import Flask class from flask package
# Flask: class used to create server
# request: request object sent by client
# render_template: function used to load html file from templates directory
from flask import Flask, request, render_template

# create a server
# create an object of Flask
# responsible for
# - creating socket
# - hosting the web services
# - hosting the websites
app = Flask(__name__)

# routing table
# method  path        function
# GET     /           root
# GET     /products   get_products


# route
# - mapping between http method and url/path
@app.route("/", methods=["GET"])
def root():
    return '''<h1 style="color: red">Login</h1>'
    <form action="/login" method="POST">
        <div>First Name: <input type="text" name="first_name"></div>
        <div>Last Name: <input type="text" name="last_name"></div>
        <div><input type="submit"></div>
    </form>
    '''


# web service: GET /products
# web API: GET /products
# API: Application Programming Interface
@app.route("/products", methods=["GET"])
def get_products():
    return [
        {"title": "product 1", "price": 100, "description": "this is nice product"},
        {"title": "product 2", "price": 200, "description": "this is nice product"},
        {"title": "product 3", "price": 300, "description": "this is nice product"},
    ]


@app.route("/login", methods=["POST"])
def login():
    first_name = request.form.get("first_name")
    last_name = request.form.get("last_name")
    print(f"name: {first_name} {last_name}")
    return "result"


@app.route("/help", methods=["GET"])
def get_help():
    return render_template("help.html")


@app.route("/register", methods=["GET"])
def register_user():
    return render_template("register.html")


# start the server
app.run(host="0.0.0.0", port=4500, debug=True)
