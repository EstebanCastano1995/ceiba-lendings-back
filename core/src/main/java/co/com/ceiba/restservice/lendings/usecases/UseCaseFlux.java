package co.com.ceiba.restservice.lendings.usecases;

import reactor.core.publisher.Flux;

/**
 * This define the methods for an Use Case service in the architecture.
 * @param <Argument>> Define the object that execute method receive to work properly
 * @param <Result>> Define the object result after an execution of Use Case.
 */
public interface UseCaseFlux<Argument, Result> {
    /**
     * Metodo que define los pasos que se ejecutarán en el caso de uso.
     * @return resultado que depende de la implementación del caso de uso
     * @throws Exception
     */
    public Flux<Result> execute(Argument input) throws Exception;
}