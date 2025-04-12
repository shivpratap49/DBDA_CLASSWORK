
1

+------------------+------------+
| department_name  | first_name |
+------------------+------------+
| Administration   | Jennifer   |
| Marketing        | Michael    |
| Purchasing       | Den        |
| Human Resources  | Susan      |
| Shipping         | Adam       |
| IT               | Alexander  |
| Public Relations | Hermann    |
| Sales            | John       |
| Executive        | Steven     |
| Finance          | Nancy      |
| Accounting       | Shelley    |
+------------------+------------+
11 rows in set (0.00 sec)

2.

+------------------+--------------+---------------------+
| department_name  | manager_name | city                |
+------------------+--------------+---------------------+
| Administration   |            0 | Seattle             |
| Marketing        |            0 | Toronto             |
| Purchasing       |            0 | Seattle             |
| Human Resources  |            0 | London              |
| Shipping         |            0 | South San Francisco |
| IT               |            0 | Southlake           |
| Public Relations |            0 | Munich              |
| Sales            |            0 | OX9 9ZB             |
| Executive        |            0 | Seattle             |
| Finance          |            0 | Seattle             |
| Accounting       |            0 | Seattle             |
+------------------+--------------+---------------------+
11 rows in set, 24 warnings (0.11 sec)



3.

+--------------------------+---------------------+----------------------+
| country_name             | city                | department_name      |
+--------------------------+---------------------+----------------------+
| United States of America | Seattle             | Administration       |
| Canada                   | Toronto             | Marketing            |
| United States of America | Seattle             | Purchasing           |
| United Kingdom           | London              | Human Resources      |
| United States of America | South San Francisco | Shipping             |
| United States of America | Southlake           | IT                   |
| Germany                  | Munich              | Public Relations     |
| United States of America | Seattle             | Executive            |
| United States of America | Seattle             | Finance              |
| United States of America | Seattle             | Accounting           |
| United States of America | Seattle             | Treasury             |
| United States of America | Seattle             | Corporate Tax        |
| United States of America | Seattle             | Control And Credit   |
| United States of America | Seattle             | Shareholder Services |
| United States of America | Seattle             | Benefits             |
| United States of America | Seattle             | Manufacturing        |
| United States of America | Seattle             | Construction         |
| United States of America | Seattle             | Contracting          |
| United States of America | Seattle             | Operations           |
| United States of America | Seattle             | IT Support           |
| United States of America | Seattle             | NOC                  |
| United States of America | Seattle             | IT Helpdesk          |
| United States of America | Seattle             | Government Sales     |
| United States of America | Seattle             | Retail Sales         |
| United States of America | Seattle             | Recruiting           |
| United States of America | Seattle             | Payroll              |
+--------------------------+---------------------+----------------------+
26 rows in set (0.00 sec)






4
+--------------------------+-----------------+-----------+------------+
| job_title                | department_name | last_name | start_date |
+--------------------------+-----------------+-----------+------------+
| Programmer               | IT              | De Haan   | 1993-01-13 |
| Accounting Manager       | Accounting      | Kochhar   | 1993-10-28 |
| Marketing Representative | Marketing       | Hartstein | 1996-02-17 |
| Stock Clerk              | Shipping        | Raphaely  | 1998-03-24 |
| Sales Representative     | Sales           | Taylor    | 1998-03-24 |
| Public Accountant        | Executive       | Whalen    | 1994-07-01 |
+--------------------------+-----------------+-----------+------------+





5.

+---------------------------------+----------------+
| job_title                       | average_salary |
+---------------------------------+----------------+
| President                       |   24000.000000 |
| Administration Vice President   |   17000.000000 |
| Programmer                      |    5760.000000 |
| Finance Manager                 |   12000.000000 |
| Accountant                      |    7920.000000 |
| Purchasing Manager              |   11000.000000 |
| Purchasing Clerk                |    2780.000000 |
| Stock Manager                   |    7280.000000 |
| Stock Clerk                     |    2785.000000 |
| Sales Manager                   |   12200.000000 |
| Sales Representative            |    8350.000000 |
| Shipping Clerk                  |    3215.000000 |
| Administration Assistant        |    4400.000000 |
| Marketing Manager               |   13000.000000 |
| Marketing Representative        |    6000.000000 |
| Human Resources Representative  |    6500.000000 |
| Public Relations Representative |   10000.000000 |
| Accounting Manager              |   12000.000000 |
| Public Accountant               |    8300.000000 |
+---------------------------------+----------------+
19 rows in set (0.12 sec)



6.

+---------------------------------+---------------+-------------------+
| job_title                       | employee_name | salary_difference |
+---------------------------------+---------------+-------------------+
| Public Accountant               |             0 |              0.00 |
| Accounting Manager              |             0 |              0.00 |
| Administration Assistant        |             0 |              0.00 |
| President                       |             0 |              0.00 |
| Administration Vice President   |             0 |              0.00 |
| Administration Vice President   |             0 |              0.00 |
| Accountant                      |             0 |              0.00 |
| Accountant                      |             0 |            800.00 |
| Accountant                      |             0 |           1300.00 |
| Accountant                      |             0 |           1200.00 |
| Accountant                      |             0 |           2100.00 |
| Finance Manager                 |             0 |              0.00 |
| Human Resources Representative  |             0 |              0.00 |
| Programmer                      |             0 |              0.00 |
| Programmer                      |             0 |           3000.00 |
| Programmer                      |             0 |           4200.00 |
| Programmer                      |             0 |           4200.00 |
| Programmer                      |             0 |           4800.00 |
| Marketing Manager               |             0 |              0.00 |
| Marketing Representative        |             0 |              0.00 |
| Public Relations Representative |             0 |              0.00 |
| Purchasing Clerk                |             0 |              0.00 |
| Purchasing Clerk                |             0 |            200.00 |
| Purchasing Clerk                |             0 |            300.00 |
| Purchasing Clerk                |             0 |            500.00 |
| Purchasing Clerk                |             0 |            600.00 |
| Purchasing Manager              |             0 |              0.00 |
| Sales Manager                   |             0 |              0.00 |
| Sales Manager                   |             0 |            500.00 |
| Sales Manager                   |             0 |           2000.00 |
| Sales Manager                   |             0 |           3000.00 |
| Sales Manager                   |             0 |           3500.00 |
| Sales Representative            |             0 |           1500.00 |
| Sales Representative            |             0 |           2000.00 |
| Sales Representative            |             0 |           2500.00 |
| Sales Representative            |             0 |           3500.00 |
| Sales Representative            |             0 |           4000.00 |
| Sales Representative            |             0 |           4500.00 |
| Sales Representative            |             0 |           1500.00 |
| Sales Representative            |             0 |           2000.00 |
| Sales Representative            |             0 |           2500.00 |
| Sales Representative            |             0 |           3500.00 |
| Sales Representative            |             0 |           4000.00 |
| Sales Representative            |             0 |           4500.00 |
| Sales Representative            |             0 |           1000.00 |
| Sales Representative            |             0 |           2000.00 |
| Sales Representative            |             0 |           4300.00 |
| Sales Representative            |             0 |           4700.00 |
| Sales Representative            |             0 |           5100.00 |
| Sales Representative            |             0 |           5300.00 |
| Sales Representative            |             0 |              0.00 |
| Sales Representative            |             0 |           1500.00 |
| Sales Representative            |             0 |           1900.00 |
| Sales Representative            |             0 |           4100.00 |
| Sales Representative            |             0 |           4200.00 |
| Sales Representative            |             0 |           5400.00 |
| Sales Representative            |             0 |            500.00 |
| Sales Representative            |             0 |           2700.00 |
| Sales Representative            |             0 |           2900.00 |
| Sales Representative            |             0 |           3100.00 |
| Sales Representative            |             0 |           4500.00 |
| Sales Representative            |             0 |           5300.00 |
| Shipping Clerk                  |             0 |           1000.00 |
| Shipping Clerk                  |             0 |           1100.00 |
| Shipping Clerk                  |             0 |           1700.00 |
| Shipping Clerk                  |             0 |           1400.00 |
| Shipping Clerk                  |             0 |              0.00 |
| Shipping Clerk                  |             0 |            100.00 |
| Shipping Clerk                  |             0 |            800.00 |
| Shipping Clerk                  |             0 |           1200.00 |
| Shipping Clerk                  |             0 |            400.00 |
| Shipping Clerk                  |             0 |            600.00 |
| Shipping Clerk                  |             0 |           1300.00 |
| Shipping Clerk                  |             0 |           1700.00 |
| Shipping Clerk                  |             0 |            200.00 |
| Shipping Clerk                  |             0 |            300.00 |
| Shipping Clerk                  |             0 |           1000.00 |
| Shipping Clerk                  |             0 |           1400.00 |
| Shipping Clerk                  |             0 |           1100.00 |
| Shipping Clerk                  |             0 |           1200.00 |
| Shipping Clerk                  |             0 |           1600.00 |
| Shipping Clerk                  |             0 |           1600.00 |
| Stock Clerk                     |             0 |            400.00 |
| Stock Clerk                     |             0 |            900.00 |
| Stock Clerk                     |             0 |           1200.00 |
| Stock Clerk                     |             0 |           1400.00 |
| Stock Clerk                     |             0 |            300.00 |
| Stock Clerk                     |             0 |            800.00 |
| Stock Clerk                     |             0 |           1100.00 |
| Stock Clerk                     |             0 |           1500.00 |
| Stock Clerk                     |             0 |            300.00 |
| Stock Clerk                     |             0 |            700.00 |
| Stock Clerk                     |             0 |           1200.00 |
| Stock Clerk                     |             0 |           1400.00 |
| Stock Clerk                     |             0 |              0.00 |
| Stock Clerk                     |             0 |            400.00 |
| Stock Clerk                     |             0 |            900.00 |
| Stock Clerk                     |             0 |           1100.00 |
| Stock Clerk                     |             0 |            100.00 |
| Stock Clerk                     |             0 |            500.00 |
| Stock Clerk                     |             0 |           1000.00 |
| Stock Clerk                     |             0 |           1100.00 |
| Stock Manager                   |             0 |            200.00 |
| Stock Manager                   |             0 |              0.00 |
| Stock Manager                   |             0 |            300.00 |
| Stock Manager                   |             0 |           1700.00 |
| Stock Manager                   |             0 |           2400.00 |
+---------------------------------+---------------+-------------------+
107 rows in set, 214 warnings (0.00 sec)



7.

Empty set (0.00 sec)

8.

+-------------------------------+---------------+----------+
| job_title                     | employee_name | salary   |
+-------------------------------+---------------+----------+
| President                     |             0 | 24000.00 |
| Administration Vice President |             0 | 17000.00 |
| Administration Vice President |             0 | 17000.00 |
+-------------------------------+---------------+----------+
3 rows in set, 8 warnings (0.00 sec)






9.
+-----------------+-----------------+---------+
| department_name | Name            | salary  |
+-----------------+-----------------+---------+
| Administration  | Jennifer Whalen | 4400.00 |
+-----------------+-----------------+---------+




10.

Empty set, 2 warnings (0.00 sec)




11.
11)

Empty set (0.00 sec)




12.
+-------------------+--------------------------+
| Name              | country_name             |
+-------------------+--------------------------+
| Jennifer Whalen   | United States of America |
| Michael Hartstein | Canada                   |
| Pat Fay           | Canada                   |
| Den Raphaely      | United States of America |
| Alexander Khoo    | United States of America |
| Shelli Baida      | United States of America |
| Sigal Tobias      | United States of America |
| Guy Himuro        | United States of America |
| Karen Colmenares  | United States of America |
| Susan Mavris      | United Kingdom           |
| Matthew Weiss     | United States of America |
| Adam Fripp        | United States of America |
| Payam Kaufling    | United States of America |
| Shanta Vollman    | United States of America |
| Kevin Mourgos     | United States of America |
| Julia Nayer       | United States of America |
| Irene Mikkilineni | United States of America |
| James Landry      | United States of America |
| Steven Markle     | United States of America |
| Laura Bissot      | United States of America |
| Mozhe Atkinson    | United States of America |
| James Marlow      | United States of America |
| TJ Olson          | United States of America |
| Jason Mallin      | United States of America |
| Michael Rogers    | United States of America |
| Ki Gee            | United States of America |
| Hazel Philtanker  | United States of America |
| Renske Ladwig     | United States of America |
| Stephen Stiles    | United States of America |
| John Seo          | United States of America |
| Joshua Patel      | United States of America |
| Trenna Rajs       | United States of America |
| Curtis Davies     | United States of America |
| Randall Matos     | United States of America |
| Peter Vargas      | United States of America |
| Winston Taylor    | United States of America |
| Jean Fleaur       | United States of America |
| Martha Sullivan   | United States of America |
| Girard Geoni      | United States of America |
| Nandita Sarchand  | United States of America |
| Alexis Bull       | United States of America |
| Julia Dellinger   | United States of America |
| Anthony Cabrio    | United States of America |
| Kelly Chung       | United States of America |
| Jennifer Dilly    | United States of America |
| Timothy Gates     | United States of America |
| Randall Perkins   | United States of America |
| Sarah Bell        | United States of America |
| Britney Everett   | United States of America |
| Samuel McCain     | United States of America |
| Vance Jones       | United States of America |
| Alana Walsh       | United States of America |
| Kevin Feeney      | United States of America |
| Donald OConnell   | United States of America |
| Douglas Grant     | United States of America |
| Alexander Hunold  | United States of America |
| Bruce Ernst       | United States of America |
| David Austin      | United States of America |
| Valli Pataballa   | United States of America |
| Diana Lorentz     | United States of America |
| Hermann Baer      | Germany                  |
| Steven King       | United States of America |
| Neena Kochhar     | United States of America |
| Lex De Haan       | United States of America |
| Nancy Greenberg   | United States of America |
| Daniel Faviet     | United States of America |
| John Chen         | United States of America |
| Ismael Sciarra    | United States of America |
| Jose Manuel Urman | United States of America |
| Luis Popp         | United States of America |
| Shelley Higgins   | United States of America |
| William Gietz     | United States of America |
+-------------------+--------------------------+
72 rows in set (0.00 sec)





13.

+------------------+----------------+-------------------------------+
| department_name  | average_salary | num_employees_with_commission |
+------------------+----------------+-------------------------------+
| Executive        |   19333.333333 |                             3 |
| IT               |    5760.000000 |                             5 |
| Finance          |    8600.000000 |                             6 |
| Purchasing       |    4150.000000 |                             6 |
| Shipping         |    3475.555556 |                            45 |
| Sales            |    8955.882353 |                            34 |
| Administration   |    4400.000000 |                             1 |
| Marketing        |    9500.000000 |                             2 |
| Human Resources  |    6500.000000 |                             1 |
| Public Relations |   10000.000000 |                             1 |
| Accounting       |   10150.000000 |                             2 |
+------------------+----------------+-------------------------------+
11 rows in set (0.00 sec)



14.


Empty set (0.00 sec)






15.


Empty set (0.00 sec)






