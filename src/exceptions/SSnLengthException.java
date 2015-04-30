/**
 * 
 */
package exceptions;

/**
 * @author Ylva
 *
 */
public class SSNLengthException extends Exception {
	/**
	 * The reason for this number is given in the TimeFormatException class
	 */
	private static final long serialVersionUID = 1L;
	public SSNLengthException() {
		super("The SSN is of incorrect length.");
	}
	public SSNLengthException(String arg0) {
		super(arg0);
	}
	public SSNLengthException(Throwable arg0) {
		super(arg0);
	}
	public SSNLengthException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public SSNLengthException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
