/**
 * 
 */
package program2;

import exceptions.SSNCharacterException;
import exceptions.SSNLengthException;

/**
 * @author Ylva
 *
 */
public class Employee extends Person {
	/**
	 * The Social Security Number of this person
	 */
	private int SSN;
	/**
	 * Default constructor, uses the default constructor from the super class for the name
	 * Sets the SSN to 000000000
	 */
	public Employee() {
		super();
		SSN = 0;
	}

	/**
	 * Constructor that only sets the name
	 * Sets the SSN to 000000000
	 * @param initialName the name to set for this person
	 */
	public Employee(String initialName) {
		super(initialName);
		SSN = 0;
	}
	/**
	 * Sets only the SSN
	 * Uses the default constructor of the super class to set the name
	 * Here the SSN has to be checked beforehand using the Employee.checkSSN(String) method
	 * @param initialSSN the SSN to set
	 */
	public Employee (int initialSSN){
		super();
		SSN = initialSSN;
	}
	/**
	 * Sets both the name and the ssn
	 * @param initialName the name to set
	 * @param initialSSN the SSN to set
	 */
	public Employee (String initialName, int initialSSN){
		super(initialName);
		SSN = initialSSN;
	}

	/**
	 * @return the SSN
	 */
	public int getSSN() {
		return SSN;
	}

	/**
	 * @param initialSSN the SSN to set
	 */
	public void setSSN(int initialSSN) {
		SSN = initialSSN;
	}
	
	/**
	 * Will return the integer form of the SSN if the SSN is a possible SSN
	 * @param SSN The SSN input to check
	 * @return The integer version of the SSN
	 * @throws SSNLengthException This exception is thrown if the SSN not including spaces or dashes is not of length 9
	 * @throws SSNCharacterException This exception is thrown if the SSN not including spaces or dashes contains non digit characters
	 */
	public static int getSSN(String SSN) throws SSNLengthException, SSNCharacterException{
		SSN = SSN.replace(" ", "");//take out the spaces
		SSN = SSN.replace("-", "");//take out the dashes
		if (SSN.length()>9){
			throw new SSNLengthException("The given SSN is to long.\nYou gave the SSN : " + SSN + ".\nThe SSN should only be 9 characters and this SSN is " + SSN.length() + " characters.");
		}else if (SSN.length()<9){
			throw new SSNLengthException("The given SSN is to short.\nYou gave the SSN : " + SSN + ".\nThe SSN should be 9 characters and this SSN is " + SSN.length() + " characters.");
		}
	    int i = 0;
	    while (i<9){
	    	if (!Character.isDigit(SSN.charAt(i))){
	    		throw new SSNCharacterException("The given SSN contains a non digit character.\nYou gave the SSN : " + SSN + ".\nThe caracter at position " + (i+1) + " is a " + SSN.charAt(i) + ".\nThis is not a digit");
	    	}
	    	i++;
	    }
		return Integer.parseInt(SSN);
	}
	

}
