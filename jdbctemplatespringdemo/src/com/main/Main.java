package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDAO;
import com.to.Employee;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO dao = (EmployeeDAO) ap.getBean("edao");
		
		
		/*
		 * Employee e1 = new Employee();
		 * e1.setEid(103); e1.setAge(30); e1.setEname("Loid");
		 * 
		 * e1.setPassword("anya");
		 * 
		 * int count = dao.addEmployee(e1);
		 */
		/*
		 * Employee e2 = new Employee(); e2.setEid(104); e2.setAge(26);
		 * e2.setEname("Yor");
		 * 
		 * e2.setPassword("yuri");
		 * 
		 * int count = dao.addEmployee(e2); System.out.println(count +
		 * " records added");
		 */
		/*
		 * Employee e3 = new Employee(); e3.setEid(105); e3.setAge(68);
		 * e3.setEname("Henderson"); e3.setPassword("Eden"); int count =
		 * dao.addEmployee(e3); System.out.println(count + " records added");
		 */
		
		List<Employee> list = dao.getAllEmployees();
		for(Employee employee : list) {
			System.out.println(employee);
		}
		
		Employee e4 = new Employee();
		e4.setEid(106); 
		e4.setAge(10); 
		e4.setEname("Bond");
		e4.setPassword("Eden");
		
		dao.PerformMultipleActions(e4);
		
		list = dao.getAllEmployees();
		for(Employee employee : list) {
			System.out.println(employee);
		}
		
	}

}
