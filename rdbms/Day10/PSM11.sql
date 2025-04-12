-- Write a procedure to check if the given number is prime or not
DROP PROCEDURE IF EXISTS sp_prime;
DELIMITER $$
CREATE PROCEDURE sp_prime(IN p_num INT)
BEGIN
    DECLARE i INT DEFAULT 2;
    DECLARE status CHAR(15);
    label_prime:LOOP
        IF p_num = i THEN
            SET status = "PRIME";
            LEAVE label_prime;
        END IF;

        IF p_num % i = 0 THEN
            SET status = "NOT PRIME";
            LEAVE label_prime;
        END IF;
        SET i = i + 1;
    END;
    SELECT p_num, status;
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM11.sql>
-- CALL sp_prime(6);