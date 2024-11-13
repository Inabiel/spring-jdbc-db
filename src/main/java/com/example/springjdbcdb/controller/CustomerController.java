package com.example.springjdbcdb.controller;

import com.example.springjdbcdb.dto.CustomerDTO;
import com.example.springjdbcdb.model.Customer;
import com.example.springjdbcdb.repository.CustomerRepository;
import com.example.springjdbcdb.util.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    @ResponseBody
    public ResponseEntity<Object> getCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return Response.generateResponse("succeeded getting users", HttpStatus.OK, customers);
    }

    @PostMapping("/customers")
    @Validated
    public Customer createCustomer(@RequestBody @Valid CustomerDTO customerRequest) {
        Customer customer = new Customer(customerRequest.getFirstName(), customerRequest.getLastName());

        return customerRepository.save(customer);
    }
}
