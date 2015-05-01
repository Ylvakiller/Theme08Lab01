package program2;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.SSNCharacterException;
import exceptions.SSNLengthException;
/*
 * Description as found on BlackBoard
 * Project 2. Write a program to enter employee data consisting of name and social security number, into an array. 
 * The maximum number of employees is 100, but your program should also work for any number of employees less than 100. 
 * Your program should use two exception classes, 
 * one called SSNLengthException for when the social security number entered—without dashes or spaces—is not exactly nine characters 
 * and the other called SSNCharacterException for when any character in the social security number is not a digit. 
 * When an exception is thrown, the user should be reminded of what she or he entered, told why it is inappropriate, and asked to reenter the data. 
 * After all data has been entered, your program should display the records for all employees. 
 * You will also need to define the classes Employee, SSNLengthException, and SSNCharacterException. Derive the class Employee from the class Person in Listing 8.4 of Chapter  8. Among other things, the class Employee should have input and output methods, as well as constructors, accessor methods, and mutator methods. Every Employee object should record the employee’s name and social security number.
 * 
 * Remarks:
 * All classes and methods need to be documented using Javadoc-style comments, except for the accessor and mutator methods in the class Employee. 
 * Write the exception classes SSNCharacterException and SSNLengthException.
 * Use the class Person from chapter 8, p. 580
 * Derive from this parent class the class Employee. The employee should have a name and a social security number (SSN). 
 * When assigning the SSN check whether it only contains numbers (if not throw SSNCharacterException) and is exactly 9 characters long (if not throw SSNLengthException). Make sure that the exceptions are caught and handled in a correct way. The program should continue working after an exception is thrown.
 * Finally, write a demonstration program in which you show that everything works:
 * -	Able to record all the data of all the employees (maximum number of employees is 100, but the user might want to put in less employees…)
 * -	For each employee the SSN is checked
 * -	Then display the following data:
 * 		o	Amount of employees
 * 		o	For each employee: name, SSN
 * 
 */

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
			String employeeName = keyboard.nextLine();
			if (employeeName.equals("n")){
				break;
			}
			System.out.println("Now enter the SSN of this employee");
			String ssnString = keyboard.nextLine();
			int ssn = 0;
			if (ssnString.equals("n")){
				break;
			}
			try {
				ssn = Employee.obtainSSN(ssnString);
				employeeList.add(new Employee(employeeName, ssn));//Add the employee to the list
			} catch (SSNLengthException | SSNCharacterException e) {
				System.out.print("");									//I added this line since there seemed to be something wrong in the threading in the java VM, without this line the error message would only be printed after the line below it was printed. this might be a local compiler bug but I figured it was best to make sure
				System.err.println(e.getMessage());
				System.out.println("Please enter the data from this employee again");
			}finally{
			}
			/*
			//This small piece of code was to limit the user from entering 100 employees if you would so desire. I stated my reason for not using arrays in the javadoc in the class
			if (employeeList.size()>100){
				break;
			}
			*/
		}
		System.out.println("\nYou have entered " + employeeList.size() + " employees, I will print the data out for all those employees:\n");
		int i = 0;
		while (i<employeeList.size()){
			System.out.println("Employee Number: "+ (i+1) +"\t\tName: " + employeeList.get(i).getName() + "\t\t\tSSN: " + employeeList.get(i).getSSN());
			i++;
		}
		System.out.println("\nEnding program.");
		System.exit(0);
	}

}
