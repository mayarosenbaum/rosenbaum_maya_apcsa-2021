//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10, 10, 50);
		speed =5;
		
		setColor(Color.BLACK);
		
   }


   //add the other Paddle constructors










   public Paddle(int i, int j) {
	// TODO Auto-generated constructor stub
	   
	   super(i,j , 10, 50);
	   speed = 5;
	   setColor(Color.BLACK);
}


public Paddle(int i, int j, int k) {
	// TODO Auto-generated constructor stub
	
	 super(i,j , 10, 50);
	   speed = k;
	   setColor(Color.BLACK);
}


public Paddle(int i, int j, int k, int l, int m) {
	// TODO Auto-generated constructor stub
	
	 super(i,j , l, m);
	   speed = k;
	   
	   setColor(Color.BLACK);
}


public Paddle(int i, int j, int k, int l, Color green, int m) {
	// TODO Auto-generated constructor stub
	 super(i,j , l, m);
	   speed = k;
	   setColor(green);
	
}


public void moveUpAndDraw(Graphics window)
   {
	
		draw(window, Color.WHITE);

	  //setX(getX()+speed);
	  setY(getY()+speed);

	  draw(window, Color.BLACK);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
		
		  //setX(getX()-speed);
		  setY(getY()-speed);

		  draw(window, Color.BLACK);

   }

   //add get methods
   
   
   //add a toString() method
}