package com.ism.repository;

import java.util.Optional;

import com.ism.entity.Produit;

public interface ProduitRepository {
    Produit save(Produit produit);
    Optional<Produit> findByName(String name);
}
