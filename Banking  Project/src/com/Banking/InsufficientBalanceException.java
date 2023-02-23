package com.Banking;

public class InsufficientBalanceException extends RuntimeException
{
	private String message;
	
	InsufficientBalanceException(String message){
		this.message=message;
	}
@Override
public String getMessage()
{
	return message;
}
}

/** Rules to work with Custom /user_Defined Exception
1. create a class with the exception Name.
2 a. if class extends RuntimeException -> Unchecked Exception
2b. if class extends Exception -> Checked Exception
3. Override getMessage() -> (Variable, Constructor, method)
4. invoke the Exception Object usinf=g throw keyword,
  handle it using try & catch block with Suitable message
  
*/