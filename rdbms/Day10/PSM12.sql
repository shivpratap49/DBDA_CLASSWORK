-- write a procedure where it will give the category of employee
-- for the given emp no. categories are
-- sal < 1500 -> POOR
-- sal 1500 to 2500 -> MIDDLE
-- sal > 2500 -> RICH
DROP PROCEDURE IF EXISTS sp_empcategory;
DELIMITER $$
CREATE PROCEDURE sp_empcategory(IN p_empno INT)
BEGIN
    DECLARE v_sal DECIMAL(8,2);
    DECLARE category VARCHAR(15);
    SELECT sal INTO v_sal FROM emp WHERE empno = p_empno;
    CASE
        WHEN v_sal < 1500 THEN
            SET category = "POOR";
        WHEN v_sal BETWEEN 1500 AND 2500 THEN
            SET category = "MIDDLE CLASS";
        ELSE
            SET category = "RICH";
    END CASE;
    SELECT CONCAT("The employee belongs to category - ",category) AS msg;
END;
$$
DELIMITER ;

-- SOURCE <path to the PSM12.sql>
-- CALL sp_empcategory(7369);