package com.example.aymanze.metier.manager;


import com.example.aymanze.dao.entities.Customer;

public interface CustomerManager {
    public void addCustomer(Customer customer);
    public void removeCustomer(Customer customer);

    public Customer findCustomerById(Long id);
}
