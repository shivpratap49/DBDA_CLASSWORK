-- Calculate area of a circle and add the result in the result table.
-- id -> radius
-- val -> Area of circle = ..

DROP PROCEDURE IF EXISTS sp_circlearea2;
DELIMITER $$
CREATE PROCEDURE sp_circlearea2()
BEGIN
    DECLARE radius INT DEFAULT 8;
    DECLARE area DOUBLE;
    DECLARE msg VARCHAR(50);
    SET area = radius * radius * 3.14;
    -- SET msg = CONCAT("Area of Circle = ",area);
    SELECT CONCAT("Area of Circle = ",area) INTO msg;
    INSERT INTO result VALUES(radius,msg); 
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM04.sql>
-- CALL sp_circlearea2();
-- SELECT * FROM result;