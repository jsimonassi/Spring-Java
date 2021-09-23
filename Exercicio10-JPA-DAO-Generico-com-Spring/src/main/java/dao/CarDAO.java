package dao;

import java.util.List;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import excecao.ObjetoNaoEncontradoException;
import modelo.Car;
import modelo.Client;

public interface CarDAO extends DaoGenerico<Car, Long> {
	
	@RecuperaLista
	List<Car> getAllCars();
	
	@RecuperaObjeto
	Car getCarWithAllRents(long id) throws ObjetoNaoEncontradoException;

}
