import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
//import java.awt.*;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;
  private Wall leftW;
  private Wall rightW;
  private Wall topW;
  private Wall bottomW;
  Score test = new Score();
  public int newWidth;
  public int newHeight;
  
  public void setWidth1(int num) {
    newWidth = num;
  }
  public void setHeight1(int num) {
    newHeight = num;
  }
  public int getWidth1() {
    return newWidth;
  }
  public int getHeight1() {
    return newHeight;
  }

  public Pong(int test1, int test2, int ballChoice)
  {
    //set up all variables related to the game
    if (ballChoice == 0) {
    ball = new Ball(Color.black);
    }
    if (ballChoice == 1) {
      ball = new BlinkyBall();
    }
    if (ballChoice == 2) {
      ball = new SpeedUpBall();
    }

    if (test1 == 0 && test2 == 0) {
      setWidth1(800);
      setHeight1(600);
    }
    else {
      setWidth1(test1);
      setHeight1(test2);
    }

    leftPaddle = new Paddle(10,10,15,150,Color.red, 5);
    //move right paddle to right side 
    rightPaddle = new Paddle(getWidth1() - 30,10,15,150, Color.yellow, 5);

    leftW = new Wall(0, 0, 10, getHeight1());
    rightW = new Wall(getWidth1(), 0, 10, getHeight1());
    topW = new Wall(0, 0, getWidth1(), 10);
    bottomW = new Wall(0, getHeight1() - 25, getWidth1(), 0);

    keys = new boolean[4];
    
    setBackground(Color.white);
    setVisible(true);
                
    new Thread(this).start();
    addKeyListener(this);               //starts the key thread to log key strokes
  }
        
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //leftPaddle.draw(window);
    //rightPaddle.draw(window);

    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();


    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);


    //see if ball hits left wall or right wall
    if (ball.didCollideLeft(leftW)) {
      test.addRight();
    }
    if (ball.didCollideRight(rightW)) {
      test.addLeft();
    }
    
    if (ball.didCollideLeft(leftW) || ball.didCollideRight(rightW)) {
      ball.setXSpeed(0);
      ball.setYSpeed(0);

      //graphToBack.setColor(Color.red);
      //graphToBack.fillRect(0, 0, 300, 100);

      System.out.println(test);
      
      graphToBack.clearRect(0, 0, getWidth1(), getHeight1());
      test.go(ball, getWidth1() / 2, getHeight1() / 2);
    }
                
    //see if the ball hits the top or bottom wall 
    if (ball.didCollideTop(topW) || ball.didCollideBottom(bottomW))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }

    //see if the ball hits the left paddle
    if (ball.didCollideLeft(leftPaddle) && (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle))) {
      if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
        ball.setYSpeed(-ball.getYSpeed());
      }
      else {
        ball.setXSpeed(-ball.getXSpeed());
      }
    }

    if (ball.didCollideRight(rightPaddle) && (ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle))) {
      if (ball.getX() + ball.getWidth() >= rightPaddle.getX() + Math.abs(ball.getXSpeed())) {
        ball.setYSpeed(-ball.getYSpeed());
      }
      else {
        ball.setXSpeed(-ball.getXSpeed());
      }
    }

    //see if the paddles need to be moved
    if (keys[0]) {
      if (leftPaddle.getY() < (getHeight1() - 180)) {
        leftPaddle.moveUpAndDraw(graphToBack);
      }
    }
    if (keys[1]){
      if (leftPaddle.getY() > 0) {
        leftPaddle.moveDownAndDraw(graphToBack);
      }
    }
    if (keys[2]) {
      if (rightPaddle.getY() < (getHeight1() - 180)) {
        rightPaddle.moveUpAndDraw(graphToBack);
      }
    }
    if (keys[3]) {
      if (rightPaddle.getY() > 0) {
        rightPaddle.moveDownAndDraw(graphToBack);
      }
    }
                
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch (toUpperCase(e.getKeyChar()))
    {
      case 'W' : keys[0]=true; break;
      case 'X' : keys[1]=true; break;
      case 'I' : keys[2]=true; break;
      case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
      case 'W' : keys[0]=false; break;
      case 'X' : keys[1]=false; break;
      case 'I' : keys[2]=false; break;
      case 'M' : keys[3]=false; break;
    }
  }
  public void keyTyped(KeyEvent e){}
        
  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(8);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }     
}