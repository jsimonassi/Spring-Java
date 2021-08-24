package dao.impl;

import dao.CarDAO;
import modelo.Car;

public abstract class CarDAOImpl extends JPADaoGenerico<Car, Long> implements CarDAO {
	public CarDAOImpl() {
		super(Car.class);
	}
}
