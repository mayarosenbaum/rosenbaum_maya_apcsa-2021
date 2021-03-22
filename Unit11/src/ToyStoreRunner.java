//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class ToyStoreRunner
{
	public static void main( String args[] )
    {
	ToyStore sto = new ToyStore();
	sto.loadToys("sorry bat sorry sorry sorry train train" );
	System.out.println( sto );
	System.out.println( "max == " + sto.getMostFrequentToy() );
	sto.sortToysByCount();
	System.out.println( "sort == " + sto);
    }

}