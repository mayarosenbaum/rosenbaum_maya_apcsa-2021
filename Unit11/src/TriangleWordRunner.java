//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
	   	Scanner keyboard = new Scanner(System.in);
	   	String choice="";
				System.out.print("\nEnter the word to display :: ");
				
				TriangleWord.createTriangle(choice);

				System.out.print("\nDo you want to enter more sample input? ");
				choice=keyboard.next();				
		}
}