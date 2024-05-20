package com.example.aymanze.web;

import com.example.aymanze.dao.entities.Customer;
import com.example.aymanze.dao.entities.Pharmacy;
import com.example.aymanze.dao.entities.Produit;
import com.example.aymanze.dao.repositories.CustomerRepository;
import com.example.aymanze.dao.repositories.PharmacyRepository;
import com.example.aymanze.dao.repositories.ProduitRepository;
import com.example.aymanze.metier.manager.CustomerManager;
import com.example.aymanze.metier.manager.PharmacyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private CustomerRepository  customerRepository;
    @Autowired
    private PharmacyManager pharmacyManager;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @GetMapping("/dashboardpharmacy")
    public String showPharmacy(Model model) {

        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        model.addAttribute("listpharmacy", pharmacies);
        return "dashboardpharmacy";
    }

    @GetMapping("/deletePharmacy")
    public String deletePharmacy(@RequestParam(name = "id") Long id) {
        pharmacyRepository.deleteById(id);
        return "redirect:/dashboardpharmacy";
    }

    @GetMapping("/updatePharmacy")
    public String updatePharmacy(Model model, @RequestParam(name = "id") Long id) {
        Pharmacy pharmacy = pharmacyManager.findPharmacyById(id);

            model.addAttribute("xx",pharmacy);
            return "updatepharmacy";

    }

    @PostMapping("/updateph")
    public String update(@ModelAttribute("p")Pharmacy p) {
        pharmacyManager.addPharmacy(p);
        return "redirect:/dashboardpharmacy";
    }

    @GetMapping("/dashboardproduit")
    public String showProduits(Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("listproduit", produits);
        return "dashboardproduct";
    }

    @GetMapping("/dashboardcustomer")
    public String showcustomer(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("listcustomer", customers);
        return "dashboardcustomer";
    }
    @GetMapping("/deletecustomer")
    public String deletecustomer(@RequestParam(name = "id") Long id) {
        customerRepository.deleteById(id);
        return "redirect:/dashboardcustomer";
    }

    @GetMapping("/updatecustomer")
    public String updatecustomer(Model model, @RequestParam(name = "id") Long id) {
        Customer customer = customerManager.findCustomerById(id);
        model.addAttribute("customers", customer);
        return "updatecustomer";
    }
    @PostMapping("/updatecs")
    public String update(Customer p) {
        customerManager.addCustomer(p);
        return "redirect:/dashboardcustomer";
    }



}
