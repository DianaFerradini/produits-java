package com.ism.view;

import java.util.Scanner;

import com.ism.dto.ProduitAddDto;
import com.ism.dto.ProduitShowDto;
import com.ism.exception.ProduitAlreadyExistsException;
import com.ism.exception.ProduitIllegalArgumentException;
import com.ism.service.ProduitService;
import com.ism.validator.EnumError;

public final class ProduitView extends View{
    private static ProduitView instanceProduit = null;
    private ProduitService service;

    private ProduitView(Scanner scanner, ProduitService service) {
        super(scanner);
        this.service = service;
    }
    
    public static ProduitView getInstanceProduit(Scanner scanner, ProduitService service) {
        if (instanceProduit == null) {
            instanceProduit = new ProduitView(scanner, service);
        }
        return instanceProduit;
    }

    public void afficherProduits() {
        var produits = service.listerProduits();
        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré.");
            return;
        }
        for (ProduitShowDto produit : produits) afficherProduit(produit);
    }

    public void afficherProduit(ProduitShowDto produit) {
        System.out.printf("ID : %s | Nom : %s | Prix : %s | Quantité : %s%n",
                produit.id, produit.nom, produit.prix, produit.quantite);
    }

    public void ajouterProduit() {
        String nom = lireTexte("Nom : ");
        double prix = lireDecimal("Prix unitaire (maximum 2 décimales) : ");
        Integer quantite = lireEntier("Quantité : ");
        if (quantite == null) return;
        if (quantite < 0) {
            System.out.println("La quantité ne peut pas être négative.");
            return;
        }

        try {
            var produitAddDto = new ProduitAddDto(prix, nom, quantite.intValue());
            service.ajouterProduit(produitAddDto);
            System.out.println("Produit ajouté.");
        } catch (ProduitIllegalArgumentException e) {
            var result = e.getError();
            System.out.println(EnumError.getMsgError(result));
        } catch (ProduitAlreadyExistsException e) {
            var result = e.getError();
            System.out.println(EnumError.getMsgError(result));
        }
    }
}
