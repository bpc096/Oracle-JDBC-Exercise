package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controllers.CountriesController;
import controllers.EmployeeController;
import controllers.RegionController;
import models.Countries;
import models.Employee;
import models.Region;

public class ManualTest {
	
	static DBConnection connection = new DBConnection();
	static Scanner input = new Scanner(System.in);
	static int option = 0;

	public ManualTest() {

	}
	
	public static void cls() {
		for(int i=0; i<24; i++) {
			System.out.println();
		}
	}
	
	private static void menu_countries() {
		CountriesController ccon = new CountriesController(connection.getConnection());
		do {
			System.out.println("- COUNTRIES TABLE -");
			System.out.println("=====================");
			System.out.println("1. Display All Countries");
			System.out.println("2. Display Country By ID");
			System.out.println("3. Insert New Country");
			System.out.println("4. Update Country");
			System.out.println("5. Delete Country");
			System.out.println("6. Search for Country");
			System.out.println("7. Back to Main Menu");
			System.out.print("Enter your selection : ");
			option = input.nextInt();
			switch (option) {
			case 1:
				List<Countries> cos = ccon.getAll();     		
        		for(Countries co : cos) {
        			co.display();
        		}
				break;
			case 2:
				System.out.print("What is the Country ID you want to display ? ");
                String countryId = input.next();
                ccon.getById(countryId).display();
				break;
			case 3:
				System.out.print("What is the new Country ID? ");
                String countries_id = input.next();
                System.out.print("What is the new Country Name ? ");
                String countries_name = input.next();      
                System.out.print("What is the new Country ID? ");
                String reg_id = input.next();
                ccon.insert(countries_id, countries_name, reg_id);
				break;
			case 4:
				System.out.print("What is the new Country ID? ");
                String countries_id2 = input.next();
                System.out.print("What is the new Country Name ? ");
                String countries_name2 = input.next();      
                System.out.print("What is the new Country ID? ");
                String reg_id2 = input.next();      		
                ccon.update(countries_id2, countries_name2, reg_id2);
				break;
			case 5:
				System.out.print("What is the Country ID you want to delete ? ");
                String countryID = input.next();
                ccon.delete(countryID);
				break;
			case 6:
				System.out.print("What is the Country Name you want to search ? ");
                String countryName = input.next();
                List<Countries> cos2 = ccon.search(countryName);     		
        		for(Countries cons : cos2) {
        			cons.display();
        		}
				break;
			case 7:
				main_menu();
				break;
			}
		} while (option != 7);
		
	}
	
	private static void menu_regions() {
		RegionController rcon = new RegionController(connection.getConnection()); 
		do {
			System.out.println("- REGIONS TABLE -");
			System.out.println("=====================");
			System.out.println("1. Display All Regions");
			System.out.println("2. Display Region By ID");
			System.out.println("3. Insert New Region");
			System.out.println("4. Update Region");
			System.out.println("5. Delete Region");
			System.out.println("6. Search for Region");
			System.out.println("7. Back to Main Menu");
			System.out.print("Enter your selection : ");
			option = input.nextInt();
			switch (option) {
			case 1:
				List<Region> regs = rcon.getAll();     		
        		for(Region emp : regs) {
        			emp.display();
        		}
				break;
			case 2:
				System.out.print("What is the Region ID Number you want to display ? ");
                String regionId = input.next();
        		rcon.getById(regionId).display();
				break;
			case 3:
				System.out.print("What is the new Region ID number? ");
                String reg_id = input.next();
                System.out.print("What is the new Region Name ? ");
                String reg_name = input.next();      		
        		rcon.insert(reg_id, reg_name);
				break;
			case 4:
				System.out.print("What is the new Region ID number? ");
                String reg_id2 = input.next();
                System.out.print("What is the new Region Name ? ");
                String reg_name2 = input.next();       		
        		rcon.update(reg_id2, reg_name2);
				break;
			case 5:
				System.out.print("What is the Region ID number you want to delete ? ");
                String regionID = input.next();
                rcon.delete(regionID);
				break;
			case 6:
				System.out.print("What is the Region Name you want to search ? ");
                String regionName = input.next();
                List<Region> regs2 = rcon.search(regionName);     		
        		for(Region reg : regs2) {
        			reg.display();
        		}
				break;
			case 7:
				main_menu();
				break;
			}
		} while (option != 7);
	}
	
	private static void menu_employees() throws ParseException
    {
		EmployeeController econ = new EmployeeController(connection.getConnection());
        do {
			System.out.println("- EMPLOYEES TABLE -");
			System.out.println("=====================");
			System.out.println("1. Display All Employee");
			System.out.println("2. Display Employee By ID");
			System.out.println("3. Insert New Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Search for Employee");
			System.out.println("7. Back to Main Menu");
			System.out.print("Enter your selection : ");		
			option = input.nextInt();
			switch (option) {
				case 1:
					List<Employee> emps = econ.getAll();     		
	        		for(Employee emp : emps) {
	        			emp.display();
	        		}
					break;
				case 2:
					System.out.print("What is the Employee ID Number ? ");
	                String empId = input.next();
	        		Employee empsByID = econ.getById(empId);     		
	        		empsByID.display();
					break;
				case 3:
					System.out.print("Employee ID Number: ");
	        		String idNumber = input.next();
	         
	        		System.out.print("Employee First Name: ");
	        		String first_name = input.next();
	         
	        		System.out.print("Employee Last Name: ");
	        		String last_name = input.next();
	        		input.nextLine();
	        		
	        		System.out.print("Employee Email: ");
	        		String email = input.next();
	        		
	        		System.out.print("Employee Phone Number: ");
	        		String phone_number = input.next();
	        		
	        		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        		Date date = new Date();
	        		formatter.format(date);
	        		
	        		System.out.print("Employee Job ID: ");
	        		String job_id = input.next();
	        		
	        		System.out.print("Employee Salary: ");
	        		String salary = input.next();
	        		
	        		System.out.print("Employee Commission PCT: ");
	        		String commision_pct = input.next();
	        		
	        		System.out.print("Employee Manager ID: ");
	        		String manager_id = input.next();
	        		
	        		System.out.print("Employee Department ID: ");
	        		String department_id = input.next();
	         
	        		econ.insert(idNumber, first_name, last_name, email, phone_number, 
	        				date, job_id, salary, commision_pct, 
	        				manager_id, department_id);
					break;
				case 4:
					System.out.print("Employee ID Number: ");
	        		String idNumber2 = input.next();
	         
	        		System.out.print("Employee First Name: ");
	        		String first_name2 = input.next();
	         
	        		System.out.print("Employee Last Name: ");
	        		String last_name2 = input.next();
	        		input.nextLine();
	        		
	        		System.out.print("Employee Email: ");
	        		String email2 = input.next();
	        		
	        		System.out.print("Employee Phone Number: ");
	        		String phone_number2 = input.next();
	        		
	        		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        		Date date2 = new Date();
	        		formatter2.format(date2);
	        		
	        		System.out.print("Employee Job ID: ");
	        		String job_id2 = input.next();
	        		
	        		System.out.print("Employee Salary: ");
	        		String salary2 = input.next();
	        		
	        		System.out.print("Employee Commission PCT: ");
	        		String commision_pct2 = input.next();
	        		
	        		System.out.print("Employee Manager ID: ");
	        		String manager_id2 = input.next();
	        		
	        		System.out.print("Employee Department ID: ");
	        		String department_id2 = input.next();
	         
	        		econ.update(idNumber2, first_name2, last_name2, email2, phone_number2, 
	        				date2, job_id2, salary2, commision_pct2, 
	        				manager_id2, department_id2);
					break;
				case 5:
					System.out.print("What is the Employee ID number you want to delete ? ");
	                String empID = input.next();
	                econ.delete(empID);
					break;
				case 6:
					System.out.print("What is the Employee Name you want to search ? ");
	                String empName = input.next();
	                List<Employee> emps2 = econ.search(empName);     		
	        		for(Employee emp : emps2) {
	        			emp.display();
	        		}
					break;
				case 7:
					main_menu();
					break;
			}
		} while (option != 7);
    }	
	
	private static void main_menu() {
		System.out.println("- WELCOME TO HR MENU -");
        System.out.println("======================");
        System.out.println("1. EMPLOYEES");
        System.out.println("2. REGIONS");
        System.out.println("3. COUNTRIES");
        System.out.println("4. DEPARTMENTS");
        System.out.println("5. JOB HISTORY");
        System.out.println("6. JOBS");
        System.out.println("7. LOCATIONS");
        System.out.println("8. Exit");
        System.out.print("Enter your selection : ");
	}
	
	public static void main(String[] args) throws ParseException {				    		
		do {
            main_menu();
            option = input.nextInt();
            switch (option) {        
            // Case 1 - EMPLOYEES TABLE
            case 1:
        		menu_employees();
				break;
                
            // Case 2 - REGIONS TABLE
            case 2:
            	menu_regions();
                break;
 
            // Case 3 - COUNTRIES TABLE
            case 3: 
            	menu_countries();
                break;
 
            // Case 4 - DEPARTMENTS TABLE
            case 4:
       
                break;
 
            // Case 5 - JOB HISTORY TABLE
            case 5:    
            	
                break;
 
            // Case 6 - JOBS TABLE
            case 6:
  
                break;
                
            // Case 7 - LOCATIONS TABLE
            case 7:
 
                break;
            // Case 8 - Exit
            case 8:
            	System.out.println("\nThank you for using this program. "
                		+ "Good Bye!\n");
                System.exit(0);    		
                break;
                
            default:
                System.out.println("\nInvalid input\n");
                break;
            }
        }
        while (option != 8);
	}


}
