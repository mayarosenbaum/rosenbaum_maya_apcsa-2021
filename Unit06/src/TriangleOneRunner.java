//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		TriangleOne test = new TriangleOne();
		
		test.setWord("hippo");
		System.out.println(test.print());
		
		test.setWord("abcd");
		System.out.println(test.print());
		
		test.setWord("it");
		System.out.println(test.print());
		
		test.setWord("a");
		System.out.println(test.print());
		
		test.setWord("chicken");
		System.out.println(test.print());
	}
}