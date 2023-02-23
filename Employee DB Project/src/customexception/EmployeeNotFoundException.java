package customexception;


public class EmployeeNotFoundException extends RuntimeException
{
	private String message;

	public EmployeeNotFoundException(String Message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}


}
