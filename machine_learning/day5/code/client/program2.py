import pickle


def show_menu_and_get_input_from_user():
    print("-- Welcome to Sales Prediction --")
    print("1. predict sales")
    print("2. exit")
    return input("Enter your choice: ")


# load the model
with open("sales_prediction_model.pkl", "rb") as file:
    # the model (formula) will be available for prediction
    model = pickle.load(file)

while True:
    choice = show_menu_and_get_input_from_user()
    if choice == '1':
        # get input from user
        tv = float(input("Enter your TV advertisement budget: "))
        radio = float(input("Enter your radio advertisement budget: "))

        # predict the salary
        sales = model.predict([[tv, radio]])
        print("-" * 80)
        print(f"predicted sales = ${sales[0]}")
        print("-" * 80)
        print("\n")
    else:
        print("Bye bye")
        break
