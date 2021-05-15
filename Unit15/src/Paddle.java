import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle() {
    super(10,10);
    speed = 1;
  }

  public Paddle(int x, int y) {
    super(x, y);
    speed = 1;
  }

  public Paddle(int x, int y, int speed) {
    super(x, y);
    this.speed = speed;
  }

  public Paddle(int x, int y, int width, int height) {
    super(x, y, width, height);
    speed = 1;
  }

  public Paddle(int x, int y, int width, int height, int speed) {
    super(x, y, width, height);
    this.speed = speed;
  }

  public Paddle(int x, int y, int width, int height, Color color) {
    super(x, y, width, height, color);
    speed = 1;
  }

  public Paddle(int x, int y, int width, int height, Color color, int speed) {
    super(x, y, width, height, color);
    this.speed = speed;
  }


  //add the other Paddle constructors

  public void moveUpAndDraw(Graphics window) {
    super.draw(window, Color.white);
    setY(getY() + speed);
    super.draw(window);
  }

  public void moveDownAndDraw(Graphics window) {
    super.draw(window, Color.white);
    setY(getY() - speed);
    super.draw(window);
  }

  //add get methods
  public void setPos(int x, int y) {
    super.setPos(x, y);
  }

  public void setX(int x) {
    super.setX(x);
  }

  public void setY(int y) {
    super.setY(y);
  }

  public void setColor(Color color) {
    super.setColor(color);
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getX() {
    return super.getX();
  }

  public int getY() {
    return super.getY();
  }

  public int getWidth() {
    return super.getWidth();
  }

  public int getHeight() {
    return super.getHeight();
  }

  public Color getColor() {
    return super.getColor();
  }

  public int getSpeed() {
    return speed;
  }
   
  //add a toString() method
  public String toString() {
    return super.toString() + " " + speed;
  }

  public boolean equals(Object obj) {
    Paddle p = (Paddle)(obj);
    return (super.equals(obj) && p.getSpeed() == speed);
  } 
}