package service;

import java.util.List;

import excecao.ClientNotFoundException;
import excecao.ObjetoNaoEncontradoException;
import modelo.Client;
import modelo.Rent;

public interface ClientAppService {
	long inclui(Client newClient);
	
	void altera(Client client) throws ObjetoNaoEncontradoException;
	
	void exclui(Client client) throws ObjetoNaoEncontradoException;
	
	Client recuperaUmCliente(long id) throws ObjetoNaoEncontradoException;
	
	List<Client> getAllClients();
	
	Client getClientWithAllRents(long id) throws ObjetoNaoEncontradoException;

}
