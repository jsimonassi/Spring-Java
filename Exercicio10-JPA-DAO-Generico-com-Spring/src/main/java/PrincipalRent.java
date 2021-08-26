import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.ObjetoNaoEncontradoException;
import modelo.Rent;
import service.RentAppService;
import util.Util;

public class PrincipalRent {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		RentAppService rentAppService = (RentAppService) fabrica.getBean("rentAppService");

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar uma nova locação");
			System.out.println("2. Alterar uma locação");
			System.out.println("3. Remover uma locação");
			System.out.println("4. Listar todas as locações");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");

			switch (opcao) {
			case 1: {
				String startDate = Console.readLine('\n' + "Informe a data de início da locação (DD/MM/AAAA): ");
				String endDate = Console.readLine('\n' + "Informe a data de término da locação (DD/MM/AAAA): ");
				double price = Console.readDouble('\n' + "Informe o valor da locação: ");
				Long carId  = (long) Console.readInt('\n' + "Informe o número do carro: ");
				Long withdrawnStoreId = (long) Console.readInt('\n' + "Informe o número da loja onde o carro será retirado: ");
				Long devolutionStoreId = (long) Console.readInt('\n' + "Informe o número da loja onde o carro será devolvido: ");
				Long clientId = (long) Console.readInt('\n' + "Informe o número do cliente: ");
				
				Rent newRent = new Rent(Util.strToCalendar(startDate), Util.strToCalendar(endDate),
						price, carId, withdrawnStoreId, devolutionStoreId);
				
				long id = rentAppService.inclui(newRent);

				System.out.println('\n' + "Locação incluída com sucesso!");

				break;
			}

			case 2: {
				//TODO
//				int id = Console.readInt('\n' + "Digite o número da loja que você deseja alterar: ");
//				Store store;
//				try {
//					store = storeAppService.recuperaUmaLoja(id);
//
//				} catch (ObjetoNaoEncontradoException e) {
//					System.out.println('\n' + e.getMessage());
//					break;
//				}
//
//				System.out.println('\n' + store.toString());
//
//	
//					String newAddress = Console.readLine("Digite o novo endereço: ");
//					store.setAddress(newAddress);
//
//					try {
//						storeAppService.altera(store);
//
//						System.out.println('\n' + "Alteração de endereço efetuada com sucesso!");
//					} catch (ObjetoNaoEncontradoException e) {
//						System.out.println('\n' + e.getMessage());
//					}
				break;
			}

			case 3: {
				int id = Console.readInt('\n' + "Digite o número da locação que você deseja remover: ");
				Rent rent;

				try {
					rent = rentAppService.recuperaUmaLocacao(id);
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + rent.toString());

				String resp = Console.readLine('\n' + "Confirma a remoção da locação?(s/n)");

				if (resp.equals("s")) {
					try {
						rentAppService.exclui(rent);
						System.out.println('\n' + "Locação removida com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				} else {
					System.out.println('\n' + "Locação não removida.");
				}

				break;
			}

			case 4: {
			
				List<Rent> rents = rentAppService.getAllRents();

				if (rents.size() != 0) {
					System.out.println("");

					for (Rent rent : rents) {
						System.out.println('\n' + rent.toString());
					}
				} else {
					System.out.println('\n' + "Não há locações cadastradas cadastradas");
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
