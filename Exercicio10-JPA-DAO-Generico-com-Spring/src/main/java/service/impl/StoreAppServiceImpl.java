package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.StoreDAO;
import excecao.ObjetoNaoEncontradoException;
import modelo.Store;
import service.StoreAppService;


public class StoreAppServiceImpl implements StoreAppService{
	
	@Autowired
	StoreDAO storeDao;
	

	@Transactional
	public long inclui(Store newStore) {
		storeDao.inclui(newStore);
		return 0;
	}

	@Transactional
	public void altera(Store store) throws ObjetoNaoEncontradoException {
		storeDao.altera(store);
	}

	@Transactional
	public void exclui(Store store) throws ObjetoNaoEncontradoException {
		
		Store bdStore = storeDao.getPorId(store.getId());
		storeDao.exclui(bdStore);
	}

	@Transactional
	public Store recuperaUmaLoja(long id) throws ObjetoNaoEncontradoException {
		return storeDao.getPorId(id);
	}

	
	public List<Store> getAllStores() {
		return storeDao.getAllStores();
	}
}