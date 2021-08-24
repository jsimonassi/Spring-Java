package dao;

import java.util.List;

import anotacao.RecuperaLista;
import modelo.Client;

public interface ClientDAO extends DaoGenerico<Client, Long> {
	
	@RecuperaLista
	List<Client> getAllClients();

}
