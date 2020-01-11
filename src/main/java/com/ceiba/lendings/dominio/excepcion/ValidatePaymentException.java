package com.ceiba.lendings.dominio.excepcion;

public class ValidatePaymentException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param mensaje
     */
    public ValidatePaymentException(String mensaje) {
        super(mensaje);
    }
}