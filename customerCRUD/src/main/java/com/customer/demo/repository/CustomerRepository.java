package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}