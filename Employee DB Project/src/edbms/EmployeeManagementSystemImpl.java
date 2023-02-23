package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeById;
import customsorting.SortEmployeeByName;
import customsorting.SortEmployeeBySalary;



public class EmployeeManagementSystemImpl implements EmployeeManagementSystem
{
	Scanner scan = new Scanner(System.in);
	Map<String,Employee> db = new LinkedHashMap<String,Employee>();
	private int choice;


	@Override
	public void addEmployee()
	{
		System.out.println("Enter Employee Age");
		int age = scan.nextInt();
		System.out.println("Enter Employee Name");
		String name = scan.next();
		System.out.println("Enter Employee salary");
		int salary = scan.nextInt();

		Employee std = new Employee(age, name, salary);
		db.put(std.getId(),std);
		System.out.println("Employee Record Inserted Successfully");
		System.out.println("Employee Id is "+std.getId());
	}
	@Override
	public void displayEmployee()
	{
		System.out.println("Enter Employee Id:");
		String id = scan.next().toUpperCase();
		
		if(db.containsKey(id))
		{
			Employee emp = db.get(id);
			System.out.println("Id: "+emp.getId());
			System.out.println("Age: "+emp.getAge());
			System.out.println("Name: "+emp.getname());
			System.out.println("Salary: "+emp.getsalary());
		}
		else {
			try {
				String message= "Employee with id:"+id+" is Not found";
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
				
			}
		}
		@Override
		public void displayAllEmployee()
		{
			if(db.size()!=0) {
				System.out.println("Employee Details as Follows");
				System.out.println("==================");
				Set<String> keys = db.keySet(); //JSP101 ,JSP103
				for(String key:keys)
				{
					System.out.println(db.get(key));
				}
			}
			else
			{
				try {
					String message ="Employee Database Is Empty, Nothing To Display";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		@Override
		public void removeEmployee()
		{

			System.out.println("Enter Employee Id:");
			String id = scan.next().toUpperCase();

			if(db.containsKey(id)) {
				System.out.println("Employee Record Found!");
				System.out.println(db.get(id));
				db.remove(id);
				System.out.println("Employee Record Deleted Successfully");
			}
			else {
				try {
					String message ="Employee with the Id" +id+"is not found!";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		@Override
		public void removeAllEmployee()
		{
			if(db.size()!=0) {
				System.out.println("Employee Records Available: "+db.size());
				db.clear();
				System.out.println("All Employee Records are Deleted Successfully! ");
				System.out.println("Employee Records Available: "+db.size());
			}
			else 
			{
				try
				{
					String message = "Employee Database is Empty, Nothing to Delete";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}

		}
		@Override
		public void updateEmployee()
		{
			System.out.println("Enter Employee Id:");
			String id = scan.next().toUpperCase();
			if(db.containsKey(id)) {
				Employee emp = db.get(id);

				System.out.println("1:Update Age\n2:Update Name\n3:Update Salary");
				System.out.println("Enter Choice");
				int choice = scan.nextInt();

				switch(choice) {
				case 1:
					System.out.println("Enter Age: ");
					int age = scan.nextInt();
					emp.setAge(age); // std.setAge(scan.nextInt());
					break;
				case 2:
					System.out.println("Enter Name: ");
					String name = scan.next();
					emp.setName(name); // std.setName(scan.next());
					break;
				case 3:
					System.out.println("Enter Marks: ");
					int salary = scan.nextInt();
					emp.setsalary(salary); // std.setMarks(scan.nextInt());
					break;
				default:
					try {
						String msg = "Invalid Choice, Kindly enter valid choice";
						throw new InvalidChoiceException(msg);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
			else {
				try {
					String message = "Employee with the Id"+id+"is not found";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		@Override
		public void countEmployee()
		{
			System.out.println("No of Employee Records: "+db.size());

		}
		@Override
		public void sortEmployee()
		{
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for(String key: keys) {
				list.add(db.get(key));
			}
			System.out.println("1:sort By Id\n2: Sort By Age");
			System.out.println("3:Sort By Name\n4: Sort By Salary");
			System.out.println("Enter Choice:");

			switch(choice) 
			{
			case 1:
				Collections.sort(list, new SortEmployeeById());
				display(list);
				break;
			case 2:
				Collections.sort(list, new SortEmployeeByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list, new SortEmployeeByName());
				display(list);
				break;
			case 4:
				Collections.sort(list, new SortEmployeeBySalary());
				display(list);
				break;
			default:
				try {
					String msg = "Invalid Choice, Kindly enter valid choice";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		private void display(List<Employee> list) {
			
		}
		@Override
		public void getEmployeeWithHighestSalary()
		{
			if(db.size()>=2) {
				Set<String> keys = db.keySet();
				List<Employee> list  = new ArrayList<Employee>();
				for(String key : keys) {
					list.add(db.get(key));

				}
				Collections.sort(list,new SortEmployeeBySalary());
				System.out.println(list.get(list.size()-1)); //getting employee object
			}
			else {
				try {
					String message = "No Sufficient Employee Records to Compare";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		@Override
		public void getEmployeeWithLowestSalary()
		{
			if(db.size()>=2) {
				Set<String> keys = db.keySet();
				List<Employee> list  = new ArrayList<Employee>();
				for(String key : keys) {
					list.add(db.get(key));

				}
				Collections.sort(list,new SortEmployeeBySalary());
				System.out.println(list.get(0));  //getting employee object

			}
			else {
				try {
					String message = "No Sufficient Employee Records to Compare";
					throw new EmployeeNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}


	}
