package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import CustomSorting.SortStudentByAge;
import CustomSorting.SortStudentById;
import CustomSorting.SortStudentByMarks;
import CustomSorting.SortStudentByName;
import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem
{
	Scanner scan = new Scanner(System.in);
	Map<String,Student> db = new LinkedHashMap<String,Student>();
	private int choice;


	@Override
	public void addStudent() 
	{
		System.out.println("Enter Student Age");
		int age = scan.nextInt();
		System.out.println("Enter Student Name");
		String name = scan.next();
		System.out.println("Enter Student Marks");
		int marks = scan.nextInt();

		Student std = new Student(age, name, marks);
		db.put(std.getId(),std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is"+std.getId());


	}

	@Override
	public void displayStudent()
	{  
		System.out.println("Enter Student Id:");
		String id = scan.next();
		if(db.containsKey(id))
		{
			Student std = db.get(id);
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
			// System.out.println(std); as

		}
		else 
		{
			try 
			{
				String message = "Student with the Id"+id+"is Not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllStudent() 
	{
		if(db.size()!=0) {
			System.out.println("Student Details as Follows");
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
				String message ="Student Database Is Empty, Nothing To Display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() 
	{
		System.out.println("Enter Student Id:");
		String id = scan.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student Record Found!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}
		else {
			try {
				String message ="Student with the Id" +id+"is not found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudent() 
	{
		if(db.size()!=0) {
			System.out.println("Student Records Available: "+db.size());
			db.clear();
			System.out.println("All Student Records are Deleted Successfully! ");
			System.out.println("Student Records Available: "+db.size());
		}
		else 
		{
			try
			{
				String message = "Student Database is Empty, Nothing to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() 
	{
		System.out.println("Enter Student Id:");
		String id = scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std = db.get(id);

			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age: ");
				int age = scan.nextInt();
				std.setAge(age); // std.setAge(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter Name: ");
				String name = scan.next();
				std.setName(name); // std.setName(scan.next());
				break;
			case 3:
				System.out.println("Enter Marks: ");
				int marks = scan.nextInt();
				std.setMarks(marks); // std.setMarks(scan.nextInt());
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
				String message = "Student with the Id"+id+"is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() 
	{
		System.out.println("No of Student Records: "+db.size());
	}

	@Override
	public void sortStudent() 
	{
		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key: keys) {
			list.add(db.get(key));
		}
		System.out.println("1:sort By Id\n2: Sort By Age");
		System.out.println("3:Sort By Name\n4: Sort By Marks");
		System.out.println("Enter Choice:");

		switch(choice) 
		{
		case 1:
			Collections.sort(list, new SortStudentById());
			display(list);
			break;
		case 2:
			Collections.sort(list, new SortStudentByAge());
			display(list);
			break;
		case 3:
			Collections.sort(list, new SortStudentByMarks());
			display(list);
			break;
		case 4:
			Collections.sort(list, new SortStudentByName());
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

	// for avoiding multiple for each loop we use this method 

	private static void display(List<Student> list) {
		for(Student s: list) {
			System.out.println(s);
		}
	}


	@Override
	public void getStudentWithHighestMarks() 
	{
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Student> list  = new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(key));

			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(list.size()-1)); //getting student object
		}
		else {
			try {
				String message = "No Sufficient Student Records to Compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithLowestMarks() 
	{
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Student> list  = new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(key));

			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));  //getting student object

		}
		else {
			try {
				String message = "No Sufficient Student Records to Compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
