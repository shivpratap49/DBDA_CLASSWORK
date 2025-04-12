-- Write a procedure to insert Hello world in the result table

DROP PROCEDURE IF EXISTS sp_hello2;
DELIMITER $$
CREATE PROCEDURE sp_hello2()
BEGIN
    INSERT INTO result VALUES(1, "Hello World");
END;
$$
DELIMITER ;
-- SOURCE <path to the PSM02.sql>
-- CALL sp_hello2();