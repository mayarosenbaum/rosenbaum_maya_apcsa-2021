//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private double distance, hours, minutes;
	private double minInHours, totalHours;
	private double mph;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph = 0.0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
	}
	
	public void calcTime()
	{
		minInHours = minutes / 60;
		totalHours = minInHours + hours;
	}
	
	public void calcMPH()
	{
		mph = distance / totalHours;
	}

	public void print()
	{
		System.out.print("\n");
		System.out.printf("%.0f", distance);
		System.out.print(" miles in ");
		System.out.printf("%.0f", hours);
		System.out.print(" hours and ");
		System.out.printf("%.0f", minutes);
		System.out.print(" minutes = ");
		System.out.printf("%.0f", mph);
		System.out.print(" MPH.");
		System.out.print("\n\n");
	}
}