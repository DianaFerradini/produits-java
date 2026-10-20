package com.ism.dto;

public final class ProduitShowDto {
    public final int id;
    public final double prix;
    public final String nom;
    public final int quantite;

    public ProduitShowDto(int id, double prix, String nom, int quantite) {
        this.id = id;
        this.prix = prix;
        this.nom = nom;
        this.quantite = quantite;
    }
    
}
