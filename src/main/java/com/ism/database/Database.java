package com.ism.database;

import java.util.List;

import com.ism.entity.Produit;

public interface Database {
    void createConnexion();
    Produit insert(Produit produit);
    List<Produit> getProduits();
}
