-- Stored Procedure

-- 1.Write a procedure to display Hello World 

-- 2.Write a procedure to insert Hello world in the result table
CREATE TABLE result(
    id INT,
    val VARCHAR(100)
);

-- 3. Calculate area of a circle.

-- to check for all procedures from the database
SHOW PROCEDURE STATUS WHERE db LIKE 'classwork_db';

-- 4. Calculate area of a circle and add the result in the result table
-- id -> radius
-- val -> Area of circle = ..

-- 5. Calculate area of rectangle where 
-- user will pass length and breadth through parameters

-- 6. Calculate square of a  given number. 
-- return the result through Out parameter

-- 7. Calculate square of a  given number. 
-- pass the number through INOUT parameter and 
-- return the result through same INOUT parameter

-- 8. Write a procedure to check if the given number is even or odd

-- 9. Write a procedure to sum all the even numbers in the given range

-- 10. Write a procedure to insert table of given number in result table

-- 11. Write a procedure to check if the given number is prime or not

-- 12. write a procedure where it will give the category of employee
-- for the given emp no.
-- sal < 1500 -> POOR
-- sal 1500 to 2500 -> MIDDLE
-- sal > 2500 -> RICH