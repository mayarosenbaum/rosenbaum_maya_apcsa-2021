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
import java.io.IOException;

public class Score extends Ball {
  private int left = 0;
  private int right = 0;

  public Score() {
  }

  public void addLeft() {
    left++;
  }

  public void addRight() {
    right++;
  }

  public int getLeftScore() {
    return left;
  }

  public int getRightScore() {
    return right;
  }

  //put ball in middle, face random direction
  public void go(Ball obj, int width, int height) {
    obj.setPos(width, height);
    obj.setXSpeed(2);
    obj.setYSpeed(1);
    int randomNum = (int)(Math.random() * 4);
    int randomNum2 = (int)(Math.random() * 4);
    if (randomNum % 2 == 0) {
        obj.setXSpeed(-obj.getXSpeed());
      }
      if (randomNum2 % 2 == 0) {
        obj.setYSpeed(-obj.getYSpeed());
      }
  }
  public String toString() {
    return "\nCurrent Score:\n Left - " + left + ", Right - " + right;
  }
}