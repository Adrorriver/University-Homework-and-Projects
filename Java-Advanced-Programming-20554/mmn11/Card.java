
/**
 * Represents a playing card with relevant methods
 * 
 * @author (amir dror) 
 * @version (2.3.2016)
 */


public class Card 
{
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)

   private static final int NUMBERS = 10;
   private static final int IMAGE = 13; 
   private static final int IMAGEVAL = 10;
   
   // two-argument constructor initializes card's face and suit
   public Card(String face, String suit)
   {
      this.face = face;
      this.suit = suit; 
   } 

   // return String representation of Card
   public String toString() 
   { 
      return face + " of " + suit;
   } 
   
   //return the card value in the game - ace return 1
   public int getValue(){
	   String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
		         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	   for (int i=0; i < NUMBERS; i++ ){
		   if (face.equals(faces[i]))
				   return i+1;
	   }
	   for (int i=NUMBERS; i < IMAGE; i++ ){
		   if (face.equals(faces[i]))
				   return IMAGEVAL;
	   }
	   return -1; //error
   }
} 

