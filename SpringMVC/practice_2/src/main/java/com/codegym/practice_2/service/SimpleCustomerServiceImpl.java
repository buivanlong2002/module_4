package com.codegym.practice_2.service;



import com.codegym.practice_2.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SimpleCustomerServiceImpl implements CustomerService {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "John Doe", "john@example.com", "New York"));
        customers.add(new Customer(2, "Jane Smith", "jane@example.com", "California"));
        customers.add(new Customer(3, "Bob Johnson", "bob@example.com", "Texas"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
