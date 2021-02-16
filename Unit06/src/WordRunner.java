//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class WordRunner
{
	public static void main ( String[] args )
	{
		Word test = new Word();
		
		test.setString("Hello");
		System.out.println(test.toString());
		
		test.setString("World");
		System.out.println(test.toString());
		
		test.setString("JukeBox");
		System.out.println(test.toString());
		
		test.setString("TCEA");
		System.out.println(test.toString());
		
		test.setString("UIL");
		System.out.println(test.toString());
	}
}