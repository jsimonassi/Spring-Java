package service;

import java.util.List;

import excecao.ObjetoNaoEncontradoException;
import modelo.Rent;

public interface RentAppService {
	
	long inclui(Rent newRent);
	
	void altera(Rent rent) throws ObjetoNaoEncontradoException;
	
	void exclui(Rent rent) throws ObjetoNaoEncontradoException;
	
	Rent recuperaUmaLocacao(long id) throws ObjetoNaoEncontradoException;
	
	List<Rent> getAllRents();

}
