package com.example.springjdbcdb.repository;

import com.example.springjdbcdb.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer,Integer> {
}
