//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
	   WordsCompare s = new WordsCompare();
		
		s.setWords("a", "b");
		s.compare();
		System.out.println(s.toString());
		
		s.setWords("b", "a");
		s.compare();
		System.out.println(s.toString());
		
		s.setWords("abe", "ape");
		s.compare();
		System.out.println(s.toString());
		
		s.setWords("giraffe", "gorilla");
		s.compare();
		System.out.println(s.toString());
		
		s.setWords("123", "19");
		s.compare();
		System.out.println(s.toString());
		
		s.setWords("goofy", "godfather");
		s.compare();
		System.out.println(s.toString());

	}
}