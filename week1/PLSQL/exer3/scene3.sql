CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check balance
    SELECT balance INTO v_balance
    FROM accounts 
    WHERE account_id = p_from_account;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;
    
    -- Deduct from source
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;
    
    -- Credit to destination
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;
    
    DBMS_OUTPUT.PUT_LINE('Transfer successful: $' || p_amount || 
                         ' from Account ' || p_from_account || 
                         ' to Account ' || p_to_account);
    
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One of the accounts does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

SET SERVEROUTPUT ON;
EXEC TransferFunds(101, 102, 5000);