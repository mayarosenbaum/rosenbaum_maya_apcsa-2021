//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;
import java.util.Random;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
		setPlayers("");
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player;
	}

	public String determineWinner()
	{
		//Random Comp Move
		String[] choices = {"R", "P", "S"};
		Random r = new Random();
		compChoice = choices[r.nextInt(choices.length)];
		
		//Determine Winner
		String winner = "";
		if (playChoice.equals(compChoice)) {
			winner = "Draw!";
		}
		else if (playChoice.equals("R")) {
			if (compChoice.equals("S")) {
				winner = "Player wins!";
			}
			else if (compChoice.equals("P")) {
				winner = "Computer wins!";
			}	
		}
		else if (playChoice.equals("P")) {
			if (compChoice.equals("R")) {
				winner = "Player wins!";
			}
			else if (compChoice.equals("S")) {
				winner = "Computer wins!";
			}	
		}
		else if (playChoice.equals("S")) {
			if (compChoice.equals("P")) {
				winner = "Player wins!";
			}
			else if (compChoice.equals("P")) {
				winner = "Computer wins!";
			}	
		}
		else {
			winner = "Invalid";
		}
		
		return winner;
	}

	public String toString()
	{
		//String output="";
		return "Player chose: " + playChoice + "\n" + 
				"Computer chose: " + compChoice + "\n" + determineWinner();
	}
}