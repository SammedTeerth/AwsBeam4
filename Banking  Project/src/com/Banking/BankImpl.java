package com.Banking;

public class BankImpl implements Bank 
{
	int balance;

	BankImpl(int balance)
	{
		this.balance=balance;

	}
	@Override
	public void deposit(int amount) 
	{
		System.out.println("Depositing Rs."+amount);
		balance=balance+amount;    // balance+=amount;
		System.out.println("bal");	
	}
	@Override
	public void withdraw(int amount) 
	{
		if(amount<=balance) {

			System.out.println("Withdrawing Rs."+amount);
			balance=balance-amount;   //balance-=amount;
			System.out.println("balance");
		}
		else
		{
			try {
				throw new InsufficientBalanceException("Insufficient Balance");
			}
			catch(Exception e) 
			{
				System.out.println(e.getMessage());

			}
		}
	}


	@Override
	public int getbalance() 
	{
		return balance;
	}
}
