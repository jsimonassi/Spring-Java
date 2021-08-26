package dao;

import java.util.List;

import anotacao.RecuperaLista;
import modelo.Rent;

public interface RentDAO extends DaoGenerico<Rent, Long> {
	
	@RecuperaLista
	List<Rent> getAllRents();

}
