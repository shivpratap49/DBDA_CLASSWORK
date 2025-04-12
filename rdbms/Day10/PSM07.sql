-- Calculate square of a  given number. 
-- pass the number through INOUT parameter and 
-- return the result through same INOUT parameter

DROP PROCEDURE IF EXISTS sp_square2;
DELIMITER $$
CREATE PROCEDURE sp_square2(INOUT p_val INT)
BEGIN
   SET p_val = p_val * p_val;
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM07.sql>
-- SELECT @res;
-- SET @res = 8;
-- CALL sp_square2(@res);
-- SELECT @res;