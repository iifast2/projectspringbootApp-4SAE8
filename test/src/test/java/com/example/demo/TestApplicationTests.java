package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;

import com.example.demo.entities.Client;
import com.example.demo.entities.Stock;
import com.example.demo.service.clientService;
import com.example.demo.service.stockService;

@SpringBootTest
class TestApplicationTests {
	@Autowired
	private stockService ss;
	@Autowired
	private clientService cr;
	
	
//	@Test
//	public void testAddStock() {
//	List<Stock> stocks = ss.getAllStocks();
//	int expected=stocks.size();
//	Stock s = new Stock();
//	s.setLibelleStock("stock test");
//	s.setQte(10);
//	s.setQteMin(100);
//	Stock savedStock= ss.saveStock(s);
//	stocks.add(savedStock);
//	assertEquals(expected+1, ss.getAllStocks().size());
//	assertNotNull(savedStock.getLibelleStock());
//	ss.deleteStock(savedStock);
//	assertTrue(()->stocks.remove(savedStock),"stock have been removed succefully");
//	
//	}
	
	
	/*
	 * @Test public void test() { Date d= new Date("11/02/1995"); Date t= new
	 * Date("11/02/1991"); Client cl = new Client("testdsq","oussama","test",d);
	 * //cr.saveClient(cl); System.out.println(
	 * "**********************************************************************************"
	 * ); System.out.println("CLients :"+cr.getClientByDates()); System.out.println(
	 * "**********************************************************************************"
	 * ); List<Client> clients = cr.getClientByDates();
	 * 
	 * assertTrue(clients.containsAll(clients)
	 * ,"Clients between two dates i ve given"); }
	 */
	
	/*
	 * @Test public void testAddStock() throws ParseException { Stock cs = new
	 * Stock(20,10,"testdsq"); ss.saveStock(cs); }
	 */
	
	@Test 
	public void test() { 
	Date d= new Date("11/02/1995");
	Date t= new Date("11/02/1991");
    Client cl = new Client("testdsq","oussama","test",d); //cr.saveClient(cl);
	System.out.println("**********************************************************************************");
	System.out.println("CLients :"+cr.getClientByDates());
	System.out.println("**********************************************************************************"); 
	List<Client> clients = cr.getClientByDates();
	
	assertTrue(clients.containsAll(clients),"Clients between two dates i ve given");
	}
	 
	
	
	/*
	 * @Test public void testFindAllClient() { List<Client> prods =
	 * cr.getAllClients(); for (Client p:prods) { System.out.println(p); } }
	 */
	/*
	 * @Test public void testupdateClient() { Client c1 = cr.getClient((long) 1);
	 * c1.setNom("gfgf"); cr.updateClient(c1); }
	 * 
	 
	 * 
	 * @Test public void testDeleteClient() { cr.deleteClientById((long) 9); }
	 */
}
