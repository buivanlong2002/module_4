package com.codegym.practice_2.service;



import com.codegym.practice_2.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}
