-- Write a procedure to check if the given number is even or odd
DROP PROCEDURE IF EXISTS sp_evenodd;
DELIMITER $$
CREATE PROCEDURE sp_evenodd(IN p_num INT)
BEGIN
    IF p_num % 2 = 0 THEN
        SELECT "Given Number is Even" AS msg;
        INSERT INTO result VALUES(p_num,"IS EVEN");
    ELSE
        SELECT "Given Number is ODD" AS msg;
        INSERT INTO result VALUES(p_num,"IS ODD");
    END IF;
END;
$$
DELIMITER ;


-- SOURCE <path to the PSM08.sql>
-- CALL sp_evenodd(5);