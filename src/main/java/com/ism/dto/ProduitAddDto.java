package com.ism.dto;

import com.ism.exception.ProduitIllegalArgumentException;
import com.ism.validator.DoubleValidator;
import com.ism.validator.EnumError;
import com.ism.validator.StringValidator;

public final class ProduitAddDto {
    public final double prix;
    public final String nom;
    public final int quantite;

    public ProduitAddDto(double prix, String nom, int quantite) {
        validatePrix(prix);
        validateNom(nom);
        validateQuantite(quantite);
        this.prix = prix;
        this.nom = nom;
        this.quantite = quantite;
    }

    private void validatePrix(double prix) {
        var result = DoubleValidator.isDouble(prix);
        if (result != EnumError.PRODUIT_VALIDE) {
            throw new ProduitIllegalArgumentException(result);
        }
    }

    private void validateNom(String nom) {
        var result = StringValidator.isEmpty(nom);
        if (result != EnumError.PRODUIT_VALIDE) {
            throw new ProduitIllegalArgumentException(result);
        }
    }

    private void validateQuantite(int quantite) {}
}
