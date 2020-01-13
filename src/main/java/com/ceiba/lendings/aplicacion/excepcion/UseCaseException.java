package com.ceiba.lendings.aplicacion.excepcion;

public class UseCaseException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public UseCaseException(String mensaje) {
        super(mensaje);
    }
}
