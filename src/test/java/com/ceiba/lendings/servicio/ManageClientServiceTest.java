package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.ClientTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.excepcion.ClientHasLendingsException;
import com.ceiba.lendings.dominio.excepcion.ClientIsAlreadySavedException;
import com.ceiba.lendings.dominio.excepcion.ClientMustExistException;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.servicio.client.CreateClientService;
import com.ceiba.lendings.dominio.servicio.client.DeleteClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ManageClientServiceTest {

    @Test
    public void validateCreateClientWithIdAlreadySaved() {
        Client cliente = new ClientTestDataBuilder().build();
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.checkIfClientExists(cliente)).thenReturn(true);

        CreateClientService createClientService = new CreateClientService(repositorioCliente);
        BaseTest.assertThrows(()-> createClientService.createClient(cliente), ClientIsAlreadySavedException.class, "El cliente que desea guardar ya se encuentra registrado");
    }

    @Test
    public void validateDeleteClientIfHasLendings() {
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.checkIfLendingClientExists(Mockito.any())).thenReturn(true);

        DeleteClientService deleteClientService = new DeleteClientService(repositorioCliente);
        BaseTest.assertThrows(()-> deleteClientService.deleteClient((long)21123123), ClientHasLendingsException.class, "El cliente que intenta eliminar tiene prestamos registrados");
    }

    @Test
    public void validateDeleteClientIfClientNotSaved() {
        Client cliente = new ClientTestDataBuilder().build();
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.checkIfClientExistsById((long)123123)).thenReturn(false);

        DeleteClientService deleteClientService = new DeleteClientService(repositorioCliente);
        BaseTest.assertThrows(()-> deleteClientService.deleteClient((long)21231231), ClientMustExistException.class, "El cliente que intenta eliminar no esta registrado");
    }
}
