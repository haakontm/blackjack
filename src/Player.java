import java.util.*;

public class Player {
    String name;
    Queue<Card> cards = new LinkedList<>();
    Integer score = 0;

    public Player(String t_name) {
        name = t_name;
    }

    public void addCard(Card t_card) {
        score += t_card.value;
        cards.add(t_card);
    }

    public void win() {
        System.out.println(name);
    }

    public void printCards() {
        System.out.print(name + ": ");
        while (cards.size() > 1) {
            Card card = cards.poll();
            System.out.print(card.name + ", ");
        }
        System.out.println(Objects.requireNonNull(cards.poll()).name);
    }
}
