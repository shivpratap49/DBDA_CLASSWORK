-- Calculate area of a circle.
DROP PROCEDURE IF EXISTS sp_circlearea;
DELIMITER $$
CREATE PROCEDURE sp_circlearea()
BEGIN
    DECLARE radius INT DEFAULT 8;
    SELECT radius, radius*radius*3.14 AS area; 
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM03.sql>
-- CALL sp_circlearea();