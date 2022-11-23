package org.tnsindia.bidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BidirectionalDemo {

	public static void main(String[] args) {
		EntityManagerFactory f=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=f.createEntityManager();
		em.getTransaction().begin();
		
		//create a dept1;
		
		Department department=new Department();
		department.setId(1601);
		department.setName("HR");
		
	    //create a dept2;
		
		Department department1=new Department();
		department1.setId(1602);
		department1.setName("Marketing");
		
		//create emp1;
		
		Employee emp=new Employee();
		emp.setEmp_id(991);
		emp.setEmp_name("Priya");
		emp.setSalary(54890);
		
         //create emp2;
		
		Employee emp1=new Employee();
		emp1.setEmp_id(992);
		emp1.setEmp_name("Maisha");
		emp1.setSalary(45000);
		
		emp.setDepartment(department);
		em.persist(emp);
		
		emp1.setDepartment(department1);
		em.persist(emp1);
		
		em.getTransaction().commit();
		System.out.println("The data is added");
		em.close();
		f.close();
		
				
		
		
	}

}
