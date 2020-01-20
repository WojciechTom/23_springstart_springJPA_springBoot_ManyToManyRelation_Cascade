package pl.javastart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Client;
import pl.javastart.model.Order;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long>{

	
	/*
	 * In this class we override one methods (removeWithOutCascadeOption) - because we don't use 
	 * cascade annotation in it and we have to remove all orders before we remove a client.
	 * 
	 * second options is to use Cascade annotation and remove the client using remove method (taken from
	 * genericDao.
	 * 
	 */
	
	@Autowired
	private OrderDao orderDao;
	
	
	
	public void removeWithOutCascadeOption (Client client) {
		for(Order ord:client.getOrders()) {
			orderDao.remove(ord);
		}
		super.remove(client);
	}
	


}
