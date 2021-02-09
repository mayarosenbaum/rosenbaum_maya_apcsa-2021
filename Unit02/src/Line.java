//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Line
{
	public static double getSlope( double x1, double y1, double x2, double y2 )
	{
		return (y2 - y1) / (x2 - x1);
	}
	
	private int fun;
	
	public void change() {
		int fun = 5;
	}
	
	public String toString()
	{
		return "" + fun;
	}

}