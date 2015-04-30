import java.util.Scanner;

import program1.TimeConversion;

/**
 * This is a simple class to run either of the 2 programs in the assignment
 * @author Ylva
 *
 */
public class Runner {
	/**
	 * The goal of this method is to make this the only method that needs to be run for all the testing purposes
	 * You can set the input to 1 or 2 to test without the menu if you want
	 */
	public static void main(String[] args) {
		int input = 0;
		if (input==0){
			System.out.println("Please type the number of the program that you want to run.");
			System.out.println("Option 1, Time Exception program.");
			System.out.println("Option 2, Employee double Exception program.");
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			input = keyboard.nextInt();
		}
		switch (input){
		case 1: System.out.println("Running the Time Exception program.");
		TimeConversion temp = new TimeConversion();
		break;
		case 2: System.out.println("Running the Employee double Exception program");
		break;
		default: System.err.println("Incorrect input, stoppping program | Exit code 1");
		break;
		}
		System.exit(1);

	}

}
