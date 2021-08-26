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
			System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar uma nova loca��o");
			System.out.println("2. Alterar uma loca��o");
			System.out.println("3. Remover uma loca��o");
			System.out.println("4. Listar todas as loca��es");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' + "Digite um n�mero entre 1 e 5:");

			switch (opcao) {
			case 1: {
				String startDate = Console.readLine('\n' + "Informe a data de in�cio da loca��o (DD/MM/AAAA): ");
				String endDate = Console.readLine('\n' + "Informe a data de t�rmino da loca��o (DD/MM/AAAA): ");
				double price = Console.readDouble('\n' + "Informe o valor da loca��o: ");
				Long carId  = (long) Console.readInt('\n' + "Informe o n�mero do carro: ");
				Long withdrawnStoreId = (long) Console.readInt('\n' + "Informe o n�mero da loja onde o carro ser� retirado: ");
				Long devolutionStoreId = (long) Console.readInt('\n' + "Informe o n�mero da loja onde o carro ser� devolvido: ");
				Long clientId = (long) Console.readInt('\n' + "Informe o n�mero do cliente: ");
				
				Rent newRent = new Rent(Util.strToCalendar(startDate), Util.strToCalendar(endDate),
						price, carId, withdrawnStoreId, devolutionStoreId);
				
				long id = rentAppService.inclui(newRent);

				System.out.println('\n' + "Loca��o inclu�da com sucesso!");

				break;
			}

			case 2: {
				//TODO
//				int id = Console.readInt('\n' + "Digite o n�mero da loja que voc� deseja alterar: ");
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
//					String newAddress = Console.readLine("Digite o novo endere�o: ");
//					store.setAddress(newAddress);
//
//					try {
//						storeAppService.altera(store);
//
//						System.out.println('\n' + "Altera��o de endere�o efetuada com sucesso!");
//					} catch (ObjetoNaoEncontradoException e) {
//						System.out.println('\n' + e.getMessage());
//					}
				break;
			}

			case 3: {
				int id = Console.readInt('\n' + "Digite o n�mero da loca��o que voc� deseja remover: ");
				Rent rent;

				try {
					rent = rentAppService.recuperaUmaLocacao(id);
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + rent.toString());

				String resp = Console.readLine('\n' + "Confirma a remo��o da loca��o?(s/n)");

				if (resp.equals("s")) {
					try {
						rentAppService.exclui(rent);
						System.out.println('\n' + "Loca��o removida com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				} else {
					System.out.println('\n' + "Loca��o n�o removida.");
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
					System.out.println('\n' + "N�o h� loca��es cadastradas cadastradas");
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
