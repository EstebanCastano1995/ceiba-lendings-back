package com.ceiba.lendings.dominio.excepcion;

public class LendingMustBeCreatedException extends RuntimeException{
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public LendingMustBeCreatedException(String message) {
        super(message);
    }
}
