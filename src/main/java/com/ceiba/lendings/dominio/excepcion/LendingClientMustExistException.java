package com.ceiba.lendings.dominio.excepcion;

public class LendingClientMustExistException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public LendingClientMustExistException(String message) {
        super(message);
    }
}
