package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BasePrueba;
import com.ceiba.lendings.databuilder.ClientTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.servicio.client.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ManageClientServiceTest {

    @Test
    public void validateDeleteClientIfHasLendings() {
        Client cliente = new ClientTestDataBuilder().build();
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.checkIfLendingClientExists(Mockito.any())).thenReturn(true);
        Mockito.when(repositorioCliente.deleteClient(Mockito.any())).thenReturn(false);

        ClientServiceImpl createClientService = new ClientServiceImpl(repositorioCliente);
        BasePrueba.assertCorrect(createClientService.deleteClient(cliente), false);
    }

    @Test
    public void validateDeleteClientIfHasNotLendings() {
        Client cliente = new ClientTestDataBuilder().build();
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.checkIfLendingClientExists(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioCliente.deleteClient(Mockito.any())).thenReturn(true);

        ClientServiceImpl createClientService = new ClientServiceImpl(repositorioCliente);
        BasePrueba.assertCorrect(createClientService.deleteClient(cliente), true);
    }

    @Test
    public void validateCreateClientTest() {
        Client client=new ClientTestDataBuilder().build();
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.createClient(Mockito.any())).thenReturn(true);

        ClientServiceImpl createClientService = new ClientServiceImpl(repositorioCliente);
        BasePrueba.assertCorrect(createClientService.createClient(client), true);
    }

}
