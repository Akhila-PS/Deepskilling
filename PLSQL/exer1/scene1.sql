SET SERVEROUTPUT ON;
DECLARE
    CURSOR customer_cursor IS
        SELECT c.customer_id, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
    
    v_new_rate NUMBER;
BEGIN
    FOR cust IN customer_cursor LOOP
        v_new_rate := cust.interest_rate * 0.99;  -- 1% discount
        
        UPDATE loans
        SET interest_rate = v_new_rate
        WHERE loan_id = cust.loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Discount applied to Loan ID: ' || cust.loan_id || 
                           ' | New Rate: ' || v_new_rate || '%');
    END LOOP;
    
    COMMIT;  -- Commit changes
    DBMS_OUTPUT.PUT_LINE('Interest rate discount process completed.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/