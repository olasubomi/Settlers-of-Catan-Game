/*WARNING: Be careful when modifiying this file on Dropbox!! If more than one person is modifiying it at a time and you
 * both save, then there is a chance for data loss and we all lose! Make sure to save a local copy first!*/
 
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.*;

public class SettlersCatanGame extends WindowController implements ActionListener, CatanController //, ActionListener
{
 	private static Player playerOne;
 	private static Player playerTwo;
 	private static Player playerThree;
 	private static Player playerFour;
 	private JButton addRCard;
 	private JButton addDCard;
 	private JButton swapDisplays;
 	private static ArrayList<String> names;
 
	public void begin()
	{
  		playerOne = new Player(1, names.get(0), canvas);
  		playerTwo = new Player(2, names.get(1), canvas);
  		playerThree = new Player(3, names.get(2), canvas);
  		if (names.size() == 4)
  			playerFour = new Player(4, names.get(3), canvas);
		playerOne.addCard(2);
		playerOne.addCard(1);
		playerOne.addCard(3);	
		playerOne.addDevelopmentCard();
		playerOne.addDevelopmentCard();
		playerOne.addDevelopmentCard();
		playerOne.displayResourceHand();
		
		Container contentPane = getContentPane();
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		JPanel rightPanel = new JPanel(new GridLayout(5, 1));
		addRCard  = new JButton("Add Resource Card");
		addRCard.addActionListener(this);
		addDCard  = new JButton("Add Development Card");
		addDCard.addActionListener(this);
		swapDisplays  = new JButton("Swap Displays");
		swapDisplays.addActionListener(this);
		rightPanel.add(addRCard);
		rightPanel.add(addDCard);
		rightPanel.add(swapDisplays);
		contentPane.add(rightPanel, BorderLayout.EAST);

		validate();
		/*
		addRCard = new FilledRect(new Location(30,130), 50, 50, canvas);
		addRCard.setColor(new Color(30, 100, 200));
		addDCard = new FilledRect(new Location(100,130), 50, 50, canvas);
		addDCard.setColor(new Color(200, 30, 10));
		swapDisplays = new FilledRect(new Location(170,130), 50, 50, canvas);
		swapDisplays.setColor(new Color(50, 30,150));
		//new ResourceCard(3, canvas).displayCard(new Location (500, 300));
		*/
	}

	public void actionPerformed(ActionEvent evt) 
	{
        	if (evt.getSource() == addRCard)
		{
			playerOne.addCard((int)(Math.random()*5 + 1));
		}
		else if(evt.getSource() == addDCard)
		{
			playerOne.buyDevelopmentCard();
		}
		else if(evt.getSource() == swapDisplays)
		{
			if (playerOne.displayingResourceCards == true)
			{
				playerOne.displayDevelopmentHand();
			}
			else
			{
				playerOne.displayResourceHand();
			}
		}
    	}
	
	/*
	public void onMouseClick(Location point)
	{
		//playerOne.buyItem(ROAD);
		if (addRCard.contains(point))
		{
			playerOne.addCard((int)(Math.random()*5 + 1));
		}
		if (addDCard.contains(point))
		{
			playerOne.buyDevelopmentCard();
		}
		if (swapDisplays.contains(point))
		{
			if (playerOne.displayingResourceCards == true)
			{
				playerOne.displayDevelopmentHand();
			}
			else
			{
				playerOne.displayResourceHand();
			}
		}
		addRCard = new FilledRect(new Location(30,130), 50, 50, canvas);
		addRCard.setColor(new Color(30, 100, 200));
		addDCard = new FilledRect(new Location(100,130), 50, 50, canvas);
		addDCard.setColor(new Color(200, 30, 10));
		swapDisplays = new FilledRect(new Location(170,130), 50, 50, canvas);
		swapDisplays.setColor(new Color(50, 30,150));
	}
	*/
 
	public static void main(String[] args)
	{
		int numPlayers;
  		Scanner scanner = new Scanner(System.in);
  		System.out.println("Welcome to Settlers of Catan!  \nHow many players will be playing?" +
       				   " (Pick between 3-4)");
  		names = new ArrayList<String>();
  		while(true)
  		{
   			numPlayers = scanner.nextInt();
   			if (numPlayers == 3 || numPlayers == 4)
   			{
	   			break;
   			}
   			else
   			{
	  			System.out.println("Please pick a number of players between 3 and 4");
   			}
  		}
  		System.out.println("");
  		for(int playerIndex = 0; playerIndex < numPlayers; playerIndex++)
  		{
   			while(true)
	  		{
	  			Scanner scanner2 =  new Scanner(System.in);
	    			System.out.println("Player " + (playerIndex + 1) + " Please enter your name.");
	    			String name = scanner2.nextLine();
	    			if (name.equals(""))
	    			{
	      				System.out.println("You must input a name");
	    			}
	    			else
	    			{
	      				names.add(name);
	      				break;
	   			}
	  		}
	 	 }
		System.out.println("\nGame Setup Complete. Let the game begin!");
		new SettlersCatanGame().startController(1300, 800);
		//SettlersCatanGame settlers = new SettlersCatanGame();
		//SwingUtilities.invokeLater(settlers);
	}
} 
