import java.util.Collections;
import java.util.LinkedList;

/**
 * This class will contain Card objects to form a deck
 */
public class Deck {
    private LinkedList<Card> stackOfCards = new LinkedList<>();

    /**
     * constructor creates a new ordered deck of cards
     */
    public Deck() {
        char[] suit = {'C', 'D', 'H', 'S'};
        char[] value = ("A234567891JQK").toCharArray();

        for (int i = 0; i < 4; i++) {  // loop through suits
            for (int j = 0; j < 13; j++) {  // loop through values
                StringBuilder name = new StringBuilder();
                name.append(suit[i]);

                if (value[j] == '1') {  // we need an extra digit for 10
                    name.append("10");
                }
                else {
                    name.append(value[j]);
                }

                stackOfCards.push(new Card(name.toString()));
            }
        }
    }

    /**
     * constructor will create a deck based on a predefined order
     *
     * @param order sequence of cards to be added. Example: S5, D6, C5, H9, H7, C2, D3, ...
     */
    public Deck(String order) {
        String[] cards = order.split(", ");

        for (String card : cards) {
            stackOfCards.addLast(new Card(card));
        }
    }

    /**
     * Creates a new random permutation of the cards in the deck
     */
    public void shuffle() {
        Collections.shuffle(stackOfCards);
    }

    /**
     * @return removes and returns the card on the top of the deck
     */
    public Card draw() {
        return stackOfCards.pop();
    }

    /**
     * prints out the entire deck of cards
     */
    public void print() {
        stackOfCards.forEach(card -> {
            System.out.print(card.name + ", ");
        });
        System.out.println("\n");
    }
}
