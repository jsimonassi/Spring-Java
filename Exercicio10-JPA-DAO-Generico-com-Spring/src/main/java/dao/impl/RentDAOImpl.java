package dao.impl;

import dao.RentDAO;
import modelo.Rent;

public abstract class RentDAOImpl extends JPADaoGenerico<Rent, Long> implements RentDAO {
	public RentDAOImpl() {
		super(Rent.class);
	}
}