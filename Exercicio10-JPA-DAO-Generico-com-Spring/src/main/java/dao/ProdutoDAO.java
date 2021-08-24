package dao;

import java.util.List;
import java.util.Set;

import modelo.Produto;
import anotacao.RecuperaConjunto;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import anotacao.RecuperaUltimoOuPrimeiro;
import excecao.ObjetoNaoEncontradoException;

public interface ProdutoDAO extends DaoGenerico<Produto, Long> {
	/* ****** M�todos Gen�ricos ******* */

	@RecuperaObjeto
	Produto recuperaUmProdutoELances(long numero) throws ObjetoNaoEncontradoException;

	@RecuperaLista
	List<Produto> recuperaListaDeProdutos();

	@RecuperaUltimoOuPrimeiro
	Produto recuperaPrimeiroProduto() throws ObjetoNaoEncontradoException;

	@RecuperaLista
	List<Produto> recuperaListaDeProdutosELances();

	@RecuperaConjunto
	Set<Produto> recuperaConjuntoDeProdutosELances();

	/* ****** M�todos n�o Gen�ricos ******* */

	// Um m�todo definido aqui, que n�o seja anotado, dever� ser
	// implementado como final em ProdutoDAOImpl.
}
