from flask import Flask, render_template, request
import pickle

# load the model
with open("salary_prediction_model.pkl", "rb") as file:
    model = pickle.load(file)


# create a flask application
app = Flask(__name__)


@app.route("/", methods=["GET"])
def root():
    return render_template("index.html")


@app.route("/predict", methods=["POST"])
def predict_salary():
    # get the experience value sent by user
    experience = float(request.form.get("experience"))

    # predict the salary
    salaries = model.predict([[experience]])
    return render_template("output.html", experience=experience, salary=f"{salaries[0]:0.2f}")


# run the server
app.run(host="0.0.0.0", port=8000, debug=True)
