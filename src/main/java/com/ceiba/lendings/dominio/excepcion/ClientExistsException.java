package com.ceiba.lendings.dominio.excepcion;

public class ClientExistsException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public ClientExistsException(String mensaje) {
        super(mensaje);
    }
}
