package com.ism.exception;

import com.ism.validator.EnumError;

public class ProduitAlreadyExistsException extends RuntimeException {
    private EnumError error;

    public ProduitAlreadyExistsException(EnumError error) {
        this.error = error;
    }

    public EnumError getError() {
        return error;
    }
}
