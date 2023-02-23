package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2) {
		String x = e1.getname();
		String y = e2.getname();
		return x.compareTo(y);
	}

}
