package org.tnsindia.onetooneunidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneUnidirectionalDemo {

	public static void main(String[] args) {
		EntityManagerFactory f=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=f.createEntityManager();
		em.getTransaction().begin();
		
		  //student1 created
		   Student s=new Student();
		   s.setID(2001);
           s.setNAME("Renuka");	
        
            //student2  created
      		Student s1=new Student();
      		s1.setID(2002);
            s1.setNAME("Anjali");
              
		//adddress1 created
		Address a=new Address();
		a.setStreetNo(122);
		a.setArea("MG Road");
		a.setCity("Pune");
		
        //address2 created
    	Address a1=new Address();
		a1.setStreetNo(130);
		a1.setArea("Shivshakti Nagar");
		a1.setCity("Mumbai");
		
		//inject address into student1
		s.setAddress(a);
		em.persist(s);
		

		//inject address into student2
		s1.setAddress(a1);
		em.persist(s1);
		
		em.getTransaction().commit();
		System.out.println("The data is added");
		em.close();
		f.close();
		
	}

}
