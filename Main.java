//Write a Program DeckOfCards.java, to initialize deck of cards having suit
//("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8",
// "9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random
// method and then distribute 9 Cards to 4 Players and Print the Cards received by
//the 4 Players using 2D Array...
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class DeckOfCards {
    static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static List<String> initializeDeck() {
        List<String> deck = new ArrayList<>();

        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + " of " + suit);
            }
        }

        return deck;
    }

    public static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck, new Random());
    }

    public static String[][] distributeCards(List<String> deck, int numPlayers, int cardsPerPlayer) {
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playersCards[i][j] = deck.remove(0);
            }
        }

        return playersCards;
    }
}

class DeckOfCardsTest {
    public static void main(String[] args) {
        List<String> deck = DeckOfCards.initializeDeck();
        DeckOfCards.shuffleDeck(deck);

        int numPlayers = 4;
        int cardsPerPlayer = 9;

        String[][] playersCards = DeckOfCards.distributeCards(deck, numPlayers, cardsPerPlayer);

        // Print the cards received by each player
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " + Arrays.toString(playersCards[i]));
        }
    }
}