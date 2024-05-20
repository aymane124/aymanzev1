package com.example.aymanze.metier.manager;


import com.example.aymanze.dao.entities.Pharmacy;

public interface PharmacyManager {
    public void addPharmacy(Pharmacy pharmacy);
    public void removePharmacy(Pharmacy pharmacy);
    public void removePharmacy(long id);
    public Pharmacy findPharmacyById(Long id);

    public boolean authenticate(String email, String password);
}
