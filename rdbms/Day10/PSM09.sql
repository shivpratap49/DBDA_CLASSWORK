-- Write a procedure to sum all the even numbers in the given range
DROP PROCEDURE IF EXISTS sp_evensum;
DELIMITER $$
CREATE PROCEDURE sp_evensum(IN p_low INT,IN p_high INT)
BEGIN
    DECLARE num INT;
    DECLARE sum INT DEFAULT 0;
    SET num = p_low;
    WHILE num <= p_high DO
        IF num % 2 = 0 THEN
            SET sum = sum + num;
        END IF;
        SET num = num + 1;
    END WHILE;
    SELECT p_low, p_high, sum;
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM09.sql>
-- CALL sp_evensum(1,10);