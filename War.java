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
    Card heartCard;
    Card diamondCard;
    Card spadeCard;
    Card clubCard;
    int countingPlays = 0;
    
    Scanner keyboard = new Scanner(System.in);
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        
        // Creates a Deck Array
        Deck deckOfCards = new Deck(); 
    
        // Creates Player 1's Deck
        Deck p1Pile = new Deck();
        
        // Creates Player 2's Deck
        Deck p2Pile = new Deck();
        
        Deck dealDeck;
        
        Deck shuffle;
    
        
        for(int i = 2; i< 15; i++)
        {
                
        }
    

        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        deckOfCards.shuffle();
        System.out.println("Deal deck.." + dealDeck);

    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
        war.runEventLoop();
    }

}
