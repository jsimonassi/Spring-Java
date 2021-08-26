package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dao.RentDAO;
import excecao.ObjetoNaoEncontradoException;
import modelo.Rent;
import service.RentAppService;


public class RentAppServiceImpl implements RentAppService{
	
	@Autowired
	RentDAO rentDao;
	

	@Transactional
	public long inclui(Rent newRent) {
		rentDao.inclui(newRent);
		return 0;
	}

	@Transactional
	public void altera(Rent rent) throws ObjetoNaoEncontradoException {
		rentDao.altera(rent);
	}

	@Transactional
	public void exclui(Rent rent) throws ObjetoNaoEncontradoException {
		
		Rent bdRent = rentDao.getPorId(rent.getId());
		rentDao.exclui(bdRent);
	}

	@Transactional
	public Rent recuperaUmaLocacao(long id) throws ObjetoNaoEncontradoException {
		return rentDao.getPorId(id);
	}

	
	public List<Rent> getAllRents() {
		return rentDao.getAllRents();
	}
}