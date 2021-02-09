//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		
		double bill = Discount.getDiscountedBill(amt);
		System.out.print("Bill after Discount :: ");
		System.out.printf("%.3f", bill);
		System.out.print("\n\n");

	}
}