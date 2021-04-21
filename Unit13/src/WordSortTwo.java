//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
    // instance variable
    private String[] wordRay;

    
    // init constructor
    public WordSortTwo(String sentence)
    {
        // creates an array of the words in sentence
        wordRay = sentence.split(" ");
        
        // sort the array of words alphabetically
        bubbleSort();
        
    }

    
    public void resetWords(String sentence)
    {
        // creates an array of the words in sentence
        wordRay = sentence.split(" ");
        
        // sorts the array of words alphabetically
        selectionSort();
    }
    
    
    public void bubbleSort()
    {
        // use your own sort
        // Don't use Arrays.sort(wordRay);
      
        // you will need an outer loop to make wordRay.length passes
        for (int p=1; p < wordRay.length; p++)
        {
            // you will need an inner loop that will
            // compare each i and i+1 element to see if they are out of order (OOO)
            for (int i=0; i < wordRay.length-1; i++)
            {
                 // check to see if the i and i+1 elements are out of order (OOO)
                 // use the compareTo() method to see if
                 // wordRay[i].compareTo(wordRay[i+1]) is greater than 0
                 // and if so, swap the i and i+1 elements
                 if (wordRay[i].compareTo(wordRay[i+1]) > 0) // use greater than  OOO
                 {
                      // HERE is some general info
                      // swap the ith and i+1 elements
                      // use a temporary variable to help with your swap
                   
                      // START HERE with your code
                      // STEP 1: copy the i element to the temp box
                      String temp = wordRay[i];
                      
                      // copy the i+1 element to the i box
                      wordRay[i] = wordRay[i+1];
                      
                      // copy the temp element to the i+1 box
                      wordRay[i+1] = temp;
                   
                 }  // end of if
              
            } // end of for i loop to loop through the words
        } // end of outer for loop for the number of passes
    }

    public void selectionSort()
    {
        // write a selection sort to sort the words
        // GOOGLE IT!
        for ( int j=0; j < wordRay.length-1; j++ )
    {
      // Find min: the index of the string reference that should go into cell j.
      // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
      int min = j;
      for ( int k=j+1; k < wordRay.length; k++ )
        if ( wordRay[k].compareTo( wordRay[min] ) < 0 ) min = k;  

      // Swap the reference at j with the reference at min 
      String templ = wordRay[j];
      wordRay[j] = wordRay[min];
      wordRay[min] = templ;
    }
      
    }
    
    
    
    public String toString()
    {
        String output="";

        // join each word in the wordRay list to your output
        // you will need to loop through the list adding all the way
        // if it is the last element
        //     output += the word; // no ", " 
        // else
        //     output += the word + ", "; 

        // loop through all of the wordRay objects
        for (int i = 0; i<wordRay.length; i++)
        {
           if (i == wordRay.length-1) // last index
                output += wordRay[i]; // no ", " 
            else
             output += wordRay[i] + ", ";
        }
        
        return output; // fix me!!!! by returning your output
    }
    
}