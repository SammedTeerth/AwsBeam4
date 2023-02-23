package com.Banking;

import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		Bank bank = new BankImpl(5000);
		
		while(true)
		{
			System.out.println("1:Deposit Amount\n2:Withdram Amount\n3:Check Balance\n4:Exit");
			System.out.println("Enter choices");
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Amount to be Deposited");
				int amountTodeposit = scan.nextInt();
				bank.deposit(amountTodeposit); //bank.deposit(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter Amount to be Withdrawn");
				int amountTowithdrawn = scan.nextInt();
				bank.withdraw(amountTowithdrawn); //bank.deposit(scan.nextInt());
				break;
				
			case 3:
				System.out.println("Available Balance:"+bank.getbalance());
				break;
				
			case 4:
				System.out.println("Thank You!! Visit Again!");
				System.exit(0);
				default :
					System.out.println("Invalid choices");
			}
			System.out.println("=============");
		}
	}
}
