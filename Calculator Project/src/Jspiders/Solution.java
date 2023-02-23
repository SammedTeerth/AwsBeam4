package Jspiders;

abstract class Person
{
	abstract void eat();
}
class Jerry extends Person
{
	@Override        // --> annotation Override
	void eat() {
	System.out.println("Eating Fizza");
}
}
public class Solution {
	public static void main(String[] args)
	{
		Jerry jerry = new Jerry();
		jerry.eat();
		
	}
}

// Contract of Abstract --> Rules:
//1. make the class as abstract
//2. Override the abstract method

// Definition
// Abstract class--> class which declared using abstract class and abstract class has both abstract and concrete methods.

