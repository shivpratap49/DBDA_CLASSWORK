from flask import Flask, request, render_template
import pickle

with open("churn_model.pkl", "rb") as file:
    model = pickle.load(file)


app = Flask(__name__)


@app.route('/', methods=["GET"])
def root():
    return render_template('index.html')


@app.route('/predict', methods=["POST"])
def predict_churn_value():
    print(request.form)
    gender = int(request.form.get("gender"))
    age = int(request.form.get("age"))
    balance = float(request.form.get("balance"))
    is_active_member = int(request.form.get("is_active_member"))
    predictions = model.predict([[gender, age, balance, is_active_member]])
    return f"<h1>Prediction: {'Customer will exit' if predictions[0] == 1 else 'Customer will not exit'}</h1>"


app.run(host="0.0.0.0", port=8000, debug=True)