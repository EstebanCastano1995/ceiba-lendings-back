package com.ceiba.lendings.dominio.excepcion;

public class ValidateLendingException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public ValidateLendingException(String mensaje) {
        super(mensaje);
    }
}