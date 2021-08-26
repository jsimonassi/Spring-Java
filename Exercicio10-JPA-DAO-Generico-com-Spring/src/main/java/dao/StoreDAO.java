package dao;

import java.util.List;

import anotacao.RecuperaLista;
import modelo.Store;

public interface StoreDAO extends DaoGenerico<Store, Long> {
	
	@RecuperaLista
	List<Store> getAllStores();

}
