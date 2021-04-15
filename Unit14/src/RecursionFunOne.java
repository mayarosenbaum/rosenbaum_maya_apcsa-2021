//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class RecursionFunOne
{
	public static int countOddDigits(int num)
	{
		if (num/10 == 0) {
			return num % 2 == 1 ? 1 : 0;
		}
		else {
			return (num % 10 % 2 == 1? 1:0) + countOddDigits(num/10);
		}
	}
}