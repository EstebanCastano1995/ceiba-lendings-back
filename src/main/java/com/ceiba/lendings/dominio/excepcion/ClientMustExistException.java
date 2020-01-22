package com.ceiba.lendings.dominio.excepcion;

public class ClientMustExistException extends RuntimeException {
    /*
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @param message
     */
    public ClientMustExistException(String message) {
        super(message);
    }
}
