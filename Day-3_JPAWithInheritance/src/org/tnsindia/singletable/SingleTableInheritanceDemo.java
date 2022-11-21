package org.tnsindia.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleTableInheritanceDemo {

	public static void main(String[] args) {
              EntityManagerFactory f=Persistence.createEntityManagerFactory("JPA-PU");
              EntityManager em=f.createEntityManager();
              em.getTransaction().begin();
              
              //Create an emp1
              Employee e=new Employee();
              e.setEmpID(21);
              e.setName("Pratiksha");
              e.setSalary(25000.33);
              em.persist(e);
              
              //Create an emp2
              Employee e1=new Employee();
              e1.setEmpID(22);
              e1.setName("Gargi");
              e1.setSalary(35000.78);
              em.persist(e1);
              
              //create a manager
              Manager m=new Manager();
              m.setEmpID(23);
              m.setName("Megha");
              m.setSalary(45000.98);
              m.setDeptname("HR");
              em.persist(m);
              
              em.getTransaction().commit();
              System.out.println("The data is added");
              em.close();
              f.close();
	}

}
