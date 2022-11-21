package org.tnsindia.joinedinheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//driver class
public class JoinedInheritanceDemo {

	public static void main(String[] args) {
		EntityManagerFactory f=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=f.createEntityManager();
		em.getTransaction().begin();
		
		//create a sales
		Sales s=new Sales();
		s.setSales_id(14);
		s.setPrice(5000.90);
		em.persist(s);
		

		Sales s1=new Sales();
		s1.setSales_id(19);
		s1.setPrice(3300.20);
		em.persist(s1);
		
		//create a dept
		
		SalesDepartment d=new SalesDepartment();
		d.setSales_id(31);
		d.setPrice(6578.40);
		d.setDept_id(123);
		d.setDept_name("Cosmetics");
		em.persist(d);
		
		em.getTransaction().commit();
		System.out.println("The data is added");
		em.close();
		f.close();
		
     
	}

}
