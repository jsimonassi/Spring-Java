package service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dao.CarDAO;
import excecao.ObjetoNaoEncontradoException;
import modelo.Car;
import service.CarAppService;


public class CarAppServiceImpl implements CarAppService{
	
	@Autowired
	CarDAO carDao;
	
	

	@Transactional
	public long inclui(Car newCar) {
		carDao.inclui(newCar);
		return 0;
	}

	@Transactional
	public void altera(Car car) throws ObjetoNaoEncontradoException {
		carDao.altera(car);
	}

	@Transactional
	public void exclui(Car car) throws ObjetoNaoEncontradoException {
		
		Car bdCar = carDao.getPorId(car.getId());
		carDao.exclui(bdCar);
	}

	@Transactional
	public Car recuperaUmCarro(long id) throws ObjetoNaoEncontradoException {
		return carDao.getPorId(id);
	}

	
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}
	
	
	public Car getCarWithAllRents(long id) throws ObjetoNaoEncontradoException {
        try {
            return carDao.getCarWithAllRents(id);
            
        } catch (ObjetoNaoEncontradoException e) {
            throw new ObjetoNaoEncontradoException();
        }
    }


}
