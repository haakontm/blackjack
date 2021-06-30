import java.util.LinkedList;
import java.util.Objects;

public class Player {
    String name;
    LinkedList<Card> hand = new LinkedList<>();  // cards end up here after they are drawn from the deck
    Integer score = 0;  // the total value of the hand

    /**
     * class constructor
     *
     * @param t_name name of the player
     */
    public Player(String t_name) {
        name = t_name;
    }

    /**
     * this will add a card to the players hand and update the score
     *
     * @param t_card the card to be added
     */
    public void addCard(Card t_card) {
        score += t_card.value;
        hand.add(t_card);
    }

    /**
     * when a player wins we simply print out the name
     */
    public void win() {
        System.out.println(name);
    }


    /**
     * prints out the players hand
     */
    public void printHand() {
        System.out.print(name + ": ");
        while (hand.size() > 1) {
            Card card = hand.poll();
            System.out.print(card.name + ", ");
        }
        System.out.println(Objects.requireNonNull(hand.poll()).name);
    }
}
