package com.example.aymanze.web;

import com.example.aymanze.dao.entities.Produit;
import com.example.aymanze.dao.repositories.ProduitRepository;
import com.example.aymanze.metier.manager.ProduitManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class PharmacyController {

            @Autowired
            private ProduitManager produitManager;
            @Autowired
            private ProduitRepository produitRepository;

             @GetMapping("/index")
             public String showProducts(Model model) {
                 List<Produit> produits = produitManager.getAllProducts();
                 model.addAttribute("Produits", produits);
                 return "index";
             }


            @GetMapping("/deleteProduct")
            public String deleteProduct(@RequestParam(name = "id") Long id) {
                produitRepository.deleteById(id);
                return "redirect:/index";
            }

            @GetMapping("/updateProduct")
            public String updateProduct(Model model, @RequestParam(name = "id") Long id) {
                Produit p = produitManager.findProduitById(id);
                if (p != null) {
                    model.addAttribute("productToBeUpdated", p);
                    return "updateproduit";
                } else {
                    return "error";
                }
            }

            @PostMapping("/updateproduitx")
            public String update(Produit p) {
               produitManager.addProduit(p);
                return "redirect:/index";
            }

            @GetMapping("/produits/nouveau")
            public String nouveauProduit(Model model) {
                return "nouveauproduit";
            }

            @PostMapping("/addproduit")
            public String ajouterProduitToindex(Produit produit) {
                produitManager.addProduit(produit);
                return "redirect:/index";
            }



}

