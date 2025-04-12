DROP TRIGGER IF EXISTS update_balance;
DELIMITER $$
CREATE TRIGGER update_balance
BEFORE INSERT on transactions
FOR EACH ROW
BEGIN
    DECLARE curr_bal DOUBLE;

    IF NEW.tx_type = 'Deposit' THEN
        UPDATE accounts SET balance = balance + NEW.amount WHERE accno = NEW.accno;
        SET NEW.status = 'Success';
    ELSE
        SELECT balance INTO curr_bal FROM accounts WHERE accno = NEW.accno;
        IF curr_bal > NEW.amount THEN
            UPDATE accounts SET balance = balance - NEW.amount WHERE accno = NEW.accno;
            SET NEW.status = 'SUCCESS';
        ELSE
            SET NEW.status = 'FAILED';
        END IF;
    END IF;
END;
$$
DELIMITER ;