	
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		setRemover("",' ');
	}
	
	public LetterRemover(String myString, char myLetter)
	{
		sentence = myString;
		lookFor = myLetter;
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned=sentence;
		int i = 0;
		while (i != -1) {
			i = cleaned.indexOf(lookFor);
			cleaned = cleaned.substring(0, i) + cleaned.substring(i + 1);
			i = cleaned.indexOf(lookFor);
			
		}
		return cleaned;
	}

	public String toString()
	{
		return (sentence + " - letter to remove " + lookFor + "\n" + removeLetters());
	}
}