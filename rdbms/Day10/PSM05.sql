-- Calculate area of rectangle where 
-- user will pass length and breadth through parameters

DROP PROCEDURE IF EXISTS sp_rectanglearea;
DELIMITER $$
CREATE PROCEDURE sp_rectanglearea(IN p_length INT,IN p_breadth INT)
BEGIN
    DECLARE area DOUBLE;
    DECLARE msg VARCHAR (50);
    SET area = p_length*p_breadth;
    SELECT p_length,p_breadth,area;
    SELECT CONCAT(p_length,',',p_breadth) INTO msg;
    INSERT INTO result VALUES(area,msg);
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM05.sql>
-- CALL sp_rectanglearea(5,3);