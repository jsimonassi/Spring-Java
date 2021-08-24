package dao;

import java.util.List;
import anotacao.RecuperaLista;
import modelo.Car;

public interface CarDAO extends DaoGenerico<Car, Long> {
	
	@RecuperaLista
	List<Car> getAllCars();

}
