package com.ceiba.lendings.dominio.repositorio.client;

import com.ceiba.lendings.dominio.entidades.Client;
import java.util.List;

public interface ClientRepository  {

    /**
     * Método para obtener lista de clientas
     * @return , lista de clientes encontrada
     */
    List<Client> getClients();

    /**
     * Método para crear un cliente
     * @param client,cliente a guardar
     */
    void createClient(Client client);

    /**
     * Método para eliminar un cliente
     * @param client,cliente a eliminar
     */
    void deleteClient(Long client);

    /**
     * Método para saber si un cliente tiene prestamos registrados
     * @param id , id del cliente
     * @return , resultado de si tiene registrados prestamos o no
     */
    Boolean checkIfLendingClientExists(Long id);

    /**
     * Método para saber si un cliente esta registrado
     * @param id , objeto del cliente
     * @return , resultado de si el cliente esta registrado
     */
    Boolean checkIfClientExists(Client id);

    /**
     * Método para saber si un cliente esta registrado
     * @param id , objeto del cliente
     * @return , resultado de si el cliente esta registrado
     */
    Boolean checkIfClientExistsById(Long id);
}
