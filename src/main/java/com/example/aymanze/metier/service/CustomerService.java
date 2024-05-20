package com.example.aymanze.metier.service;

import com.example.aymanze.dao.entities.Customer;
import com.example.aymanze.dao.repositories.CustomerRepository;
import com.example.aymanze.metier.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerManager {
    @Autowired

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        try {
            customerRepository.delete(customer);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public Customer findCustomerById(Long id) {
        try {
            return customerRepository.findById(id).orElse(null);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

}

