package program2;

/**
 * Since I could not find the book I have looked online in order to find this class, I have written the javadoc for it however for the rest is should be the same as the original
 * @author Ylva
 * Edit1: this class was directely copied from lab 4 from theme 6 where I also had to use this class.
 */
public class Person {
	/**
	 * The name of this person
	 */
	private String name;
	
	/**
	 * Default constructor, sets name as "No Name Yet" 
	 */
	public Person(){
		name = "No Name Yet";
	}
	/**
	 * Secondary constructor, sets name as the input name given
	 * @param initialName the name to give to this person
	 */
	public Person(String initialName)
    {
        name = initialName;
    }
	
	/**
	 * Sets the name for this person
	 * @param newName the name to set for this person
	 */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Returns the name in string format
     * @return the name as stored
     */
    public String getName()
    {
        return name;
    }
    /**
     * Will write the name given on the default output stream (normally the console)
     */
    public void writeOutput()
    {
        System.out.println("Name: " + name);
    }
    /**
     * Will return true if both the given and the current object have the same name
     * @param otherPerson the person with which to compare
     * @return true if both have the same name, ignoring case
     */
    public boolean hasSameName(Person otherPerson)
    {
        return this.name.equalsIgnoreCase(otherPerson.getName());
    }
}
