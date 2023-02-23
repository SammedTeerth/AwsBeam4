package Jspiders;

public class Calculatorimpl implements Calculator{
	@Override
	public int add (int x, int y) {
		return x+y;
	}
	@Override
	public int sub (int x, int y) {
		return x-y;
	}
	@Override
	public int mul (int x, int y) {
		return x*y;
	}
	@Override
	public int div (int x, int y) {
		if(y!=0) {
			return x/y;
		}
		return 0;
	}
	@Override
	public String displayerrorMessage() {
		return "invalid choice!!!";
	}
	{

	}
}
