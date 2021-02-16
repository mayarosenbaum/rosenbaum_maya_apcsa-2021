//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		Perfect test = new Perfect();
		
		test.setPerfect(14);
		test.isPerfect();
		System.out.println(test.toString());
		
		test.setPerfect(496);
		test.isPerfect();
		System.out.println(test.toString());
		
		test.setPerfect(6);
		test.isPerfect();
		System.out.println(test.toString());
		
		test.setPerfect(28);
		test.isPerfect();
		System.out.println(test.toString());

													
	}
}