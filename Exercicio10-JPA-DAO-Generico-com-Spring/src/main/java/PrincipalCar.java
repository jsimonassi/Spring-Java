import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.ObjetoNaoEncontradoException;
import modelo.Car;
import service.CarAppService;

public class PrincipalCar {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		CarAppService carAppService = (CarAppService) fabrica.getBean("carAppService");

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um novo carro");
			System.out.println("2. Alterar um carro");
			System.out.println("3. Remover um carro");
			System.out.println("4. Listar todos os carros");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' + "Digite um n�mero entre 1 e 5:");

			switch (opcao) {
			case 1: {
				String identification = Console.readLine('\n' + "Informe a placa do carro: ");
				String model = Console.readLine("Informe o modelo do carro: ");
				String brand = Console.readLine("Informe a marca do carro: ");

				
				Car newCar = new Car(identification, model, brand);
				
				long id = carAppService.inclui(newCar);

				System.out.println('\n' + "Carro n�mero " + id + " inclu�do com sucesso!");

				break;
			}

			case 2: {
				int id = Console.readInt('\n' + "Digite o n�mero do carro que voc� deseja alterar: ");
				Car car;
				try {
					car = carAppService.recuperaUmCarro(id);

				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + car.toString());

				System.out.println('\n' + "O que voc� deseja alterar?");
				System.out.println('\n' + "1. Placa");
				System.out.println("2. Modelo");
				System.out.println("2. Marca");

				int option = Console.readInt('\n' + "Digite um n�mero de 1, 2 e 3:");

				switch (option) {
				case 1:
					String newIdentification = Console.readLine("Digite a nova placa: ");
					car.setIdentification(newIdentification);

					try {
						carAppService.altera(car);

						System.out.println('\n' + "Altera��o de placa efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;

				case 2:
					String newModel = Console.readLine("Digite o novo modelo: ");
					car.setModel(newModel);

					try {
						carAppService.altera(car);

						System.out.println('\n' + "Altera��o de modelo efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;

				case 3:
					String newBrand = Console.readLine("Digite a nova marca: ");
					car.setBrand(newBrand);

					try {
						carAppService.altera(car);

						System.out.println('\n' + "Altera��o de marca efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;
					
				default:
					System.out.println('\n' + "Op��o inv�lida!");
				}

				break;
			}

			case 3: {
				int id = Console.readInt('\n' + "Digite o n�mero do carro que voc� deseja remover: ");
				Car car;

				try {
					car = carAppService.recuperaUmCarro(id);
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + car.toString());

				String resp = Console.readLine('\n' + "Confirma a remo��o do carro?(s/n)");

				if (resp.equals("s")) {
					try {
						carAppService.exclui(car);
						System.out.println('\n' + "Carro removido com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				} else {
					System.out.println('\n' + "Client n�o removido.");
				}

				break;
			}

			case 4: {
			
				List<Car> cars = carAppService.getAllCars();

				if (cars.size() != 0) {
					System.out.println("");

					for (Car car : cars) {
						System.out.println('\n' + car.toString());
					}
				} else {
					System.out.println('\n' + "N�o h� carros cadastrados");
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
