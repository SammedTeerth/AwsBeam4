package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;



public class Solution {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to Employee database Management System");
		System.out.println("===================================");

		Scanner scan =new Scanner(System.in);
		EmployeeManagementSystem sms = new EmployeeManagementSystemImpl();

		while(true) 
		{

			System.out.println("1:AddEmployee\n2:DisplayEmployee\n3:DisplayAllEmployee");
			System.out.println("4:removeEmployee\n5:removeAllEmployee\n6:updateEmployee");
			System.out.println("7:countEmployee\n8:sortEmployee\n9:getEmployeeWithHighestSalary");
			System.out.println("10:getEmployeeWithLowestSalary");
			System.out.println("Enter Choices");
			int choice = scan.nextInt(); 
			switch(choice) {
			case 1:
				sms.addEmployee();
				break;
			case 2:
				sms.displayEmployee();
				break;
			case 3:
				sms.displayAllEmployee();
				break;
			case 4:
				sms.removeEmployee();
				break;
			case 5:
				sms.removeAllEmployee();
				break;
			case 6:
				sms.updateEmployee();
				break;
			case 7:
				sms.countEmployee();
				break;
			case 8:
				sms.sortEmployee();
				break;
			case 9:
				sms.getEmployeeWithHighestSalary();
				break;
			case 10:
				sms.getEmployeeWithLowestSalary();
				break;
			case 11:
				System.out.println("");

				break;
			default :
				try {
					throw new InvalidChoiceException("Invalid Choice, Kindly Try Again");

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}

}
