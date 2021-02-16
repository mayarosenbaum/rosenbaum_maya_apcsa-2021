//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		LetterRemover test = new LetterRemover();
		test.setRemover("Hi, I'm maya!", 'a');
		test.removeLetters();
		System.out.println(test.toString());

		test.setRemover("sjdfhkjdshuaegfu", 's');
		test.removeLetters();
		System.out.println(test.toString());
		
		test.setRemover("isn't it sweet that there are so many t's", 't');
		test.removeLetters();
		System.out.println(test.toString());
											
	}
}