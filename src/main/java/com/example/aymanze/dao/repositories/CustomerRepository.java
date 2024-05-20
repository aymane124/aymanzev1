package com.example.aymanze.dao.repositories;


import com.example.aymanze.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
