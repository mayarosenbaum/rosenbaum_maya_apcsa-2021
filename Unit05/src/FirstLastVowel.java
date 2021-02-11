//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   char ch = a.charAt(0);
	   char ch2 = a.charAt(a.length()-1);
	   
	   if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
			   ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
		   return "yes";
	   }
	   else if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u' ||
			   ch2 == 'A' || ch2 == 'E' || ch2 == 'I' || ch2 == 'O' || ch2 == 'U') {
		   return "yes";
	   }
	   else {
		   return "no";
	   }
	}
}