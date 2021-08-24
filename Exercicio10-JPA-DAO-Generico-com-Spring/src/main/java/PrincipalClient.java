import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.ObjetoNaoEncontradoException;
import modelo.Client;
import service.ClientAppService;

public class PrincipalClient {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		ClientAppService clientAppService = (ClientAppService) fabrica.getBean("clientAppService");

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um cliente");
			System.out.println("2. Alterar um cliente");
			System.out.println("3. Remover um cliente");
			System.out.println("4. Listar todos os clientes");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");

			switch (opcao) {
			case 1: {
				String name = Console.readLine('\n' + "Informe o nome do cliente: ");
				String cpf = Console.readLine("Informe o cpf do cliente: ");
				
				Client newClient = new Client(name, cpf);
				
				long id = clientAppService.inclui(newClient);

				System.out.println('\n' + "Cliente número " + id + " incluído com sucesso!");

				break;
			}

			case 2: {
				int id = Console.readInt('\n' + "Digite o número do cliente que você deseja alterar: ");
				Client client;
				try {
					client = clientAppService.recuperaUmCliente(id);

				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + client.toString());

				System.out.println('\n' + "O que você deseja alterar?");
				System.out.println('\n' + "1. Nome");
				System.out.println("2. Cpf");

				int option = Console.readInt('\n' + "Digite um número de 1 a 2:");

				switch (option) {
				case 1:
					String newName = Console.readLine("Digite o novo nome: ");
					client.setName(newName);

					try {
						clientAppService.altera(client);

						System.out.println('\n' + "Alteração de nome efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;

				case 2:
					String newCpf = Console.readLine("Digite o novo CPF: ");
					client.setCpf(newCpf);

					try {
						clientAppService.altera(client);

						System.out.println('\n' + "Alteração de CPF efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;

				default:
					System.out.println('\n' + "Opção inválida!");
				}

				break;
			}

			case 3: {
				int id = Console.readInt('\n' + "Digite o número do cliente que você deseja remover: ");
				Client client;

				try {
					client = clientAppService.recuperaUmCliente(id);
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + client.toString());

				String resp = Console.readLine('\n' + "Confirma a remoção do cliente?(s/n)");

				if (resp.equals("s")) {
					try {
						clientAppService.exclui(client);
						System.out.println('\n' + "Client removido com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				} else {
					System.out.println('\n' + "Client não removido.");
				}

				break;
			}

			case 4: {
			
				List<Client> clients = clientAppService.getAllClients();

				if (clients.size() != 0) {
					System.out.println("");

					for (Client client : clients) {
						System.out.println('\n' + client.toString());
					}
				} else {
					System.out.println('\n' + "Não há clientes cadastrados");
				}

				break;
			}

			case 5: {
				continua = false;
				break;
			}

			default:
				System.out.println('\n' + "Opção inválida!");
			}
		}
	}
}
