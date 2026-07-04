-- 1. Check current VIP status
SELECT customer_id, first_name, balance, is_vip 
FROM customers;

-- 2. Reset VIP status (so we can test again)
UPDATE customers 
SET is_vip = 'N';

COMMIT;

-- 3. Run Scenario 2 again after reset
SET SERVEROUTPUT ON;

DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, balance
        FROM customers
        WHERE balance > 10000 
          AND (is_vip = 'N' OR is_vip IS NULL);
BEGIN
    FOR cust IN customer_cursor LOOP
        UPDATE customers
        SET is_vip = 'Y'
        WHERE customer_id = cust.customer_id;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID ' || cust.customer_id || 
                           ' promoted to VIP (Balance: $' || cust.balance || ')');
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP promotion process completed.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/