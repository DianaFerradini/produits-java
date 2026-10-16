package com.ism.repository;

import java.util.List;
import java.util.Optional;

import com.ism.database.Database;
import com.ism.entity.Produit;

public class ProduitRepositoryImpl implements ProduitRepository {
    private Database database;

    public ProduitRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public Produit save(Produit produit) {
        return database.insert(produit);
    }

    @Override
    public Optional<Produit> findByName(String name) {
        List<Produit> produits = database.getProduits();
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(name)) {
                System.out.println("Un produit avec ce nom existe déjà.");
                return null;
            }
        }
        return Optional.empty();
    }
    
}
