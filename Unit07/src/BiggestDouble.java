//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a, b, c, d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double biggest;
		
		if(one>two&&one>three&&one>four) {
			biggest = one;
		}
		else if(two>one&&two>three&&two>four) {
			biggest = two;
		}
		else if(three>two&&three>one&&three>four) {
			biggest = three;
		}
		else {
			biggest = four;
		}
		return biggest;
	}

	public String toString()
	{
	   return one + " " + two + " " + three + " " + four + " ";
	}
}