package com.ceiba.lendings.dominio.repositorio.lending;

import com.ceiba.lendings.dominio.entidades.Lending;
import java.util.List;

public interface LendingRepository {

    /**
     * Método para obtener la lista de prestamos
     * @return , Lista de prestamos
     */
    List<Lending> getLendings();

    /**
     *  Metodo para crear un prestamo.
     * @param lending, Prestamo a crear
     */
    void createLending(Lending lending);

    /**
     * Método para saber si un prestamo existe
     * @param lending , prestamo a buscar
     * @return , resultado de si el prestamo esta registrado o no
     */
    Boolean checkIfLendingExists(Lending lending);

    /**
     * Método para saber si el cliente de un prestamo existe
     * @param lending , prestamo con el cliente a buscar
     * @return , resultado de si el cliente del prestamo esta registrado o no
     */
    Boolean checkIfLendingClientExists(Lending lending);
}
