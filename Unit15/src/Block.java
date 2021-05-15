import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block() {
    xPos = 100; 
    yPos = 150;
    width = 10;
    height = 10;
    color = new Color(0, 0, 0);
  }

  public Block(int x, int y) {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
    color = new Color(0, 0, 0);
  }

  public Block(int x, int y, Color color) {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
    this.color = color;
  }

  public Block(int x, int y, int width, int height) {
    xPos = x;
    yPos = y;
    this.width = width;
    this.height = height;
    color = new Color(0, 0, 0);
  }

  public Block(int x, int y, int width, int height, Color color) {
    xPos = x;
    yPos = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }  

  public void setPos(int x, int y) {
    xPos = x;
    yPos = y;
  }
  public void setX(int x) {
    xPos = x;
  }
  public void setY(int y) {
    yPos = y;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int getX() {
    return xPos;
  }

  public int getY() {
    return yPos;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Color getColor() {
    return color;
  }

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col) {
    window.setColor(col);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
    Block b = (Block) (obj);
    return (b.getX() == xPos && b.getY() == yPos && b.getWidth() == width && b.getHeight() == height && b.getColor().equals(color));
  }   

  //add the other get methods
  


  //add a toString() method  - x , y , width, height, color
  public String toString() {
    return xPos + " " + yPos + " " + width + " " + height + " " + color;
  }

}