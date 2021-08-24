package dao.impl;

import org.springframework.stereotype.Repository;

import dao.ProdutoDAO;
import modelo.Produto;

@Repository
public abstract class ProdutoDAOImpl extends JPADaoGenerico<Produto, Long> implements ProdutoDAO {
	public ProdutoDAOImpl() {
		super(Produto.class);
	}
}
