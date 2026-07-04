SET SERVEROUTPUT ON;
DECLARE
    CURSOR due_loans_cursor IS
        SELECT c.first_name || ' ' || c.last_name AS customer_name,
               l.loan_id,
               l.due_date,
               l.amount
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.due_date;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== Loan Due Reminders ===');
    DBMS_OUTPUT.PUT_LINE('Date: ' || TO_CHAR(SYSDATE, 'DD-MON-YYYY'));
    DBMS_OUTPUT.PUT_LINE('-------------------------');
    
    FOR loan_rec IN due_loans_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.loan_id ||
                           ' for ' || loan_rec.customer_name ||
                           ' is due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY') ||
                           ' | Amount: $' || loan_rec.amount);
    END LOOP;
    
    IF due_loans_cursor%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('Reminder generation completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/