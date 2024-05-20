package com.example.aymanze.metier.service;

import com.example.aymanze.dao.entities.Produit;
import com.example.aymanze.dao.repositories.ProduitRepository;
import com.example.aymanze.metier.manager.ProduitManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements ProduitManager {
    private ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void removeProduit(Produit produit) {
        produitRepository.delete(produit);
    }

    @Override
    public void removeProduit(long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit findProduitById(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }


}
