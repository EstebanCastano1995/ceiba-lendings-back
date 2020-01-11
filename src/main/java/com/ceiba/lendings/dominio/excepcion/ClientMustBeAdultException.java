package com.ceiba.lendings.dominio.excepcion;

public class ClientMustBeAdultException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public ClientMustBeAdultException(String mensaje) {
        super(mensaje);
    }
}
