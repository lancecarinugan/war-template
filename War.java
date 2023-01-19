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
    Deck cardForGrab = new Deck();
    public War()
    {
        // Initializations here...
        Deck[] player;
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        player = deck.dealDeck();
        Deck pCard1 = player[0];
        Deck pCard2 = player[1];
        // ...then run the event loop
        this.runEventLoop (pCard1, pCard2);
    }
    
    public void runEventLoop(Deck pDeck1, Deck pDeck2) {
        Card card1;
        Card card2;
        System.out.println ("This is the card game War!");
         // Gets and prints the size of both player's decks
        System.out.println ("Player 1 Card Amount: " + pDeck1.getDeckSize());
        System.out.println ("Player 2 Card Amount: " + pDeck2.getDeckSize());
        System.out.println ("[BEGIN!]");
        for (int turns = 1; turns <= 300; turns++) {
            //check win w/ deck size
            if (pDeck1.getDeckSize() == 0 ) {
               System.out.println ("Player 1 has ran out of cards, Player 2 WINS!");
                break;
            } else if (pDeck2.getDeckSize() == 0) {
                System.out.println ("Player 2 has ran out of cards, Player 1 WINS!");
                break;
            } else {
                // Start the game
                System.out.println ("\n[Round: " + turns + "]");
                card1 = pDeck1.dealCardFromDeck();
                card2 = pDeck2.dealCardFromDeck();
                System.out.println ("Player 1 drew: " + card1.getFace() + " of " + card1.getSuit());
                System.out.println ("Player 2 drew: " + card2.getFace() + " of " + card2.getSuit());
                //check rank / for win
                if (card1.getRank() > card2.getRank()) {
                    pDeck1.addCardToDeck(card1);
                    pDeck1.addCardToDeck(card2);
                    System.out.println("Player 1's Deck Size: " + pDeck1.getDeckSize() + " cards");
                    System.out.println("Player 2's Deck Size: " + pDeck2.getDeckSize() + " cards");
                    System.out.println ("Player 1 Won the Battle!");
                    //check rank / for win
                } else if (card2.getRank() > card1.getRank()) {
                    pDeck2.addCardToDeck(card1);
                    pDeck2.addCardToDeck(card2);
                    System.out.println("Player 1's Deck Size: " + pDeck1.getDeckSize() + " cards");
                    System.out.println("Player 2's Deck Size: " + pDeck2.getDeckSize() + " cards");
                    System.out.println ("Player 2 Won the Battle!");
                } else {
                    war(pDeck1,pDeck2,card1,card2);
                    }
                }
            }
        }

    public void war(Deck pDeck1, Deck pDeck2, Card card1, Card card2) {
        System.out.println ("A tie indeed. Begin the WAR!");
        if (pDeck1.getDeckSize() >= 4 && pDeck2.getDeckSize() >= 4) {
            cardForGrab.addCardToDeck(card1);
            cardForGrab.addCardToDeck(card2);
            for (int i = 0; i < 3; i++) {
                cardForGrab.addCardToDeck(pDeck1.dealCardFromDeck());
            }
            for (int i = 0; i < 3; i++) {
                cardForGrab.addCardToDeck(pDeck2.dealCardFromDeck());
            }
            Card card1Top = pDeck1.dealCardFromDeck();
            Card card2Top = pDeck2.dealCardFromDeck();
            cardForGrab.addCardToDeck(card1Top);
            cardForGrab.addCardToDeck(card2Top);
            System.out.println("Player 1's Top Card = " + card1Top.getFace() + " of " + card1Top.getSuit());
            System.out.println("Player 2's Top card = " + card2Top.getFace() + " of " + card2Top.getSuit());
            int size;
            if (card1Top.getRank() == card2Top.getRank()) {
                war2(pDeck1, pDeck2, card1Top, card2Top);
            } else if (card1Top.getRank() > card2Top.getRank()) {
                System.out.println ("Player 1 Won the War!");
                size = cardForGrab.getDeckSize();
                for (int i = 0; i < size; i++) {
                    pDeck1.addCardToDeck(cardForGrab.dealCardFromDeck());
                }
                System.out.println("Player 1's Deck Size:" + pDeck1.getDeckSize());
                System.out.println("Player 2's Deck Size:" + pDeck2.getDeckSize());
            } else if (card1Top.getRank() < card2Top.getRank()) {
                System.out.println ("Player 2 Won the War!");
                size = cardForGrab.getDeckSize();
                for (int i = 0; i < size; i++) {
                    pDeck2.addCardToDeck(cardForGrab.dealCardFromDeck());
                }
                System.out.println("Player 1's Deck Size:" + pDeck1.getDeckSize());
                System.out.println("Player 2's Deck Size: " + pDeck2.getDeckSize());
            }

        } else if (pDeck2.getDeckSize() > 4) {
            //System.out.println("Player 1's Deck Size = " + d1.getDeckSize());
            //System.out.println("Player 2's Deck Size = " + d2.getDeckSize());
            //System.out.println("Not enough cards for War, Player 2 Wins");
            int test = pDeck1.getDeckSize();
            for (int i = 0; i < test; i++) {
                pDeck2.addCardToDeck(pDeck1.dealCardFromDeck());
            }
            System.out.println("Player 1 Is Not Eligible for War. Player 2 WINS.");
        } else {
            //System.out.println("Player 1's Deck Size = " + d1.getDeckSize());
            //System.out.println("Player 2's Deck Size = " + d2.getDeckSize());
            //System.out.println("Not enough cards for War, Player 1 Wins");
            int test = pDeck2.getDeckSize();
            for (int i = 0; i < test; i++) {
                pDeck1.addCardToDeck(pDeck2.dealCardFromDeck());
            }
            System.out.println("Player 2 is Is Not Eligible for War. Player 1 WINS.");
        }
    }
    
    public void war2(Deck pDeck1, Deck pDeck2, Card card1, Card card2) {
        System.out.println("War");

        if (pDeck1.getDeckSize() >= 4 && pDeck2.getDeckSize() >= 4) {
            for (int i = 0; i < 3; i++) {
                cardForGrab.addCardToDeck(pDeck1.dealCardFromDeck());
            }
            for (int i = 0; i < 3; i++) {
                cardForGrab.addCardToDeck(pDeck2.dealCardFromDeck());
            }
            Card card1Top = pDeck1.dealCardFromDeck();
            Card card2Top = pDeck2.dealCardFromDeck();
            cardForGrab.addCardToDeck(card1Top);
            cardForGrab.addCardToDeck(card2Top);
            System.out.println("Player 1's Top card: " + card1Top.getFace() + " of " + card1Top.getSuit());
            System.out.println("Player 2's Top card: " + card2Top.getFace() + " of " + card2Top.getSuit());
            int size;
            if (card1Top.getRank() == card2Top.getRank()) {
                war(pDeck1, pDeck2, card1, card2);
            } else if (card1Top.getRank() > card2Top.getRank()) {
                System.out.println("Player 1 Won the War!");
                size = cardForGrab.getDeckSize();
                for (int i = 0; i < size; i++) {
                    pDeck1.addCardToDeck(cardForGrab.dealCardFromDeck());
                }
                System.out.println("Player 1's Deck Size: " + pDeck1.getDeckSize());
                System.out.println("Player 2's Deck Size: " + pDeck2.getDeckSize());
            } else if (card1Top.getRank() < card2Top.getRank()) {
                System.out.println("Player 2 Won the War!");
                size = cardForGrab.getDeckSize();
                for (int i = 0; i < size; i++) {
                    pDeck2.addCardToDeck(cardForGrab.dealCardFromDeck());
                }
                System.out.println("Player 1's Deck Size: " + pDeck1.getDeckSize());
                System.out.println("Player 2's Deck Size: " + pDeck2.getDeckSize());
            }

        } else if (pDeck2.getDeckSize() > 4) {
            //System.out.println("Player 1's Deck Size = " + d1.getDeckSize());
            //System.out.println("Player 2's Deck Size = " + d2.getDeckSize());
            //System.out.println("Not enough cards for War, Player 2 Wins");
            int test = pDeck1.getDeckSize();
            for (int i = 0; i < test; i++) {
                pDeck2.addCardToDeck(pDeck1.dealCardFromDeck());
            }
            //System.out.println("Player 1 Does Not Have Enough Cards For War");
        } else {
            //System.out.println("Player 1's Deck Size = " + d1.getDeckSize());
            //System.out.println("Player 2's Deck Size = " + d2.getDeckSize());
            //System.out.println("Not enough cards for War, Player 1 Wins");
            int test = pDeck2.getDeckSize();
            for (int i = 0; i < test; i++) {
                pDeck1.addCardToDeck(pDeck2.dealCardFromDeck());
            }
            //System.out.println("Player 2 Does Not Have Enough Cards For War");
        }
    }
    
    public static void main(String[] args) {
        System.out.print("\u000C");
        War war = new War();
    }
}