package controllers;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import models.Employee;

public class EmployeeController implements IEmployeeController{
	
	private IEmployeeDAO iedao;

	public EmployeeController(Connection connection) {
		iedao = new EmployeeDAO(connection);
	}

	@Override
	public List<Employee> getAll() {
		return iedao.getAll();
	}

	@Override
	public Employee getById(String id) {
		return iedao.getById(Integer.parseInt(id));
	}

	@Override
	public List<Employee> search(String key) {
		return iedao.search(key);
	}

	@Override
	public String insert(String id, String first_name, String last_name, 
			String email, String phone_number, Date hire_date,
			String job_id, String salary, String commision_pct, 
			String manager_id, String department_id) {
		
		String result = "";
		Employee employee = new Employee(Integer.parseInt(id), first_name, 
				last_name, email, phone_number, hire_date, job_id,
				Integer.parseInt(salary), Integer.parseInt(commision_pct),
				Integer.parseInt(manager_id), Integer.parseInt(department_id));
		
		try {
			iedao.insert(employee);
			result = "Employee Data Successfully Inserted!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Employee Data Insert Failed!";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public String update(String id, String first_name, String last_name, 
			String email, String phone_number, Date hire_date,
			String job_id, String salary, String commision_pct, 
			String manager_id, String department_id) {
		String result = "";
		Employee employee = new Employee(Integer.parseInt(id), first_name, 
				last_name, email, phone_number, hire_date, job_id,
				Integer.parseInt(salary), Integer.parseInt(commision_pct),
				Integer.parseInt(manager_id), Integer.parseInt(department_id));
		
		try {
			iedao.update(employee);
			result = "Employee Data Successfully Updated!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Employee Data Update Failed!";
		}
		System.out.println(result);
		return result;
	}
	
	@Override
	public void delete(String id) {
		String result = "";
		
		try {
			iedao.delete(Double.parseDouble(id));
			result = "Employee Data Successfully Deleted!";
		}
		catch (Exception e) {
			e.getStackTrace();
			result = "Employee Data Delete Failed!";
		}
		System.out.println(result);
		
		return;
	}

}
