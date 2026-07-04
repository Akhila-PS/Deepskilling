public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor injection - dependency is provided, not created here
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomer(String id) {
        System.out.println(customerRepository.findCustomerById(id));
    }
}