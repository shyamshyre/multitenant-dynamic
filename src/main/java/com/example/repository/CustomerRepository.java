package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findById(Long id);

	Customer findByName(String name);

    void deleteByName(String name);
}