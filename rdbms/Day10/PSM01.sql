DROP PROCEDURE IF EXISTS sp_hello;
DELIMITER $$
CREATE PROCEDURE sp_hello()
BEGIN
    SELECT "HELLO WORLD FROM DBDA" AS msg;
END;
$$
DELIMITER ;

-- to add the procedure in mysql
-- SOURCE <path to the PSM.sql>
-- to call the stored procedure
-- CALL sp_hello()