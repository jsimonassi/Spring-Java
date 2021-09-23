package dao.impl;

import org.springframework.stereotype.Repository;

import dao.ClientDAO;
import modelo.Client;

@Repository
public abstract class ClientDAOImpl extends JPADaoGenerico<Client, Long> implements ClientDAO {
	public ClientDAOImpl() {
		super(Client.class);
	}
}
