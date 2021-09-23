package service;

import java.util.List;

import excecao.ObjetoNaoEncontradoException;
import modelo.Car;


public interface CarAppService {
	long inclui(Car newCar);
	
	void altera(Car car) throws ObjetoNaoEncontradoException;
	
	void exclui(Car car) throws ObjetoNaoEncontradoException;
	
	Car recuperaUmCarro(long id) throws ObjetoNaoEncontradoException;
	
	List<Car> getAllCars();

	Car getCarWithAllRents(long id) throws ObjetoNaoEncontradoException;
	

}
