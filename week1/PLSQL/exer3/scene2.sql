CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id    IN NUMBER,
    p_bonus_percentage IN NUMBER
) AS
    v_updated_count NUMBER;
BEGIN
    UPDATE employees
    SET salary = salary * (1 + p_bonus_percentage / 100)
    WHERE department_id = p_department_id;
    
    v_updated_count := SQL%ROWCOUNT;
    
    DBMS_OUTPUT.PUT_LINE(v_updated_count || ' employee(s) in Department ' || 
                         p_department_id || ' received ' || p_bonus_percentage || '% bonus.');
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
SET SERVEROUTPUT ON;
EXEC UpdateEmployeeBonus(10, 10);