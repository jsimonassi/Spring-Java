package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dao.ClientDAO;
import excecao.ObjetoNaoEncontradoException;
import modelo.Client;
import service.ClientAppService;

public class ClientAppServiceImpl implements ClientAppService{
	
	@Autowired
	ClientDAO clientDao;
	
	

	@Transactional
	public long inclui(Client newClient) {
		clientDao.inclui(newClient);
		return 0;
	}

	@Transactional
	public void altera(Client client) throws ObjetoNaoEncontradoException {
		clientDao.altera(client);
	}

	@Transactional
	public void exclui(Client client) throws ObjetoNaoEncontradoException {
		
		Client bdClient = clientDao.getPorId(client.getId());
		clientDao.exclui(bdClient);
	}

	@Transactional
	public Client recuperaUmCliente(long id) throws ObjetoNaoEncontradoException {
		return clientDao.getPorId(id);
	}

	
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

}
