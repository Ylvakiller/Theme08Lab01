package program1;

import java.util.Scanner;

public class TimeConversion {
	/**
	 * This constructor is all that should be runned in this class.
	 * In a standalone program this default constructor would be refcatored from "public TimeConversion()" to "public static void main()"
	 */
	public TimeConversion() {
		boolean running = true;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		while (running){
			while (true){
				System.out.println("If you want to run again enter the y key, if not enter the n key.");
				String again =keyboard.next();
				if (again.equals("y")||again.equals("Y")){
					break;
				}else if(again.equals("n")||again.equals("N")){
					running = false;
					break;
				}else{
					System.err.println("Incorrect input, please try again.");
				}
			}
		}
		System.out.println("\nEnding program.");
		System.exit(0);
		
	}

}
