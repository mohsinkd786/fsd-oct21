package com.mohsinkd786.controller;


import com.mohsinkd786.dto.Customer;
import com.mohsinkd786.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private Logger logger= LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service){
        this.customerService = service;
    }

    @GetMapping
    public List<Customer> findCustomers(@RequestHeader String message){
        logger.info("------------ "+message);
        return customerService.getCustomers();
    }

    @PostMapping
    public ResponseEntity<Boolean> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }
}
