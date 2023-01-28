package icontrollers;

import java.util.Date;
import java.util.List;

import models.Employee;

public interface IEmployeeController {
	public List<Employee> getAll();
	
	public Employee getById(String id);
	
	public List<Employee> search(String key);
	
	public String insert(String id, String first_name, String last_name, 
			String email, String phone_number, Date hire_date,
			String job_id, String salary, String commision_pct, 
			String manager_id, String department_id);
	
	public String update(String id, String first_name, String last_name, 
			String email, String phone_number, Date hire_date,
			String job_id, String salary, String commision_pct, 
			String manager_id, String department_id);
	
	public void delete(String id);

}
