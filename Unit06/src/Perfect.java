//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;
   
   public Perfect() 
   {
	   setPerfect(0);
   }
   
   public Perfect(int n) 
   {
	  setPerfect(n); 
   }
   
   public void setPerfect(int n)
   {
	   number = n;
   }

	public boolean isPerfect()
	{
		int sum = 0;
		
		for (int i=1; i<=number; i++) {
			if (number%i==0) {
				sum = sum + i;
			}
		}
		if (sum == number) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String output = number + " is ";
		if (isPerfect()) {
			output += "perfect\n";
		}
		else {
			output += "not perfect\n";
		}
		return output;
	}

	
	
}