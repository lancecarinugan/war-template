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
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck[] player = new Deck[2]; 
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        player = deck.dealDeck();
        Deck card1 = player[0];
        Deck card2 = player[1];
        // ...then run the event loop
        this.runEventLoop();
    } 

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {    
        // Starts the Game
        System.out.println ("This is the card game War!");

        // Gets and prints the size of both player's decks
        System.out.println ("Deck Count..");
        System.out.println ("Player 1 Beginning Card Amount: " + player[0].getDeckSize());
        System.out.println ("Player 2 Beginning Card Amount: " + player[1].getDeckSize());
        System.out.println();
        System.out.println ("BEGIN!");
        // If a player runs out of cards, the other wins automatically.
        for (int turns = 1; turns <= 300; turns++) {
            if (player[0].getDeckSize() == 0) {
                System.out.println ("Player 1 has ran out of cards, Player 2 WINS!");
                break;
            }
            else if (player[1].getDeckSize() == 0) {
                System.out.println ("Player 2 has ran out of cards, Player 1 WINS!");
                break;
            }
            else {
                System.out.println ("\n[Round: " + turns + "]");
                Card card1 = player[0].dealCardFromDeck();
                Card card2 = player[1].dealCardFromDeck();
                System.out.println ("Player 1 drew: " + card1.getFace() + " of " + card1.getSuit());
                System.out.println ("Player 2 drew: " + card2.getFace() + " of " + card2.getSuit());
                if (card1.getRank() > card2.getRank()) {
                    player[0].addCardToDeck(card1);
                    player[0].addCardToDeck(card2);
                    System.out.println ("Player 1 Won the Battle!");
                }
                else if (card1.getRank() < card2.getRank()) {
                    player[1].addCardToDeck(card1);
                    player[1].addCardToDeck(card2);
                    System.out.println ("Player 1 drew: " + card1);
                    System.out.println ("Player 2 drew: " + card2);
                    System.out.println ("Player 2 Won the Battle!");
                }
                else {
                    Deck warCards = new Deck(); 
                    int warCardslen = warCards.getDeckSize();
                    warCards.addCardToDeck(card1);
                    warCards.addCardToDeck(card2);
                    System.out.println ("A tie indeed. Begin the WAR!");
                    if (player[0].getDeckSize() < 4) {
                        System.out.println("Player 1 Is Not Eligible for War. Player 2 WINS.");
                        player[1].addCardToDeck(card2);
                        break;
                    }
                    else if (player[1].getDeckSize() < 4) {
                        System.out.println("Player 2 is Is Not Eligible for War. Player 1 WINS.");
                        player[0].addCardToDeck(card1);
                        break;
                    }
                    else { 
                        for (int x=0; x<4; x++) {
                            card1 = player[0].dealCardFromDeck();
                            card2 = player[1].dealCardFromDeck();
                            warCards.addCardToDeck(card1);
                            warCards.addCardToDeck(card2);
                        }
                        card1 = player[0].dealCardFromDeck();
                        card2 = player[1].dealCardFromDeck();
                        System.out.println("Player 1: " + card1.getFace() + " of " + card1.getSuit());
                        System.out.println("Player 2: " + card2.getFace() + " of " + card2.getSuit());
                        if (card1.getRank() > card2.getRank()) {
                            player[0].addCardToDeck(card1);
                            System.out.println ("Player 1 Won the War!");
                        }
                        else if (card1.getRank() < card2.getRank()) {
                            player[1].addCardToDeck(card2);
                            System.out.println ("Player 2 Won the War!");
                        }
                        if (turns >= 300) {
                            if (player[0].getDeckSize() > player[1].getDeckSize()) {
                                System.out.println("300 Rounds has passed.. CONGRATULATIONS Player 1 for having the most cards! Winner Winner Chicken Dinner!");
                                break;
                            }
                            else {
                                System.out.println("300 Rounds has passed.. CONGRATULATIONS Player 2 for having the most cards! Winner Winner Chicken Dinner!");
                                break;
                            }
                        }
                    }
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
        System.out.println("\u000c");
    }
    } 
