from flask import Flask, request
import pickle
import sklearn

# load the model
with open("model.pkl", "rb") as file:
    model = pickle.load(file)

# configure and run the flask server

# create the server
app = Flask(__name__)


# create a route for root
@app.route("/", methods=["GET"])
def root():
    return """
        <h1>Salary Prediction</h1>
        <p>This program will use Linear Regression Model to predict your salary based on your experience</p>
        <form method="POST" action="/predict">
            <div>
                <label>Enter your Experience</label>
                <input name="experience" type="number" />
            </div>
            <div>
                <input type="submit" value="Predict" />
            </div>
        </form>
    """


@app.route("/predict", methods=["POST"])
def predict():
    # get the value from user in str format
    experience = request.form.get("experience")

    # convert the string experience into float value
    experience = float(experience)

    # predict the salary
    # the predict method returns a list
    salary = model.predict([[experience]])

    return f"""
        <h1>Salary Prediction</h1>
        <p style="font-size: 25px">Based on our learning your expected salary could be: <span style="color: red; font-weight: bold;">${salary[0]}</span></p>
    """


# start the server on port 4000
app.run(host="0.0.0.0", port=4000, debug=True)
