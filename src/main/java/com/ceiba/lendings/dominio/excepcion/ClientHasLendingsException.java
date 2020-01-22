package com.ceiba.lendings.dominio.excepcion;

public class ClientHasLendingsException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public ClientHasLendingsException(String message) {
        super(message);
    }
}