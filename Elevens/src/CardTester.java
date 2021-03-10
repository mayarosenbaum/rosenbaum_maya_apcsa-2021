/**
 * This is a class that tests the Card class.
 */
public class CardTester {

 public static void main(String[] args) {
  Card one = new Card("4", "Spades", 3);
  Card two = new Card("6", "Clubs",3);
  Card three = new Card("4", "Spades", 3);
  
  //object one
  System.out.println("One matches two?" + one.matches(two));
  System.out.println("Card one rank: " + one.rank());
  System.out.println("Card one suit: " + one.suit());
  System.out.println("Card one point value: " + one.pointValue());
  System.out.println("Card one: " + one.toString());
  
  System.out.println("\n");
  
  //object two
  System.out.println("two matches three?" + two.matches(three));
  System.out.println("Card two rank: " + two.rank());
  System.out.println("Card two suit: " + two.suit());
  System.out.println("Card two point value: " + two.pointValue());
  System.out.println("Card two: " + two.toString());
  
  System.out.println("\n");
  
  //object three
  System.out.println("three matches one?" + three.matches(one));
  System.out.println("Card three rank: " + three.rank());
  System.out.println("Card three suit: " + three.suit());
  System.out.println("Card three point value: " + three.pointValue());
  System.out.println("Card three: " + three.toString());
  
  System.out.println("\n");
 }
}
