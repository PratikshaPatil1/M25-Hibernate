package org.tnsindia.tableperclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//driver class
public class TablePerClassInheritance {

	public static void main(String[] args) {
	       EntityManagerFactory f=Persistence.createEntityManagerFactory("JPA-PU");
	       EntityManager em=f.createEntityManager();
	       em.getTransaction().begin();
        
        //create a vehicle
        
        Vehicle v=new Vehicle();
        v.setVehicle_no(5346);
        v.setVahicle_name("BMW");
        v.setVehicle_type("Four wheeler");
        em.persist(v);
        
       //create a vehicle
        
        Vehicle v1=new Vehicle();
        v1.setVehicle_no(5347);
        v1.setVahicle_name("Mercedes");
        v1.setVehicle_type("Four wheeler");
        em.persist(v1);
        
        //create a car
        Car c=new Car();
        c.setVehicle_no(5666);
        c.setVahicle_name("Audi");
        c.setVehicle_type("Four wheeler");
        c.setPrice(560000);
        em.persist(c);
        
        em.getTransaction().commit();
        System.out.println("The data is added");
        em.close();
        f.close();
	}

}
