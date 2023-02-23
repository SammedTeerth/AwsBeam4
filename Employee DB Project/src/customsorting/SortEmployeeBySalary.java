package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2) 
	{
		Double x = e1.getsalary(); // 2.8 // Auto-Boxing
		Double y = e2.getsalary(); // 2.6
		return x.compareTo(y); // 2.8.compareTo(2.6)->+1
	}

}
