package com.ism.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ism.dto.ProduitAddDto;
import com.ism.dto.ProduitShowDto;
import com.ism.entity.Produit;
import com.ism.exception.ProduitAlreadyExistsException;
import com.ism.repository.ProduitRepository;
import com.ism.validator.EnumError;

public class ProduitServiceImpl implements ProduitService {
    private ProduitRepository repository;

    public ProduitServiceImpl(ProduitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produit ajouterProduit(ProduitAddDto produit) {
        var result = rechercheProduitParNom(produit.nom);
        if (result.isPresent()) {
            throw new ProduitAlreadyExistsException(EnumError.PRODUIT_NOM_UNIQUE);
        }
        return repository.save(Produit.toEntity(produit));
    }

    @Override
    public Optional<Produit> rechercheProduitParNom(String nom) {
        return repository.findByName(nom);
    }

    @Override
    public List<ProduitShowDto> listerProduits() {
        List<Produit> produits = repository.findAll();
        List<ProduitShowDto> produitsDto = new ArrayList<>();
        for (Produit produit : produits) {
            var dto = new ProduitShowDto(produit.getId(), produit.getPrix(), produit.getNom(), produit.getQuantite());
            produitsDto.add(dto);
        }
        return produitsDto;
    }
    
}
