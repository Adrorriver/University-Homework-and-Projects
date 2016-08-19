import java.util.*;
import java.security.SecureRandom;

/**
 * Represents a deck of cards
 * 
 * @author (amir dror) 
 * @version (2.3.2016)
 */

public class DeckOfCards
{
   private ArrayList<Card> deck;
   
   private static final int NUMBER_OF_CARDS = 52; // constants
   private static final int FIRST = 0;
   private static final int NUM_OF_SHUFFLE = 5;
   private static final int DEFAULT_ARRAY_SIZE = 3;
   private static final int ACE = 1;
   private static final int ACEVAL = 11;
   private static final int NUMBER_LIMIT = 21;
   
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();

   // construct empty deck of Cards 
   public DeckOfCards()
   {
	   deck = new ArrayList<Card>(DEFAULT_ARRAY_SIZE); 
   }
   
   // fills DeckOfCards in 52 game card
   public void fillDeckOfCards()
   {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

      // populate deck with Card objects
      for (int count = 0; count < NUMBER_OF_CARDS; count++) 
         deck.add(count, new Card(faces[count % 13], suits[count / 13]));          
   }
   
   //add card to deck
   public void addCardToDeck(Card card)
   {
	   deck.add(deck.size(),card);
   }
   
   //return string representation of the deck
   public String toString(){
	   String st = "";
	   for(int i=0;i < deck.size(); i++){
		   st += deck.get(i).toString() + " " +
				   deck.get(i).getValue()+"\n";
	   }
	   return st;
   }
   
   //return deck value evaluate aces ass needed
   public int deckValue(){
	   int sum = 0;
	   int card = 0;
	   int acenum = 0;
	   for (int i = 0; i < deck.size(); i++) {
		   card = deck.get(i).getValue();
		   if (card != ACE)
			   sum +=card;
		   else{
			   acenum++;
			   sum +=ACEVAL; 
		   }
	   }
	   //use the ace attribute if needed 
	   while (sum > NUMBER_LIMIT && acenum > 0 ){ //
			   sum -= ACEVAL - ACE; // -10
			   acenum--;
		   }
	   return sum;
   }

   // shuffle deck of Cards with NUMOFSHUFFLE-pass algorithm
   public void shuffle()
   {
      for (int i = 0; i < NUM_OF_SHUFFLE*deck.size(); i++) 
      {
         // select a random number between 0 and 51 
         int rand =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         // remove the first card and drop it in random place in deck
         deck.add(rand,deck.remove(FIRST));
   
      } 
   } 

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if (deck.size() > 0)
         return deck.remove(FIRST); 
      else        
         return null; // return null to indicate that all Cards were dealt
   } 
} 

