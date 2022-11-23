package org.tnsindia.manytomanybidirectional;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em= f.createEntityManager();
		em.getTransaction().begin();
		
		//create a product1;
		Product elecProduct=new Product();
		elecProduct.setId(1);
		elecProduct.setName("LED TV");
		elecProduct.setPrice(55000);
		
		//create a product2;
		Product beautyProduct=new Product();
		beautyProduct.setId(2);
		beautyProduct.setName("Foundation");
		beautyProduct.setPrice(200);
		

		//create a product3;
		Product babyProduct=new Product();
		babyProduct.setId(3);
		babyProduct.setName("Pampers");
		babyProduct.setPrice(54);
		
		//create a product3;
		Product eleProduct=new Product();
		eleProduct.setId(4);
		eleProduct.setName("CFL Bulb");
		eleProduct.setPrice(250);
		
		//create orders 1;
		Order firstOrder=new Order();
		firstOrder.setId(8945);
		firstOrder.setPurchaseDate(new Date());
		
		firstOrder.addProduct(babyProduct);
		firstOrder.addProduct(elecProduct);
		firstOrder.addProduct(beautyProduct);
		
		//create order 2;
		Order secondOrder=new Order();
		secondOrder.setId(8946);
		secondOrder.setPurchaseDate(new Date());
		
		secondOrder.addProduct(babyProduct);	
		secondOrder.addProduct(elecProduct);
		secondOrder.addProduct(eleProduct);	
		
		em.persist(firstOrder);
		em.persist(secondOrder);
		
		System.out.println("Added orders along with order details to database.");
		
		em.getTransaction().commit();
		em.close();
		f.close();
		
	}
}
