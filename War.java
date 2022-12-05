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
public class War
{
    Deck[] players;
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
        players = deck.dealDeck();
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        Deck.shuffle();
        System.out.println("Deal deck.." + dealDeck);
    for (int turns = 0; turns < 300; turns++) {
        if (players[1].getDeckSize() == 0) {
            System.out.println ("Player 1 won the battle");
            break;
        }
        else if (players[0].getDeckSize() == 0) {
            System.out.println ("Player 2 won the battle");
            break;
        }
        else 
            System.out.println
            
           
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
