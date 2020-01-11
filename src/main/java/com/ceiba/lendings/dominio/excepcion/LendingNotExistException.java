package com.ceiba.lendings.dominio.excepcion;

public class LendingNotExistException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public LendingNotExistException(String mensaje) {
        super(mensaje);
    }
}
