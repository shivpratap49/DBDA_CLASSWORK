# one-to-many relationship
# - a company has many employees

class Employee:
    def __init__(self, employee_id, name, address, salary):
        self.__employee_id = employee_id
        self.__name = name
        self.__address = address
        self.__salary = salary

    def print_employee_details(self):
        print(f"employee id = {self.__employee_id}")
        print(f"name = {self.__name}")
        print(f"address = {self.__address}")
        print(f"salary = {self.__salary}")
        print('-' * 80)


class Company:
    def __init__(self, name, address):
        self.__name = name
        self.__address = address

        # hold all employees
        self.__employees = []

    def recruit(self, name, address, salary):
        # generate new employee id
        employee_id = len(self.__employees) + 1

        # create an object Employee
        employee = Employee(employee_id, name, address, salary)

        # append the employee to the collection
        self.__employees.append(employee)

    def print_company_info(self):
        print(f"name = {self.__name}")
        print(f"address = {self.__address}")
        print(f"--- employee list --")
        for employee in self.__employees:
            employee.print_employee_details()


c1 = Company("Sunbeam", "pune")
c1.recruit("Amit", "pune", 1000)
c1.recruit("Vishal", "pune", 2000)
c1.recruit("manisha", "pune", 3000)

c1.print_company_info()
