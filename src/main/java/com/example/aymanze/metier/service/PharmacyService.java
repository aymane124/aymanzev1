package com.example.aymanze.metier.service;

import com.example.aymanze.dao.entities.Pharmacy;
import com.example.aymanze.dao.repositories.PharmacyRepository;
import com.example.aymanze.metier.manager.PharmacyManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements PharmacyManager {
    private PharmacyRepository pharmacyRepository;
    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public void addPharmacy(Pharmacy pharmacy) {
        pharmacyRepository.save(pharmacy);
    }

    @Override
    public void removePharmacy(Pharmacy pharmacy) {
        pharmacyRepository.delete(pharmacy);
    }

    @Override
    public void removePharmacy(long id) {
        pharmacyRepository.deleteById(id);
    }

    @Override
    public Pharmacy findPharmacyById(Long id) {
        return pharmacyRepository.findById(id).orElse(null);
    }

    public boolean authenticate(String email, String password) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByEmail(email);
        return pharmacy != null && pharmacy.getPassword().equals(password);
    }
}

