import java.awt.Color;
import java.awt.Graphics;

public interface Collidable<Object> {
  boolean didCollideLeft(Object obj);
  boolean didCollideRight(Object obj);
  boolean didCollideTop(Object obj);
  boolean didCollideBottom(Object obj);
}