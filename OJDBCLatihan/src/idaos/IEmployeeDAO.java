package idaos;

import java.util.List;

import models.Employee;

public interface IEmployeeDAO {
	public List<Employee> getAll();
	
	public Employee getById(int id);
	
	public List<Employee> search(String key);
	
	public Employee insert(Employee employee);
	
	public Employee update(Employee employee);
	
	public void delete(double id);
}
