package program1;

import java.util.Scanner;

import exceptions.TimeFormatException;
/*
 * Description as found on Blackboard:
 * Project 1. Write a program that converts a time from 24-hour notation to 12-hour notation. The following is a sample interaction between the user and the program:
 * 
 * Enter time in 24-hour notation:
 * 13:07
 * That is the same as
 * 1:07 PM
 * Again? (y/n)
 * y
 * 
 * Enter time in 24-hour notation:
 * 10:15
 * That is the same as
 * 10:15 AM
 * Again? (y/n)
 * y
 * 
 * Enter time in 24-hour notation:
 * 10:65
 * There is no such time as 10:65
 * Try Again:
 * Enter time in 24-hour notation:
 * 16:05
 * That is the same as
 * 4:05 PM
 * Again? (y/n)
 * N
 * End of program
 * 
 * Define an exception class called TimeFormatException. If the user enters an Illegal time, like 10:65, or even gibberish, like 8&*68, your program should throw and handle a TimeFormatException.
 * 
 * Remarks:
 * Write the class TimeFormatException as well as a main class in which you show that your classes work.
 * Try to think of what type of nonsense a user could put in: 
 * - Something that contains more than 5 characters
 * - Something that contains no “:”
 * - Something that contains other characters than numbers
 * - Something where the hours are larger than 24
 * - Something where the minutes are larger than 60
 * For each possibility throw a TimeFormatException with the correct message stating the user error.
 * 
 */
/**
 * This class will convert a given 24-hour standard time to a 12-hour time, handling exceptions and looping until the user wants to end, once the user says so the whole program is exited
 * @author Ylva
 *
 */
public class TimeConversion {
	/**
	 * This constructor is all that should be runned in this class.
	 * In a standalone program this default constructor would be refactored from "public TimeConversion()" to "public static void main()"
	 */
	public TimeConversion() {
		boolean running = true;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		while (running){
			while (true){
				System.out.println("Please give the time in a 24hour format");
				String time = keyboard.next();
				try {
					time = TimeConversion.processTimeFormat(time);
					System.out.println("That is the same as\n" + time);
				} catch (TimeFormatException e) {
					System.err.println(e.getMessage());
				}finally{
				}
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

	/**
	 * This will check if the time fits the format and will change the time to a PM or AM time.
	 * It will throw a TimeFormatException with what is wrong with the input.
	 * @param inputTime the input to process
	 * @return an AM-PM version of the input time
	 * @throws TimeFormatException an Exception with the problem in the input in it
	 */
	private static String processTimeFormat(String inputTime) throws TimeFormatException{
		if (!inputTime.contains(":")){
			throw new TimeFormatException("The input " + inputTime + " does not contain a semicolon");
		}
		if (inputTime.length()>5){
			throw new TimeFormatException("The input " + inputTime + " is more than 5 characters.");
		}
		if (inputTime.length()<5){
			throw new TimeFormatException("The input " + inputTime + " is less than 5 characters.");
		}
		if (inputTime.charAt(2)!=':'){
			throw new TimeFormatException("The input " + inputTime + " does not contain a semicolon in the middle");
		}
		String hour = inputTime.substring(0, 2);
		String minutes = inputTime.substring(3, 5);
		if (!TimeConversion.isInteger(hour)||!TimeConversion.isInteger(minutes)){
			throw new TimeFormatException("The input " + inputTime + " contains other characters then numbers (not counting the semicolon in the middle)");
		}
		int intHour = Integer.parseInt(hour);
		int intMinutes = Integer.parseInt(minutes);
		if (intHour>23){
			throw new TimeFormatException("The amount of hours given in the input(" + inputTime + ") is to high (" + intHour +")");
		}
		if (intMinutes>59){
			throw new TimeFormatException("The amount of minutes given in the input(" + inputTime + ") is to high (" + intMinutes +")");
		}
		//At this point all the exception have been tested and the actuall processing can start
		boolean PM = false;
		if (intHour>12){
			PM = true;
			intHour = intHour-12;
		}else if (intHour==12){	//According to the convention, 1200 noon is 1200 PM
			PM = true;
		}else if (intHour==0){	//According to the convention, the time between midnight and one o'clock in the night is 12:** AM, more on the convention can be read on: http://en.wikipedia.org/wiki/12-hour_clock (accessed 30-4-2015)
			intHour = 12;
		}
		String output = String.valueOf(intHour) + ":" + String.valueOf(intMinutes);
		if (PM){
			output += " PM";
		}else{
			output += " AM";
		}
		return output;
	}
	/**
	 * This method uses exceptions to see if a given input is an integer
	 * @param inputToTest the input to test
	 * @return true if the input is an integer, false if it is not
	 */
	private static boolean isInteger(String inputToTest) {
	    try { 
	        Integer.parseInt(inputToTest); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
