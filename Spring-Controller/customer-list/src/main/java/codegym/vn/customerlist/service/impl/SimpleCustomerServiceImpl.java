package codegym.vn.customerlist.service.impl;

import codegym.vn.customerlist.model.Customer;
import codegym.vn.customerlist.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;

public class SimpleCustomerServiceImpl implements ICustomerService {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1L, "John Doe", "john@example.com", "New York"));
        customers.add(new Customer(2L, "Jane Smith", "jane@example.com", "California"));
        customers.add(new Customer(3L, "Bob Johnson", "bob@example.com", "Texas"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void save(Customer customer) {
        Customer c = findById(customer.getId());
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setAddress(customer.getAddress());
    }
}
