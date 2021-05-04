//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class WordSortTwoRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("wordsorttwo.dat"));
        
        int size = file.nextInt(); // reads in first line (# of sentences)
        file.nextLine(); // moves file cursor to the next line
        
        for(int i = 0; i < size; i++)
        {
            String sentence = file.nextLine(); // reads in the sentence
            System.out.println(sentence);
            
            // instantiate a new WordSortTwo object
            WordSortTwo words = new WordSortTwo(sentence);
            System.out.println(words);  // calls toString() method
            words.resetWords(sentence);
            System.out.println(words);  // calls toString() method            
            System.out.println();
        }
        
    } // end of main method
}