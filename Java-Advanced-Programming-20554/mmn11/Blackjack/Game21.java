
import javax.swing.JOptionPane;

/**
 * GUI card game 21
 * 
 * @author (amir dror) 
 * @version (2.3.2016)
 */
public class Game21
{
	private static int comCount = 2; // number of card hold by the computer
	private static final int NUMBER_LIMIT = 21;// constants 
	private static final int COMPUTER_DEFAULT = 16;
	
	public static void main(String[] args){
		do {
			DeckOfCards deck = new DeckOfCards();
			DeckOfCards player = new DeckOfCards();
			DeckOfCards computer = new DeckOfCards();

			initiate(deck,player,computer);
			play(deck,player,computer);
			result(player,computer);
			
		} while (JOptionPane.showConfirmDialog
				(null,"do you whant to play again?") == 0);
	}

	//show the players cards calculate result and declare the winner
	private static void result(DeckOfCards player, DeckOfCards computer) {
		JOptionPane.showMessageDialog(null, 
				"player cards are:\n"+ player +
				"\ncomputer cards are:\n" + computer);
		if (player.deckValue() > NUMBER_LIMIT &&
				computer.deckValue() > NUMBER_LIMIT){
			JOptionPane.showMessageDialog(null,"no winner");
		}
		else if(player.deckValue() <= NUMBER_LIMIT &&
				computer.deckValue() > NUMBER_LIMIT){
			JOptionPane.showMessageDialog(null,"player wins!!!");
		}
		else if(player.deckValue() > NUMBER_LIMIT &&
				computer.deckValue() <= NUMBER_LIMIT){
			JOptionPane.showMessageDialog(null,"computer wins");
		}
		else if(player.deckValue() > computer.deckValue()){
			JOptionPane.showMessageDialog(null,"player wins!!!");
		}
		else if(player.deckValue() < computer.deckValue()){
			JOptionPane.showMessageDialog(null,"computer wins");
		}
		else {
			JOptionPane.showMessageDialog(null,"it's a draw");
		}
		
	}
	
	// the game logic 
	private static void play(DeckOfCards deck, DeckOfCards player, DeckOfCards computer) {
		boolean p = true, c = true;
		do{
			if(p){
				p = playerTurn(deck,player);
			}
			if(c){
				c = computerTurn(deck,computer);
			}
			
		}while(p || c);	 
	}
	
	// make a computer turn  
	// logic if the computer cards value is less then COMPUTER_DEFAULT
	// 		 computer take another card
	private static boolean computerTurn(DeckOfCards deck, DeckOfCards computer) {
		if (computer.deckValue() < COMPUTER_DEFAULT){
			computer.addCardToDeck(deck.dealCard());
			comCount++;
			if (computer.deckValue() <= NUMBER_LIMIT)
				return true;
		}
		return false;
	}
	
	// make a player turn
	private static boolean playerTurn(DeckOfCards deck, DeckOfCards player) {
		
		int ans =JOptionPane.showConfirmDialog
				(null,"your cards are:\n"+ player 
						+"\n value: "+ player.deckValue()
						+"\n computer holds: " + comCount 
						+" cards\n\ndo you want another card?");
		if (ans == 0){
			player.addCardToDeck(deck.dealCard());
			if (player.deckValue() <= NUMBER_LIMIT)
				return true;
			else {
				JOptionPane.showMessageDialog(null, 
						"your cards are:\n"+ player +
						"\nmore then 21");
				return false;
			}
		}
		return false;
	}

	//initiate and shuffle the general deck 
	private static void initiate(DeckOfCards deck, DeckOfCards player, DeckOfCards computer) {
		
		deck.fillDeckOfCards();
		deck.shuffle();
	
		player.addCardToDeck(deck.dealCard());
		player.addCardToDeck(deck.dealCard());
		
		computer.addCardToDeck(deck.dealCard());
		computer.addCardToDeck(deck.dealCard());
		comCount = 2;
	}
}


	