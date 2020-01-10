package com.ceiba.lendings.dominio.repositorio;

import com.ceiba.lendings.aplicacion.comando.command.ClientCommand;
import java.util.List;

public interface ClientRepository  {
    List<ClientCommand> getClients();
}
