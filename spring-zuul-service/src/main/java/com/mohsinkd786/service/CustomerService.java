package com.mohsinkd786.service;

import com.mohsinkd786.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean createCustomer(Customer customer){
        customers.add(customer);
        return true;
    }
}
