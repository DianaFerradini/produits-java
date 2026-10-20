package com.ism.exception;

import com.ism.validator.EnumError;

public class ProduitIllegalArgumentException extends IllegalArgumentException{
    private EnumError error;

    public ProduitIllegalArgumentException(EnumError error) {
        this.error = error;
    }

    public EnumError getError() {
        return error;
    }
}
