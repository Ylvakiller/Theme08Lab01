package program2;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.SSNCharacterException;
import exceptions.SSNLengthException;

/**
 * This class will test the workings of the Employee class. it will do that by allowing the user to enter Employees.
 * The blackboard assignment said that there would be a maximum of employees, I however have chosen to use an arrayList for this. 
 * I could implement a small counter that stops the entering for more than 100 employees, however with this Arraylist I save memory when you have less than 100 employees and I am allowed to enter more then 100 employees making this program scalable to enormous amounts of employees
 * @author Ylva
 *
 */
public class EmployeeTester {

	/**
	 * This constructor is all that should be runned in this class.
	 * In a standalone program this default constructor would be refactored from "public EmployeeTester()" to "public static void main()"
	 */
	public EmployeeTester() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		while (true){
			System.out.println("You can stop entering data at any time by inputting just a n."); //This has as limitation that the name cannot be "n", in any normal program this would be replaced by a button
			System.out.println("Please enter the name of your employee:");
			String employeeName = keyboard.next();
			if (employeeName.equals("n")){
				break;
			}
			System.out.println("Now enter the SSN of this employee");
			String ssnString = keyboard.next();
			int ssn = 0;
			if (ssnString.equals("n")){
				break;
			}
			try {
				ssn = Employee.obtainSSN(ssnString);
			} catch (SSNLengthException | SSNCharacterException e) {
				System.out.println(e.getMessage());
			}finally{
				employeeList.add(new Employee(employeeName, ssn));//Add the employee to the list
			}
		}
		System.out.println("\nYou have entered " + employeeList.size() + " employees, I will print the data out for all those employees:\n");
		int i = 0;
		while (i<employeeList.size()){
			System.out.println("Name: " + employeeList.get(i).getName() + "\t\t\tSSN: " + employeeList.get(i).getSSN());
		}
	}

}
