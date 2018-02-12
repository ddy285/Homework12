/* 12.14
 * (Process scores in a text file) Suppose that a text file contains an unspecified number of scores separated by blanks. 
 * Write a program that prompts the user to enter the file, reads the scores from the file, and displays their total and average.
 */
package csc201;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Chapter12 {
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Enter a file the contains scores: ");
		File file = new File(keyboard.nextLine());
				
		//See if file exists
		if(!file.exists()) {
			System.out.println("File " +file + " doesn't exist.");
			System.exit(1);	
		}
	int count = 0; 
	double total = 0;
	
	try (
			Scanner keyboardFile = new Scanner(file);
			){
		while (keyboardFile.hasNext()) {
			total+= keyboardFile.nextInt();
			count++;
		}
	}
	//Results
	System.out.println("File " +file.getName());
	System.out.println("Total scores: " + total);
	System.out.println("Average scores: " + df2.format(total/count));
	 keyboard.close();
	}

}
