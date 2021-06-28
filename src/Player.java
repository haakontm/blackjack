import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> cards = new ArrayList<>();
    Integer score = 0;
    Boolean hit = true;
    Boolean blackjack = false;
    Boolean busted = false;

    public Player(String t_name) {
        name = t_name;
    }

    public void addCard(Card t_card) {
        score += t_card.getValue();
        cards.add(t_card);

        if (score >= 17) {
            hit = false;
            if (score == 21) {
                blackjack = true;
            }
            else if (score > 21) {
                busted = true;
            }
        }
    }

    public void win() {
        System.out.println(name);
    }

    public int getScore() {
        return score;
    }
}
