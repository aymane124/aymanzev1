package com.example.aymanze.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String taille;
    private String ageMin;
    private String stock;
    private double price;


}
