import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import java.text.NumberFormat;
import java.io.IOException;
import java.util.Locale;
import java.text.DecimalFormat;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War {
Deck[] player;
Scanner keyboard = new Scanner(System.in);
/**
 * Constructor for the game
 * Include your initialization here -- card decks, shuffling, etc
 * Run the event loop after you've done the initializations
 */
    public War()
    {
        // Initializations here...
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        player = deck.dealDeck();
        // ...then run the event loop
        this.runEventLoop();
    } 
/**
 * This is the game's event loop. The code in here should come
 * from the War flowchart you created for this game
 */
    public void runEventLoop() {
    // If a player runs out of cards, the other wins automatically.
    for (int turns = 0; turns <= 300; turns++) {
        if (player[0].getDeckSize() == 0) {
            System.out.println ("Player 2 won the game!");
            break;
        }
        else if (player[1].getDeckSize() == 0) {
            System.out.println ("Player 1 won the game!");
            break;
        }
        else {
            Card player1 = player[0].dealCardFromDeck();
            Card player2 = player[1].dealCardFromDeck();
            System.out.println("Player 1: " + player1.getFace() + " of " + player1.getSuit());
            System.out.println("Player 2: " + player2.getFace() + " of " + player2.getSuit());
        }        
    }
}
/**
 * The main method is called when Java starts your program
 */
    public static void main(String[] args) {
        War war = new War();
        war.runEventLoop();
        System.out.println("\u000c");
    }
}
