import tensorflow as tf
from tensorflow.keras.models import load_model
import pickle

from flask import Flask, render_template, request

# load the model
model = load_model("churn_model.h5")

# load the gender encoder
with open("gender_encoder.pkl", "rb") as file:
    gender_encoder = pickle.load(file)

# load the geography encoder
with open("geography_encoder.pkl", "rb") as file:
    geography_encoder = pickle.load(file)

# create the flask app
app = Flask(__name__)


@app.route("/", methods=["GET"])
def root():
    return render_template("index.html")


@app.route("/predict", methods=["POST"])
def predict():
    credit_score = int(request.form.get("credit_score"))
    balance = float(request.form.get("balance"))
    estimated_salary = float(request.form.get("estimated_salary"))
    age = int(request.form.get("age"))
    tenure = int(request.form.get("tenure"))
    geography = geography_encoder.transform([request.form.get('geography')])
    gender = gender_encoder.transform([request.form.get("gender")])
    number_of_products = int(request.form.get("number_of_products"))
    has_card = int(request.form.get("has_card"))
    is_active_member = int(request.form.get("is_active_member"))

    row = [credit_score, geography[0], gender[0], age, tenure, balance,
           number_of_products, has_card, is_active_member, estimated_salary]
    print(row)

    result = model.predict([row])[0][0]

    if result >= 0.5:
        result = f"Prediction = Yes, the customer will churn"
    else:
        result = f"Prediction = No, the customer will NOT churn"

    return result


# run the app
app.run(host="0.0.0.0", port=8000, debug=True)


