package dao.impl;

import org.springframework.stereotype.Repository;

import dao.LanceDAO;
import modelo.Lance;

@Repository
public abstract class LanceDAOImpl extends JPADaoGenerico<Lance, Long> implements LanceDAO {
	public LanceDAOImpl() {
		super(Lance.class);
	}
}
