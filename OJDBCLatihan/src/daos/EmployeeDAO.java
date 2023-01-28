package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idaos.IEmployeeDAO;
import models.Employee;

public class EmployeeDAO implements IEmployeeDAO{
	
	private Connection connection;

	public EmployeeDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> listEmployee = new ArrayList<Employee>();
		String query = "SELECT * FROM HR.EMPLOYEES";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getDate(6), 
						rs.getString(7), rs.getInt(8), rs.getInt(9), 
						rs.getInt(10), rs.getInt(11));
			     emp.setId(rs.getInt(1));
				 emp.setFirst_name(rs.getString(2));
				 emp.setLast_name(rs.getString(3));
				 emp.setEmail(rs.getString(4));
				 emp.setPhone_number(rs.getString(5));
				 emp.setDate(rs.getDate(6));
				 emp.setJob_id(rs.getString(7));
				 emp.setSalary(rs.getInt(8));
				 emp.setCommision_pct(rs.getInt(9));
				 emp.setManager_id(rs.getInt(10));
				 emp.setDepartment_id(rs.getInt(11));
				listEmployee.add(emp);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return listEmployee;
	}

	@Override
	public Employee getById(int id) {
		Employee emp = new Employee();
		emp.setId(id);
		String query = "SELECT * FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = " + id;
		
		try {
			 PreparedStatement ps = connection.prepareStatement(query);
		     ResultSet rs = ps.executeQuery();
		     System.out.println("Execute statement");
		     rs.next();
		     emp.setId(rs.getInt(1));
			 emp.setFirst_name(rs.getString(2));
			 emp.setLast_name(rs.getString(3));
			 emp.setEmail(rs.getString(4));
			 emp.setPhone_number(rs.getString(5));
			 emp.setDate(rs.getDate(6));
			 emp.setJob_id(rs.getString(7));
			 emp.setSalary(rs.getInt(8));
			 emp.setCommision_pct(rs.getInt(9));
			 emp.setManager_id(rs.getInt(10));
			 emp.setDepartment_id(rs.getInt(11));
		     return emp;
		    } 
		 catch (Exception e) {
			 e.getStackTrace();
		    }
		return emp;
	}

	@Override
	public List<Employee> search(String key) {
		List<Employee> listEmployee = new ArrayList<Employee>();
		try {
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM HR.EMPLOYEES WHERE FIRST_NAME LIKE ?");
			 ps.setString(1, "%" + key +"%");
		     ResultSet rs = ps.executeQuery();
		     System.out.println("Execute statement");
		     while (rs.next()) {
		    	 Employee emp = new Employee();
		    	 emp.setId(rs.getInt(1));
		    	 emp.setFirst_name(rs.getString(2));
				 emp.setLast_name(rs.getString(3));
				 emp.setEmail(rs.getString(4));
				 emp.setPhone_number(rs.getString(5));
				 emp.setDate(rs.getDate(6));
				 emp.setJob_id(rs.getString(7));
				 emp.setSalary(rs.getInt(8));
				 emp.setCommision_pct(rs.getInt(9));
				 emp.setManager_id(rs.getInt(10));
				 emp.setDepartment_id(rs.getInt(11));
		    	 listEmployee.add(emp);
		    	}
		    } 
		 catch (Exception e) {
			 e.getStackTrace();
		    }
		return listEmployee;
	}

	@Override
	public Employee insert(Employee employee) {
		String query = "INSERT INTO HR.EMPLOYEES(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getFirst_name());
			ps.setString(3, employee.getLast_name());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPhone_number());
			ps.setObject(6, employee.getDate());
			ps.setString(7, employee.getJob_id());
			ps.setInt(8, employee.getSalary());
			ps.setFloat(9, employee.getCommision_pct());
			ps.setInt(10, employee.getManager_id());
			ps.setInt(11, employee.getDepartment_id());
			ps.executeQuery();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		String query = "UPDATE HR.EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, HIRE_DATE = ?, JOB_ID = ?, COMMISSION_PCT = ?, MANAGER_ID = ?, DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getFirst_name());
			ps.setString(3, employee.getLast_name());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPhone_number());
			ps.setObject(6, employee.getDate());
			ps.setString(7, employee.getJob_id());
			ps.setInt(8, employee.getSalary());
			ps.setFloat(9, employee.getCommision_pct());
			ps.setInt(10, employee.getManager_id());
			ps.setInt(11, employee.getDepartment_id());
			ps.executeQuery();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return employee;
	}

	@Override
	public void delete(double id) {
		String query = "DELETE FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, id);
			preparedStatement.executeQuery();
		} 
		catch (SQLException e) {
			e.getStackTrace();
		}
		return;
	}

}
