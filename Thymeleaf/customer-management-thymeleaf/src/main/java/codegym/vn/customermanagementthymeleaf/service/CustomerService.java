package codegym.vn.customermanagementthymeleaf.service;

import codegym.vn.customermanagementthymeleaf.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Nguyễn An Dương", "anduong@example.com", "Hà Nội"));
        customers.put(2, new Customer(2, "Trần Bảo Ngọc", "bangoctran@example.com", "Hồ Chí Minh"));
        customers.put(3, new Customer(3, "Lê Minh Tân", "mintan@example.com", "Đà Nẵng"));
        customers.put(4, new Customer(4, "Phạm Lan Anh", "lananhpham@example.com", "Cần Thơ"));
        customers.put(5, new Customer(5, "Hoàng Thiên Kim", "thienkimhoang@example.com", "Bắc Ninh"));
        customers.put(6, new Customer(6, "Vũ Ngọc Mai", "ngocmai@example.com", "Hải Phòng"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
