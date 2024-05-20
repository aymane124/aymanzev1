package com.example.aymanze.dao.repositories;


import com.example.aymanze.dao.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    Pharmacy findPharmacyById(Long id);
    Pharmacy findPharmacyByEmail(String email);
}
