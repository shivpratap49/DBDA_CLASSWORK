import pickle


def show_menu_and_get_input_from_user():
    print("-- Welcome to Salary Prediction --")
    print("1. predict salary")
    print("2. exit")
    return input("Enter your choice: ")


# load the model
with open("salary_prediction_model.pkl", "rb") as file:
    # the model (formula) will be available for prediction
    model = pickle.load(file)

while True:
    choice = show_menu_and_get_input_from_user()
    if choice == '1':
        # get input from user
        experience = float(input("Enter your experience in years: "))

        # predict the salary
        salaries = model.predict([[experience]])
        print("-" * 80)
        print(f"With {experience}yrs experience, you may get ${salaries[0]:0.2f}")
        print("-" * 80)
        print("\n")
    else:
        print("Bye bye")
        break
