//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		setLetter(' ');
		setAmount(' ');
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output = "";
		
		// each line
		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < amount - i; j++) {
				for (int a = 0; a < amount - j; a++) {
					output += (char)(letter + j);
				}
				output += " ";
			}
			output += "\n";
		}
		
		return output;
	}
}