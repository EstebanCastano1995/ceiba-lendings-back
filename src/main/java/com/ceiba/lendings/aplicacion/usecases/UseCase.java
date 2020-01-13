package com.ceiba.lendings.aplicacion.usecases;

import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;

/**
 * This define the methods for an Use Case service in the architecture.
 * @param <a> > Define the object that execute method receive to work properly
 * @param <r> > Define the object result after an execution of Use Case.
 */
public interface UseCase<a, r> {
    /**
     * Metodo que define los pasos que se ejecutarán en el caso de uso.
     * @return resultado que depende de la implementación del caso de uso
     * @throws Exception
     */
    public r execute(a input) throws UseCaseException;
}
