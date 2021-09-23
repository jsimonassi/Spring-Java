package dao;

import java.util.List;

import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import excecao.ObjetoNaoEncontradoException;
import modelo.Client;

public interface ClientDAO extends DaoGenerico<Client, Long> {
	
	@RecuperaLista
	List<Client> getAllClients();
	
	@RecuperaObjeto
	Client getClientWithAllRents(long id) throws ObjetoNaoEncontradoException;

}
