package com.ceiba.lendings.dominio.excepcion;

public class LendingValueException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public LendingValueException(String mensaje) {
        super(mensaje);
    }
}