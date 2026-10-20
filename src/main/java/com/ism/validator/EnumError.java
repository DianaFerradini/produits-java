package com.ism.validator;

public enum EnumError {
    PRODUIT_NULL(1),
    PRODUIT_VIDE(2),
    PRODUIT_NOM_UNIQUE(3),
    PRODUIT_PRIX_POSITIF(4),
    PRODUIT_VALIDE(1000);

    private EnumError(int value){

    }

    public static String getMsgError(EnumError error) {
        switch (error) {
            case PRODUIT_NULL:
                return "Le nom ne peut pas être null.";

            case PRODUIT_VIDE:
                return "Le nom ne peut pas être vide.";

            case PRODUIT_NOM_UNIQUE:
                return "Un produit avec ce nom existe déjà.";

            case PRODUIT_PRIX_POSITIF:
                return "Le prix doit être positif.";
        
            default:
                return "";
        }
    }
}
