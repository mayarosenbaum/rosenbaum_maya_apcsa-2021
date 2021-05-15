import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200,10,10,Color.black);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int x, int y, int width, int height, Color newColor, int newXSpeed, int newYSpeed) {
    super(x, y, width, height, newColor);
    setXSpeed(newXSpeed);
    setYSpeed(newYSpeed);
  }

  public Ball(int x, int y, int width, int height, Color newColor) {
    super(x, y, width, height, newColor);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x, int y, int width, int height, int newXSpeed, int newYSpeed) {
    super(x, y, width, height);
    setXSpeed(newXSpeed);
    setYSpeed(newYSpeed);
  }

  public Ball(int x, int y, int width, int height) {
    super(x, y, width, height);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x, int y) {
    super(x, y);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(Color newColor) {
    super(200, 200, newColor);
      xSpeed = 2;
      ySpeed = 1;
  }
           
  //add the set & get methods
  public void setXSpeed(int newXSpeed) {
    xSpeed = newXSpeed;
  }

  public void setYSpeed(int newYSpeed) {
    ySpeed = newYSpeed;
  }

  public int getXSpeed() {
    return xSpeed;
  }

  public int getYSpeed() {
    return ySpeed;
  }
   

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.white);
    //move
    setX(getX() + getXSpeed());
    //setY
    setY(getY() + getYSpeed());

    //draw the ball at its new location
    draw(window, super.getColor());
  }
   
  public boolean equals(Object obj)
  {
    Ball b = (Ball)obj;
    if (b.getXSpeed() != xSpeed) {
      return false;
    }
    else if (b.getYSpeed() != ySpeed) {
      return false;
    }
    else {
      return true;
    }
    //return false;
  }

  public boolean didCollideLeft(Object obj) {
    Block b = (Block)obj;
    return getX() <= b.getX() + b.getWidth() + Math.abs(getXSpeed());
  }

  public boolean didCollideRight(Object obj) {
    Block b = (Block)obj;
    return getX() + getWidth() >= b.getX() - Math.abs(getXSpeed());
  }

  public boolean didCollideTop(Object obj) {
    Block b = (Block)obj;
    return getY() >= b.getY() && getY() <= b.getY() + getHeight();
  }

  public boolean didCollideBottom(Object obj) {
    Block b = (Block)obj;
    return getY() + getHeight() >= b.getY() && getY() + getHeight() <= b.getY() + b.getHeight();
  }


  //add a toString() method
  public String toString() {
    return super.toString() + " " + xSpeed + " " + ySpeed;
  }
}