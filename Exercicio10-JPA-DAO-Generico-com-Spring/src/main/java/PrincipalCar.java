import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.ObjetoNaoEncontradoException;
import modelo.Car;
import modelo.Client;
import modelo.Rent;
import service.CarAppService;

public class PrincipalCar {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		CarAppService carAppService = (CarAppService) fabrica.getBean("carAppService");

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um novo carro");
			System.out.println("2. Alterar um carro");
			System.out.println("3. Remover um carro");
			System.out.println("4. Listar todos os carros");
			System.out.println("5. Listar todos as locações de um carro");
			System.out.println("6. Sair");

			int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");

			switch (opcao) {
			case 1: {
				String identification = Console.readLine('\n' + "Informe a placa do carro: ");
				String model = Console.readLine("Informe o modelo do carro: ");
				String brand = Console.readLine("Informe a marca do carro: ");

				
				Car newCar = new Car(identification, model, brand);
				
				long id = carAppService.inclui(newCar);

				System.out.println('\n' + "Carro número " + id + " incluído com sucesso!");

				break;
			}

			case 2: {
				int id = Console.readInt('\n' + "Digite o número do carro que você deseja alterar: ");
				Car car;
				try {
					car = carAppService.recuperaUmCarro(id);

				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + car.toString());

				System.out.println('\n' + "O que você deseja alterar?");
				System.out.println('\n' + "1. Placa");
				System.out.println("2. Modelo");
				System.out.println("2. Marca");

				int option = Console.readInt('\n' + "Digite um número de 1, 2 e 3:");

				switch (option) {
				case 1:
					String newIdentification = Console.readLine("Digite a nova placa: ");
					car.setIdentification(newIdentification);

					try {
						carAppService.altera(car);

						System.out.println('\n' + "Alteração de placa efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;

				case 2:
					String newModel = Console.readLine("Digite o novo modelo: ");
					car.setModel(newModel);

					try {
						carAppService.altera(car);

						System.out.println('\n' + "Alteração de modelo efetuada com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}

					break;

				case 3:
					String newBrand = Console.readLine("Digite a nova marca: ");
					car.setBrand(newBrand);

					try {
						carAppService.altera(car);

						System.out.println('\n' + "Alteração de marca efetuada com sucesso!");
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
				int id = Console.readInt('\n' + "Digite o número do carro que você deseja remover: ");
				Car car;

				try {
					car = carAppService.recuperaUmCarro(id);
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}

				System.out.println('\n' + car.toString());

				String resp = Console.readLine('\n' + "Confirma a remoção do carro?(s/n)");

				if (resp.equals("s")) {
					try {
						carAppService.exclui(car);
						System.out.println('\n' + "Carro removido com sucesso!");
					} catch (ObjetoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
				} else {
					System.out.println('\n' + "Client não removido.");
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
					System.out.println('\n' + "Não há carros cadastrados");
				}

				break;
			}
			
			case 5: {
				int id = Console.readInt('\n' + "Digite o número do carro que você deseja listar as locações: ");
				Car car;

				try {
					car = carAppService.getCarWithAllRents(id);
					System.out.println('\n' + car.toString());
					for(Rent rent : car.getRents()) {
						System.out.println('\n' + rent.toString());
					}
					
				} catch (ObjetoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
					break;
				}
				
				break;
			}

			case 6: {
				continua = false;
				break;
			}

			default:
				System.out.println('\n' + "Opção inválida!");
			}
		}
	}
}
