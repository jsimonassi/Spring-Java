package excecao;

import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class ClientNotFoundException extends Exception {
	private final static long serialVersionUID = 1;

	public ClientNotFoundException(String msg) {
		super(msg);
	}
}