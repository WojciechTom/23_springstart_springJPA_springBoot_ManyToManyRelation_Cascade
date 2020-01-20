package pl.javastart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.ClientDao;
import pl.javastart.model.Client;
import pl.javastart.model.Order;
import pl.javastart.model.Product;


@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
			
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		
		
		Client client1 = new Client("Wojciech", "Tomczyk", "Polna 2");
		Order order1 = new Order( "zamówienie świateczne");
		Product product1 = new Product("Pralka", 900.30, "Pralka automatyczna bosch");
		Product product2 = new Product("zmywarka", 1200.00, "zmywarka do zabudowy beko");
		order1.getProducts().add(product1);
		order1.getProducts().add(product2);
		client1.addOrder(order1);
		clientDao.save(client1);
		
		
		ctx.close();
	}

}
