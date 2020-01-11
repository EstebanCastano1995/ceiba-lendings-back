package com.ceiba.lendings.dominio.excepcion;

public class RequiredFieldException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public RequiredFieldException(String mensaje) {
        super(mensaje);
    }
}
