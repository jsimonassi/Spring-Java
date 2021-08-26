package dao.impl;

import dao.StoreDAO;
import modelo.Store;

public abstract class StoreDAOImpl extends JPADaoGenerico<Store, Long> implements StoreDAO {
	public StoreDAOImpl() {
		super(Store.class);
	}
}