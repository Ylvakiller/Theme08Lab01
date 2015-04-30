import java.util.Scanner;

/**
 * This is a simple class to run either of the 2 programs in the assignment
 * @author Ylva
 *
 */
public class Runner {
	/**
	 * The goal of this method is to make this the only method that needs to be runned for all the testing purposes
	 */
	public static void main() {
		System.out.println("Please type the number of the program that you want to run.");
		System.out.println("Option 1, Time Exception program.");
		System.out.println("Option 2, Employee double Exception program.");
		Scanner keyboard = new Scanner(System.in);
		int input = keyboard.nextInt();
		switch (input){
		case 1: System.out.println("Running the Time Exception program.");
		break;
		case 2: System.out.println("Running the Employee double Exception program");
		break;
		default: System.err.println("Incorrect input, stoppping program | Exit code 1");
		break;
		}
		keyboard.close();
		System.exit(1);

	}

}
