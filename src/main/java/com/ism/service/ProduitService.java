package com.ism.service;

import java.util.List;
import java.util.Optional;

import com.ism.dto.ProduitAddDto;
import com.ism.dto.ProduitShowDto;
import com.ism.entity.Produit;

public interface ProduitService {
    Produit ajouterProduit(ProduitAddDto produit);
    Optional<Produit> rechercheProduitParNom(String nom);
    List<ProduitShowDto> listerProduits();
}
