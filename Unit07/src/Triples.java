//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;
import java.lang.Math.*;

public class Triples
{
 private int number;

public Triples()
{
    this(0);
}

public Triples(int num)
{
    number = num;
}

public void setNum(int num)
{
    number = num;
}

private int greatestCommonFactor(int a, int b, int c)
{
    int limit = Math.min(a, b);
    limit = Math.min(limit, c);
    for(int n = limit; n >= 2; n--)
    {
        if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
            return n;
        }
    }

    return 1;
}

public String toString()
{
    String output="";
    int a, b, c;
    int max = number;
    for(a = 1; a <= max; a++)
    {
        for(b = a +1; b <= max; b++)
        {
            for(c = b + 1; c <= max; c++)
            {
                if(Math.pow(a, 2)+ Math.pow(b, 2)== Math.pow(c, 2))
                {
                    if((a%2==1 && b%2==0)|| (a%2==0 && b%2==1))
                    {
                        if(a%2<=1 && b%2<=1 && c%2<=1)
                        {
                        	if (greatestCommonFactor(a, b, c) == 1) {
                        		output += a + " " + b + " " + c + "\n";
                        	}
                        }
                    }
                }
            }
        }
    }

    return output+"\n";
}
}