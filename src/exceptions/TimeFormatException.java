package exceptions;
/**
 * This exception should be thrown when a certain time input is of an incorrect format
 * @author Ylva
 */
public class TimeFormatException extends Exception {

	/**
	 * The reasons why I have this here can be read on the following page:
	 * http://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it (accessed on 30-04-2015)
	 * I however must admit that I not extremely clear why this is important to have, I am however clear that this is an import field to have and therefore I have included it
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public TimeFormatException() {
		super("The time is of an incorrect format.");
	}
	
	public TimeFormatException(String arg0) {
		super(arg0);
	}

	public TimeFormatException(Throwable arg0) {
		super(arg0);
	}

	public TimeFormatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TimeFormatException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
