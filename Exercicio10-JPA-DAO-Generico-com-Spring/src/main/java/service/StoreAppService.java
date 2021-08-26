package service;

import java.util.List;

import excecao.ObjetoNaoEncontradoException;
import modelo.Store;

public interface StoreAppService {
	
	long inclui(Store newStore);
	
	void altera(Store store) throws ObjetoNaoEncontradoException;
	
	void exclui(Store store) throws ObjetoNaoEncontradoException;
	
	Store recuperaUmaLoja(long id) throws ObjetoNaoEncontradoException;
	
	List<Store> getAllStores();

}
