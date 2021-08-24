package service;

import java.util.List;

import excecao.DataDeLanceInvalidaException;
import excecao.LanceNaoEncontradoException;
import excecao.ProdutoNaoEncontradoException;
import excecao.ValorDeLanceInvalidoException;
import modelo.Lance;

public interface LanceAppService {
	long inclui(Lance umLance) 
		throws ProdutoNaoEncontradoException, ValorDeLanceInvalidoException, DataDeLanceInvalidaException;

	void exclui(Lance umLance) throws LanceNaoEncontradoException;
	
	Lance recuperaUmLance(long numero) throws LanceNaoEncontradoException;
	
	List<Lance> recuperaLances();
}
