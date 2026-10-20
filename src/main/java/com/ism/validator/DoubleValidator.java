package com.ism.validator;

public class DoubleValidator {
    public static EnumError isDouble(double value){
        if (value <= 0) {
            return EnumError.PRODUIT_PRIX_POSITIF;
        }
        return EnumError.PRODUIT_VALIDE;
    }
}
