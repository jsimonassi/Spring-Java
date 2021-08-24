package dao.impl;

import dao.ClientDAO;
import modelo.Client;

public abstract class ClientDAOImpl extends JPADaoGenerico<Client, Long> implements ClientDAO {
	public ClientDAOImpl() {
		super(Client.class);
	}
}
