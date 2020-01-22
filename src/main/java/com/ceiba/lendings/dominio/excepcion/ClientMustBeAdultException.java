package com.ceiba.lendings.dominio.excepcion;

public class ClientMustBeAdultException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public ClientMustBeAdultException(String message) {
        super(message);
    }
}
