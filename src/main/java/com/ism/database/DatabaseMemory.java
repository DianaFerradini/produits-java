package com.ism.database;

import java.util.ArrayList;
import java.util.List;

import com.ism.entity.Produit;

public class DatabaseMemory implements Database {
    private List<Produit> produits;
    private static int produitId;

    @Override 
    public List<Produit> getProduits() {
        return produits;
    }

    public Produit insert(Produit produit) {
        produitId++;
        produit.setId(produitId);
        produits.add(produit);
        return produit;
    }

    private static DatabaseMemory instance = null;

    private DatabaseMemory() {}

    public static DatabaseMemory getInstance() {
        if (instance == null) {
            instance = new DatabaseMemory();
        }
        return instance;
    }

    @Override
    public void createConnexion() {
        produits = new ArrayList<Produit>();
    }
}
