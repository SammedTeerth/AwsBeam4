package edbms;

public class Employee 
{
	private String id;
	private int age;
	private String name;
	private double salary;
	
	private static int count = 101;
	
	public Employee(int age, String name, double salary) {
		super();
		this.id = "JSP"+count;
		this.age = age;
		this.name = name;
		this.salary = salary;
		count++;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getname() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getsalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "id: "+id+" Age"+age+" Name:"+name+" Salary:"+salary;
	}
	
	
	

}
