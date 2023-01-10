package com.demo.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.project1.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
