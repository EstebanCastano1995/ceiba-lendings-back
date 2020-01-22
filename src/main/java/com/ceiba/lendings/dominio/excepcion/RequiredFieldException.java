package com.ceiba.lendings.dominio.excepcion;

public class RequiredFieldException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public RequiredFieldException(String message) {
        super(message);
    }
}
