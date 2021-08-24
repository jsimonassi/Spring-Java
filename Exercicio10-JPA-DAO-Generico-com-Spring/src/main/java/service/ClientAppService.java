package service;

import java.util.List;

import excecao.ObjetoNaoEncontradoException;
import modelo.Client;

public interface ClientAppService {
	long inclui(Client newClient);
	
	void altera(Client client) throws ObjetoNaoEncontradoException;
	
	void exclui(Client client) throws ObjetoNaoEncontradoException;
	
	Client recuperaUmCliente(long id) throws ObjetoNaoEncontradoException;
	
	List<Client> getAllClients();

}
