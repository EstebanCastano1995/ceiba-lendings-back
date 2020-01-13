package com.ceiba.lendings.aplicacion.usecases;

/**
 * This define the methods for an Use Case service in the architecture.
 * @param <T>> Define the object that execute method receive to work properly
 * @param <R>> Define the object result after an execution of Use Case.
 */
public interface UseCase<T, R> {
    /**
     * Metodo que define los pasos que se ejecutarán en el caso de uso.
     * @return resultado que depende de la implementación del caso de uso
     * @throws Exception
     */
    public T  execute(R input) throws Exception;
}
