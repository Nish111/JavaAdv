package com.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.to.Employee;

public class EmployeeDAO {
	private DataSource datasource;
	private JdbcTemplate jdbctemplate;
	private PlatformTransactionManager platformTransactionManager;
	
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
		jdbctemplate = new JdbcTemplate(this.datasource);
	}
	
	public int addEmployee(Employee e) {
		int count = 0;
		String query="insert into employee values(?,?,?,?)";
		count=jdbctemplate.update(query, e.getEid(), e.getAge(), e.getEname(), e.getPassword());
		return count;
	}
	
	public List<Employee> getAllEmployees(){
		String sql="select * from employee";
		@SuppressWarnings("unchecked")
		List<Employee> listemp=jdbctemplate.query(sql, new EmployeeMapper());
		return listemp;
	}
	
	public List<Employee> getAllEmployeesOnAge(int age){
		String sql="select * from employee where age=?";
		@SuppressWarnings("unchecked")
		List<Employee> listemp=jdbctemplate.query(sql, new EmployeeMapper(), age);
		return listemp;
	}
	public void PerformMultipleActions(Employee e) {
		
		System.out.println();
		System.out.println("Performing Multiple Actions");
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = platformTransactionManager.getTransaction(td);
		try {
			String query = "insert into employee values(?,?,?,?)";
			int count=jdbctemplate.update(query, e.getEid(), e.getAge(), e.getEname(),e.getPassword());
			System.out.println(count +" Records inserted ");
			
			String sql="select * from employee where Age=(select max(Age) from employee)";
			List<Employee> a=jdbctemplate.query(sql, new EmployeeMapper());
			System.out.println("max age = " + a);
			platformTransactionManager.commit(ts);
			
		} catch(Exception ex) {
			System.out.print("Transaction failed " + ex);
			platformTransactionManager.rollback(ts);
		}
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}
}
