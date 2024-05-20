package com.example.aymanze.metier.manager;


import com.example.aymanze.dao.entities.Produit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProduitManager {
    public void addProduit(Produit produit);
    public void removeProduit(Produit produit);
    public void removeProduit(long id);
    public Produit findProduitById(Long id);

    public List<Produit> getAllProducts();
}
