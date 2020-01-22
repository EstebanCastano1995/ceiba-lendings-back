package com.ceiba.lendings.dominio.excepcion;

public class LendingDateException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public LendingDateException(String message) {
        super(message);
    }
}