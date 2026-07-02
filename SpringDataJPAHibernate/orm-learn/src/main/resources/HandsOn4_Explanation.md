# Hands-On 4: Difference between JPA, Hibernate and Spring Data JPA

## 1. JPA (Java Persistence API)
- It is a **specification** (standard) defined by JSR 338.
- It defines rules and interfaces for persisting, reading, and managing Java objects in a database.
- It does **not** provide any concrete implementation.
- Example: Like a rule book or standard.

## 2. Hibernate
- It is one of the most popular **implementations** of JPA.
- It provides the actual code (ORM Tool) to map Java objects to database tables.
- It has many extra features beyond the JPA specification.
- Requires more boilerplate code.

## 3. Spring Data JPA
- It is **not** a JPA implementation.
- It provides a high-level **abstraction layer** on top of JPA providers (like Hibernate).
- It significantly reduces boilerplate code.
- Automatically manages transactions using `@Transactional`.
- You only need to create a Repository interface — most CRUD operations are ready to use.

## Code Comparison

**Hibernate (Traditional way - More Code):**
```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;
   
   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
```

**Spring Data JPA (Modern way - Very Less Code):**
```java
// Repository Interface
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

// Service Class
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);   // Simple one line
    }
}
```

## Conclusion
- **JPA** = Specification (Rules)  
- **Hibernate** = Implementation of JPA (Actual ORM Tool)  
- **Spring Data JPA** = Abstraction Layer (Makes development fast and easy)

## Practical Implementation Done
- Added `findCountryByCode(String code)` method in `CountryService.java`
- Added `testGetCountryByCode()` method in `OrmLearnApplication.java`