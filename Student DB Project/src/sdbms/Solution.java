package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution 
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Student Database Management System");
		System.out.println("------------------------------");
		Scanner scan = new Scanner(System.in);
		StudentManagementSystem sms = new StudentManagementSystemImpl();

		while(true) 
		{
			System.out.println("1:Add Student\n2:Display Student");
			System.out.println("3:DisplayAll Student\n4:Remove Student");
			System.out.println("5:RemoveAll Student\n6:Update Student");
			System.out.println("7:Count Student\n8:Sort Student");
			System.out.println("9:Get Student with highest marks");
			System.out.println("10:Get Student with Lowest marks");
			System.out.println("11:Exit\n Enter Choice");
			int choice = scan.nextInt();

			switch(choice) 
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You!");
				System.exit(0);

			default:
				try {
					String msg= "Invalid Choice,Kindly enter valid choice!";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				


			} // end of switch
			System.out.println("=================");


		} //end of while 

	}
}
