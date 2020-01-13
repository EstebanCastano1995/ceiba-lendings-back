package com.ceiba.lendings.servicio;

import com.ceiba.lendings.BasePrueba;
import com.ceiba.lendings.databuilder.ClientTestDataBuilder;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.servicio.client.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CreateClientService {
   /* @Test
    public void validarEliminarCliente() {
        Client cliente = new ClientTestDataBuilder().build();
        ClientRepository repositorioCliente = Mockito.mock(ClientRepository.class);
        Mockito.when(repositorioCliente.deleteClient(Mockito.any())).thenReturn(true);

        ClientServiceImpl servicioCrearCliente = new ClientServiceImpl(repositorioCliente);
        BasePrueba.assertThrows(() -> servicioCrearCliente.validarEliminarCliente(cliente), ExcepcionClienteExiste.class, "El cliente ya se encuentra registrado");
    }*/
}
