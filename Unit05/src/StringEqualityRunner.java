//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		StringEquality s = new StringEquality();
		
		s.setWords("word", "word");
		s.checkEquality();
		System.out.println(s.toString());
		
		s.setWords("test", "word");
		s.checkEquality();
		System.out.println(s.toString());
		
		s.setWords("cat", "dog");
		s.checkEquality();
		System.out.println(s.toString());
		
		s.setWords("dog", "dog");
		s.checkEquality();
		System.out.println(s.toString());
		
		s.setWords("ABC", "BCA");
		s.checkEquality();
		System.out.println(s.toString());
		
		s.setWords("ABC", "ABC");
		s.checkEquality();
		System.out.println(s.toString());
		
	}
}