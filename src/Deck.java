import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> stackOfCards = new Stack<>();

    // this constructor creates a new ordered deck of cards
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

    public Deck(String order) {

    }

    public void shuffle() {
        Collections.shuffle(stackOfCards);
    }

    // removes and returns the card on the top of the deck
    public Card draw() {
        return stackOfCards.pop();
    }

    // prints out the entire deck of cards
    public void print() {
        stackOfCards.forEach(card -> {
            System.out.print(card.getName() + ", ");
        });
        System.out.println("\n");
    }
}
