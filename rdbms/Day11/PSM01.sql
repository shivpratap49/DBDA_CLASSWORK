DROP TRIGGER IF EXISTS update_balance;
DELIMITER $$
CREATE TRIGGER update_balance
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    IF NEW.tx_type = 'Deposit' THEN
        UPDATE accounts SET balance = balance + NEW.amount WHERE accno = NEW.accno;
    ELSE
        UPDATE accounts SET balance = balance - NEW.amount WHERE accno = NEW.accno;
    END IF;

END;
$$
DELIMITER ;