-- Calculate square of a  given number. 
-- return the result through Out parameter

DROP PROCEDURE IF EXISTS sp_square;
DELIMITER $$
CREATE PROCEDURE sp_square(IN p_no INT, OUT p_res INT)
BEGIN
   SET p_res = p_no * p_no;
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM06.sql>
-- SELECT @res;
-- CALL sp_square(5,@res);
-- SELECT @res;