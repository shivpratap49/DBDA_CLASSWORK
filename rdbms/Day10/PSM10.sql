-- Write a procedure to insert table of given number in result table
-- 2 , 2 * 1
-- 4 , 2 * 2
DROP PROCEDURE IF EXISTS sp_table;
DELIMITER  $$
CREATE PROCEDURE sp_table(IN p_num INT)
BEGIN
DECLARE i INT DEFAULT 1;
TRUNCATE TABLE result;
-- WHILE i <= 10 DO
--     INSERT INTO result VALUES (p_num * i, CONCAT(p_num,' * ',i));
--     SET i = i + 1;
-- END WHILE;

REPEAT 
    INSERT INTO result VALUES (p_num * i, CONCAT(p_num,' * ',i));
    SET i = i + 1;
UNTIL i > 10
END REPEAT;
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM10.sql>
-- CALL sp_table(2);