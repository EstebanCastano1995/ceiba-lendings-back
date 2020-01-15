package com.ceiba.lendings.dominio.excepcion;

public class ClientHasLendingsException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public ClientHasLendingsException(String mensaje) {
        super(mensaje);
    }
}