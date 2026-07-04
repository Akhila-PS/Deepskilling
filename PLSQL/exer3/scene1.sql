CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01  -- 1% monthly interest
    WHERE account_type = 'SAVINGS';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully for all savings accounts.');
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
SET SERVEROUTPUT ON;
EXEC ProcessMonthlyInterest;