package Jspiders;
class Javabean
{
	private int age;
	private String name;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	
}
public class Student {
	
	public static void main(String[] args) {
		Javabean j = new Javabean();
		j.setAge(25);
		j.setName("Sam");
		
		int age = j.getAge();
		System.out.println("Age: "+age);
		System.out.println("Name: "+j.getName());

	}

}
