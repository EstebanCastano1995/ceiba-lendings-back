package com.ceiba.lendings.dominio.excepcion;

public class LendingMustBeCreatedException extends RuntimeException{
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public LendingMustBeCreatedException(String mensaje) {
        super(mensaje);
    }
}
