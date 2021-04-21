//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class NumberSorter
{
    static int count = 0;
    private static int getNumDigits(int number)
    {
        while(number>0){
 
                number=number/10;
            count++;
        }
        return count;
    }
 
    public static int[] getSortedDigitArray(int number)
    {
        int[] sorted = new int[getNumDigits(number)];
        for(int a = 0; a<sorted.length; a++)
        {
            sorted[a] = number%10;
            number = number/10;
        }
        for(int a = 0; a<sorted.length; a++)
        {
            int y = a;
            for(int b = a+1; b<sorted.length; b++)
            {
                if(sorted[b]<sorted[y])
                {
 
                    y = b;
                }
            }
            if(y != a)
            {
                int temp = sorted[y];
                sorted[y]=sorted[a];
                sorted[a]=temp;
            }
        }
        return sorted;
    }
 
    public static void main(String args[])
    {
        int[] cases = {567891, 901912468, 864213507, 898777, 234422, 29826};
        for( int test : cases )
        {
            int[] one = NumberSorter.getSortedDigitArray( test );
            for(int item : one)
            {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}