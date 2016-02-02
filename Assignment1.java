import java.util.Scanner;

public class Assignment1

{
	public static void main (String[] args)
	
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Is there another customer in line? Answer 1 for yes and 2 for no.");
		int answer = keyboard.nextInt();
		
		int customer = 0;
		while(answer == 1)
		{
			customer++;
			System.out.println("Books ($5.00 each), Bookmarks ($1.00 each, or a pack of six for $5.00), Paintings of Books ($100.00 each)");
			
			int answer1, book, bookmark, painting;
			
			do
			{
			
			System.out.println("How many books would you like to purchase?");
			book = keyboard.nextInt();
			
			System.out.println("How many bookmarks would you like to purchase?");
			bookmark = keyboard.nextInt();
			
			System.out.println("How many paintings would you like to purchase?");
			painting = keyboard.nextInt();
			
			System.out.println(book + " books " + bookmark + " bookmarks " + painting + " paintings.");
			
			System.out.println("Is this order correct? Answer 1 for yes and 2 for no.");
			answer1 = keyboard.nextInt();
			} while (answer1 == 2);
			
			double bookPrice = book * 5;
			double bookmarkPrice;
			
			if (bookmark >= 6)
				bookmarkPrice = ((bookmark / 6) * 5) + (bookmark % 6);
			else
				bookmarkPrice = bookmark;
				
			double paintingPrice = painting * 100;
			
			System.out.println("You have purchased:");
			
			if (book > 0) 
				System.out.printf(book + " books $ %5.2f \n ", bookPrice);
			
			if (bookmark > 0)
				System.out.printf(bookmark + " bookmarks $ %5.2f \n ", bookmarkPrice);
				
			if (painting > 0)
				System.out.printf(painting + " paintings $ %5.2f \n ", paintingPrice);
				
			double total = bookPrice + bookmarkPrice + paintingPrice;
				
			if (customer % 3 == 0)
			{
				System.out.println("You won a 10% discount!");
				total = total * 0.9;
			}
			else 
				System.out.println("You did not get a discount! Better luck next time!");
				
			double taxedTotal = total * 1.07;
			
			System.out.printf("$ %5.2f \n ", taxedTotal);
			
			double payment;
			double change;
			
			do 
			{
			System.out.println("Please pay for your order.");
			payment = keyboard.nextDouble();
			
			if (payment >= taxedTotal)
			{
				change = payment - taxedTotal; 
				System.out.printf("Your change is: $ %5.2f \n ", change);
			
			}
			else
				System.out.println("Not enough money - please re-enter");
			} while (payment < taxedTotal);
			
		System.out.println("Is there another customer in line? Answer 1 for yes and 2 for no.");	
		answer = keyboard.nextInt();
		}
		
	}

}
			
		
		
			
		


