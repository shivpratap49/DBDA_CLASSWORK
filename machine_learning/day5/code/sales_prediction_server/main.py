from flask import Flask, request, render_template
import pickle

app = Flask(__name__)

# load the model
with open("sales_prediction_model.pkl", "rb") as file:
    model = pickle.load(file)


@app.route("/", methods=["GET"])
def root():
    return render_template("index.html")


@app.route("/predict", methods=["POST"])
def predict_sales():
    tv = float(request.form.get("tv"))
    radio = float(request.form.get("radio"))
    sales = model.predict([[tv, radio]])
    return f"Your sales prediction = ${sales[0]}"


app.run(host="0.0.0.0", port=8000, debug=True)