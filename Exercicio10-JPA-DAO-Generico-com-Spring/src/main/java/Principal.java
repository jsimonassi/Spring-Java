import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import corejava.Console;

//TODO
public class Principal {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		//StoreAppService storeAppService = (StoreAppService) fabrica.getBean("storeAppService");

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Alugar um carro");
			System.out.println("3. Exibir todos os carros alugados");
			System.out.println("4. Exibir todos os clientes com locações ativas");
			System.out.println("5. Listar todas as lojas com locações ativas");
			System.out.println("6. Sair");

			int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");

			switch (opcao) {
			case 1: {
				

				break;
			}

			case 2: {
				
				break;
			}

			case 3: {
				

				break;
			}

			case 4: {
			

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
