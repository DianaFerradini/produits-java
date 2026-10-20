package com.ism.validator;

public class StringValidator {
    public static EnumError isEmpty(String value) {
        if (value == null) return EnumError.PRODUIT_NULL;
        if (value.isEmpty()) {
            return EnumError.PRODUIT_VIDE;
        }
        return EnumError.PRODUIT_VALIDE;
    }
}
