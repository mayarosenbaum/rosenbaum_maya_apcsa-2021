import java.util.Scanner;

/**
 * Wrapper class for simple console input
 */
public class ConsoleInput
{
  private Scanner ins;
  private String line;

  ConsoleInput()
  {
    ins = new Scanner(System.in);
  }

  // use this to read input
  public String read()
  {
    line = ins.nextLine();
    return line;
  }

  // after calling read() use to check if an int has been input
  public boolean validInt()
  {
    return (line != null && line.matches("\\d+"));
  }

  // get the int - should only call after testing validInt above
  public Integer getInt()
  {
    return Integer.valueOf(line);
  }
}