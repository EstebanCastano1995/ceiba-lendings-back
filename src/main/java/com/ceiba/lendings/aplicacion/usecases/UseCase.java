package com.ceiba.lendings.aplicacion.usecases;

/**
 * This define the methods for an Use Case service in the architecture.
 * @param <argument>> Define the object that execute method receive to work properly
 * @param <result>> Define the object result after an execution of Use Case.
 */
public interface UseCase<argument, result> {
    /**
     * Metodo que define los pasos que se ejecutarán en el caso de uso.
     * @return resultado que depende de la implementación del caso de uso
     * @throws Exception
     */
    public result  execute(argument input) throws Exception;
}
