package exceptions;

public class SSNCharacterException extends Exception {

	/**
	 * The reason for this number is given in the TimeFormatException class
	 */
	private static final long serialVersionUID = 1L;
	public SSNCharacterException() {
		super("The SSN contains incorrect characters.");
	}

	public SSNCharacterException(String arg0) {
		super(arg0);
	}

	public SSNCharacterException(Throwable arg0) {
		super(arg0);
	}

	public SSNCharacterException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SSNCharacterException(String arg0, Throwable arg1, boolean arg2,	boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
