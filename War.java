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
    Deck p1, p2;
    Card p1Card, p2Card;
    Deck theDeck;
    ArrayList <Card> p1Pile, p2Pile; // List to hold cards when war happens
    boolean justFought; // Boolean to know if a war just happened in the game loop
    
    Scanner keyboard = new Scanner(System.in);
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        justFought = false;
        p1Pile = new ArrayList<Card>();
        p2Pile = new ArrayList<Card>();
        p1 = new Deck();
        p2 = new Deck();
        String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
        String[] faces = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        int[] ranks = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        theDeck = new Deck (ranks, faces, suits);
        theDeck.shuffle();
        for (int i = 0; i < 26; i++) // Distributes Cards to Player's Hands
        {
            p1.getCard(theDeck.deal());
            p2.getCard(theDeck.deal());
        }
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        theDeck.shuffle();
        System.out.println("Deal deck.." + dealDeck);
        
        for(int j = 0; j<=25; j++) {
            String card1 = p1Pile[j];
            String card2 = p2Pile[j];
            
            System.out.println("Player 1 drew" + card1);
            System.out.println("Player 2 drew" + card2);
            
            if(isFaceCard(card1) && isFaceCard(card2)) {
                // Compare face cards
                int player1Value = getFaceCardValue(card1);
                int player2Value = getFaceCardValue(card2);
                if (player1Value > player2Value) {
                    player1Score++;
                    System.out.println("Player 1 won the round.");
                } else if (player2Value > player1Value) {
                    player2Score++;
                    System.out.println("Player 2 won the round.");
                } else {
                    System.out.println("This round is a tie.");
                }
            }
            
        }
        
        
        
        
        
        
        

    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
        war.runEventLoop();
    }

}
