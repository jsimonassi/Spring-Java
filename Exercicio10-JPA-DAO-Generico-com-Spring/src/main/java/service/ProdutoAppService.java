package service;

import java.util.List;

import excecao.ProdutoNaoEncontradoException;
import modelo.Produto;

public interface ProdutoAppService {
	long inclui(Produto umProduto);
	
	void altera(Produto umProduto) throws ProdutoNaoEncontradoException;
	
	void exclui(Produto umProduto) throws ProdutoNaoEncontradoException;
	
	Produto recuperaUmProduto(long numero) throws ProdutoNaoEncontradoException;
	
	Produto recuperaUmProdutoELances(long numero) throws ProdutoNaoEncontradoException;
	
	Produto recuperaPrimeiroProduto() throws ProdutoNaoEncontradoException;
	
	List<Produto> recuperaProdutosELances();
}
