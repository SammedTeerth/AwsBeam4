package Jspiders;

import java.util.Scanner;

public class Solutions {


	public static void main(String[] args) 
	{	
		// menu driven program
		Scanner scan = new Scanner(System.in);

		//up casting --> abstraction
		Calculator calc = new Calculatorimpl();  //  remove impl


		while(true) {
			System.out.println("1:Addition\n2:Substraction\n3:Multiplication");
			System.out.println("4:Division\n5:Exit\n enter choices");
			int choice = scan.nextInt();

			int a=0;
			int b=0;
			if(choice>=1 && choice<=4) {
				System.out.println("enter 2 nos");
				a = scan.nextInt();
				b = scan.nextInt();
			}

			switch(choice)
			{
			case 1:
				System.out.println("sum of "+a+"&"+b+"is"+calc.add(a, b));
				break;
			case 2:
				System.out.println("difference of "+a+" & " +b+ " is"+calc.sub(a, b));
				break;
			case 3:
				System.out.println("Product of "+a+" & " +b+ " is"+calc.mul(a, b));
				break;
			case 4:
				int res=calc.div(a, b);	
				if(res!=0) {				
					System.out.println("dividion of "+a+" & " +b+ " is"+res);
				}
				else 
				{
					System.out.println("not divided by 0");
				}
				break;

			case 5:
				System.out.println("Thank You!!");
				System.exit(0); 
			default:
				System.out.println("invalid");
			}
		}
	}
}
