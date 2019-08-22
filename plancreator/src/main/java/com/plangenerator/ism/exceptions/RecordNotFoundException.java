package com.plangenerator.ism.exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(int id) {
        super("Could not find record " + id);
    }

}

