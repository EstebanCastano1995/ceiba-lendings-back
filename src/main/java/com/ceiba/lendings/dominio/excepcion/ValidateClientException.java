package com.ceiba.lendings.dominio.excepcion;

public class ValidateClientException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public ValidateClientException(String mensaje) {
        super(mensaje);
    }
}