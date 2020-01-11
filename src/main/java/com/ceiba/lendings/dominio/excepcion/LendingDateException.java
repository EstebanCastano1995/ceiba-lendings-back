package com.ceiba.lendings.dominio.excepcion;

public class LendingDateException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public LendingDateException(String mensaje) {
        super(mensaje);
    }
}