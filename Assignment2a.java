import java.util.Scanner;
import java.util.Random;

public class Assignment2a

{
	
	public static void main (String[] args)
	
	{
		
		String username;
		int money;
		int bet;
		int userwin;
		int handsplayed = 0;
		int handswon = 0;
		
		System.out.println("Blackjack. Good luck!");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your name.");
		username = keyboard.next();
		
		System.out.println("Welcome, " + username);
		
		money = 50;
		
		bet = 5;
		
		while(money > 0)
		{
			
			System.out.println("Name: " + username);
			System.out.println("Total Hands Played: " + handsplayed);
			System.out.println("Total Hands Won: " + handswon);
			System.out.println("Money: " + money + " dollars.");
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Would you like to play a round? (Y/N)");
			String reply = scan.next();
			
			if (reply.equals("Y") || reply.equals("y") || reply.equals("Yes") || reply.equals("yes")) 
			{
				System.out.println("Ok let's play!");
			}
			
			while (bet > money || bet < 0);
			{
			Scanner table = new Scanner(System.in);
			System.out.println("How much would you like to bet?");
			bet = table.nextInt();
		
			while (bet < 0 || bet > money)
			{
				System.out.println("That is an invalid bet. Please enter a valid bet.");
				
				System.out.println("How much would you like to bet?");
				bet = table.nextInt();
			}
			
			System.out.println("That is a valid bet. Have fun!");
		
			}
			
			userwin = playblackjack();
			
			if (userwin == 0)
			{
				money = money + ((bet * 3)/2);
				handsplayed += 1;
				handswon += 1;
			}
			else
				if (userwin == 1)
				{
					money = money + bet;
					handsplayed += 1;
					handswon += 1;
				}
				else 
					if (userwin == 2)
					{
						money = money - bet;
						handsplayed += 1;
					}
					else
					{
						money = money;
						handsplayed += 1;
					}
			
			if (money == 0)
			{
				System.out.println("You have no money left! Thanks for playing.");
				break;
			}
			
		}
	
	}
	
	private static int playblackjack()
	
	{
		
		int userhandval = 0;
		int userhandval2 = 0;
		int userhandvalt = 0;
		int dealerhandval = 0;
		int dealerhandval2 = 0;
		int dealerhandvalt = 0;
	
		userhandval = getcard();
		userhandval2 = getcard();
		userhandvalt = userhandval + userhandval2;
		
		System.out.println("Your hand value is " + userhandvalt);
		
		if (userhandvalt == 21)
		{
			System.out.println("You have Blackjack! You win this round.");
			return 0;
		}
		else
			while (userhandvalt < 21)
			{
			
				Scanner scan = new Scanner(System.in);
				System.out.println("Would you like to Hit or Stay?");
				String answer = scan.nextLine();
			
				if (answer.equals("H") || answer.equals("h") || answer.equals("Hit") || answer.equals("hit"))
				{
					System.out.println("You have chosen to hit.");
					userhandvalt = userhandvalt + getcard();
					System.out.println("Your hand value is " + userhandvalt + ".");
						
					if (userhandvalt > 21)
					{
						System.out.println("You have busted. You lose this round.");
						break;
					}
					
				}
				else
					if (answer.equals("S") || answer.equals("s") || answer.equals("Stay") || answer.equals("stay"))
					{
						System.out.println("You have chosen to stay.");
						System.out.println("Your hand value is " + userhandvalt + ".");
						break;
					}
					else
					{
						System.out.println("Please decide whether you'd like to Hit or Stay.");
					}
		
			}
		
		
		dealerhandval = getcard();
		dealerhandval2 = getcard();
		dealerhandvalt = dealerhandval + dealerhandval2;
		
		if (dealerhandvalt == 21)
		{
			System.out.println("The dealer has Blackjack. You lose this round.");
			return 2;
		}
		
		if (dealerhandvalt >= 18 || dealerhandvalt < 21)
		{
			dealerhandvalt = dealerhandvalt;
			System.out.println("The dealer's hand value is " + dealerhandvalt + ".");
		}
		
		while (dealerhandvalt < 17)
		{
			dealerhandvalt += getcard();
			System.out.println("The dealer's hand value is " + dealerhandvalt + ".");
			if (dealerhandvalt > 21)
			{
				System.out.println("The dealer has busted. You win this round.");
				return 1;
			}
		}
		
		if (dealerhandvalt == 17 && drawCard() == 1)
		{
			dealerhandvalt += getcard();
			System.out.println("The dealer's hand value is " + dealerhandvalt + ".");
			if (dealerhandvalt > 21)
			{
				System.out.println("The dealer has busted. You win this round.");
				return 1;
			}
		}
		else
		{
			dealerhandvalt = dealerhandvalt;
		}
		
		if (userhandvalt > dealerhandvalt && userhandvalt < 22)
		{
			System.out.println("Your hand value is greater than the dealer's! You win this round.");
			return 1;
		}
		else
			if (userhandvalt < dealerhandvalt && dealerhandvalt < 22)
			{
				System.out.println("The dealer's hand value is greater than yours. You lose this round.");
				return 2;
			}
			else
			{
				System.out.println("Your hand value is equal to the dealer's. Push.");
				return 3;
			}
		
	}
	
	private static int getcard()
	
	{
		
		String suit = drawSuit();
		int points = drawCard();
		String num = drawNum();
		
		if (points == 11)
		{
			points = 10;
		}
		else
			if (points == 12)
			{
				points = 10;
			}
			else
				if (points == 13)
				{
					points = 10;
				}
				else
					if(points == 14)
					{
						points = 11;
					}
					else
					{
						points = points;
					}
		
		switch(points)
		{
		case 1:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 1;
		case 2:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 2;
		case 3:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 3;
		case 4:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 4;
		case 5:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 5;
		case 6:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 6;
		case 7:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 7;
		case 8:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 8;
		case 9:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 9;
		case 10:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 10;
		case 11:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 10;
		case 12:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 10;
		case 13:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 10;
		case 14:
			System.out.println("The card drawn is the " + num + " of " + suit + " which is worth " + points + " point(s).");
			return 10;
		default:
			return 0;
		}

	}
	
	private static String drawNum()
	{
		
		switch(randomDraw())
		{
		case 1:
			return "Ace";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		case 14:
			return "Ace";
		default:
			return " ";
		}
		
	}
		
	
	private static String drawSuit()
	{
		int cake;
		Random rand = new Random();
		
		cake = rand.nextInt(4);
		
		switch(cake)
		{
		case 0:
			return "Spades";
		case 1:
			return "Diamonds";
		case 2:
			return "Clubs";
		case 3:
			return "Hearts";
		default:
			return " ";
		}
		
	}
	
	private static int randomDraw()
	{
		int rando;
		Random rand = new Random();
		rando = rand.nextInt(14);
		return rando;
	}
	
	private static int drawCard()	
	{
		
		switch(randomDraw())
		{
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 3;
		case 3:
			return 4;
		case 4:
			return 5;
		case 5:
			return 6;
		case 6:
			return 7;
		case 7:
			return 8;
		case 8:
			return 9;
		case 9:
			return 10;
		case 10:
			return 11;
		case 11:
			return 12;
		case 12:
			return 13;
		case 13:
			return 14;
		default:
			return 0;
		}

	}
	
}
		