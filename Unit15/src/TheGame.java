import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;

public class TheGame extends JFrame {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private static int customWidth;
  private static int customHeight;
  private static int choice;

  public TheGame() {
    super("PONG");
    Pong game = new Pong(customWidth, customHeight, choice);
    
    if (customWidth == 0 && customHeight == 0) {
      setSize(WIDTH,HEIGHT);
    }
    else {
      setSize(customWidth,customHeight);
    }
    //setSize(WIDTH,HEIGHT);

    //Pong game = new Pong();

    ((Component)game).setFocusable(true);
    getContentPane().add(game);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main( String args[] )
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Welcome to pong!\nChoose a ball, 0-regular, 1-blinky, 2-speedup: ");

    choice = scan.nextInt();
    System.out.print("Enter width: (0-default): ");
    customWidth = scan.nextInt();
    System.out.print("Enter height: (0-default): ");
    customHeight = scan.nextInt();

    System.out.println("\nStarting the game...");

    
    TheGame run = new TheGame();
    
    
  }
}