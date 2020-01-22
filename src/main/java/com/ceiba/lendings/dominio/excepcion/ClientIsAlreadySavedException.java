package com.ceiba.lendings.dominio.excepcion;

public class ClientIsAlreadySavedException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public ClientIsAlreadySavedException(String message) {
        super(message);
    }
}
