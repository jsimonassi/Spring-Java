package dao.controle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.impl.CarDAOImpl;
import dao.impl.ClientDAOImpl;
import dao.impl.RentDAOImpl;
import dao.impl.StoreDAOImpl;
import net.sf.cglib.proxy.Enhancer;

// A anotação @Configuration indica que esta classe possui um ou mais métodos anotados com @Bean.
@Configuration
public class FabricaDeDao {
	
	// @Bean diz ao Spring:
	// Aqui está uma instância da classe ProdutoDAOImpl, por favor, 
	// guarde esta instância e me devolva quando eu a pedir.

	// @Autowired em ProdutoAppServiceImpl diz:
	// Por favor, me retorne uma instância do tipo ProdutoDAO, isto é,  
	// aquela que foi criada mais cedo com a anotação @Bean.
	
	@Bean
	public static ClientDAOImpl getClientDao() throws Exception {
		return getDao(dao.impl.ClientDAOImpl.class);
	}
	
	@Bean
	public static CarDAOImpl getCarDao() throws Exception {
		return getDao(dao.impl.CarDAOImpl.class);
	}
	
	@Bean
	public static StoreDAOImpl getStoreDao() throws Exception {
		return getDao(dao.impl.StoreDAOImpl.class);
	}
	
	@Bean
	public static RentDAOImpl getRentDao() throws Exception {
		return getDao(dao.impl.RentDAOImpl.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getDao(Class<T> classeDoDao) throws Exception {
		return (T) Enhancer.create(classeDoDao, new InterceptadorDeDAO());
	}
}