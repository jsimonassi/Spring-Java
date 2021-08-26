import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.ObjetoNaoEncontradoException;
import modelo.Store;
import service.StoreAppService;

public class PrincipalStore {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		StoreAppService storeAppService = (StoreAppService) fabrica.getBean("storeAppService");

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar uma nova loja");
			System.out.println("2. Alterar uma loja");
			System.out.println("3. Remover uma loja");
			System.out.println("4. Listar todas as lojas");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' + "Digite um n�mero entre 1 e 5:");

			switch (opcao) {
			case 1: {
				String address = Console.readLine('\n' + "Informe o endereco da loja: ");
				
				Store newStore = new Store(address);
				
				long id = storeAppService.inclui(newStore);

				System.out.println('\n' + "Loja n�mero " + id + " inclu�da com sucesso!");

				break;
			}

			case 2: {
				int id = Console.readInt('\n' + "Digite o n�mero da loja que voc� deseja alterar: ");
				Store store;
				try {
					store = storeAppService.recuperaUmaLoja(id);

				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + store.toString());

	
					String newAddress = Console.readLine("Digite o novo endere�o: ");
					store.setAddress(newAddress);

					try {
						storeAppService.altera(store);

						System.out.println('\n' + "Altera��o de endere�o efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				break;
			}

			case 3: {
				int id = Console.readInt('\n' + "Digite o n�mero da loja que voc� deseja remover: ");
				Store store;

				try {
					store = storeAppService.recuperaUmaLoja(id);
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + store.toString());

				String resp = Console.readLine('\n' + "Confirma a remo��o da loja?(s/n)");

				if (resp.equals("s")) {
					try {
						storeAppService.exclui(store);
						System.out.println('\n' + "Loja removida com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				} else {
					System.out.println('\n' + "Loja n�o removida.");
				}

				break;
			}

			case 4: {
			
				List<Store> stores = storeAppService.getAllStores();

				if (stores.size() != 0) {
					System.out.println("");

					for (Store store : stores) {
						System.out.println('\n' + store.toString());
					}
				} else {
					System.out.println('\n' + "N�o h� lojas cadastradas");
				}

				break;
			}

			case 5: {
				continua = false;
				break;
			}

			default:
				System.out.println('\n' + "Op��o inv�lida!");
			}
		}
	}
}
