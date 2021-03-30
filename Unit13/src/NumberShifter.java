//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int array[] = new int[size];
		for(int i=0; i < array.length; i++)
		{
			array[i] = (int)(Math.random()*10);
		}
		return array;
	}
	public static void shiftEm(int[] array)
	{
		int non7;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 7) {
				non7 = i;
				break;
			}
		}
	}
}