public class Card {
    String name;  // name of the card. ex "C9"
    int value;    // value of the card. 10-King is worth 10, Ace is 11

    /**
     * constructor assigns the correct value based on the name
     *
     * @param t_name name of the card. ex "D10"
     */
    public Card(String t_name) {
        this.name = t_name;

        // last character in name decides value
        switch (t_name.charAt(1)) {
            case 'J', 'Q', 'K' -> value = 10;
            case 'A' -> value = 11;
            default -> value = Integer.parseInt(t_name.substring(1));
        }
    }
}
