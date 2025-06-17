package codegym.vn.customerlist.service;

import codegym.vn.customerlist.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
}
