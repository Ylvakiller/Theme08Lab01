/**
 * 
 */
package program2;

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
	 * @param SSN the sSN to set
	 */
	public void setSSN(int initialSSN) {
		SSN = initialSSN;
	}
	

}
