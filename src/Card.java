public class Card {
    String name;  // name of the card. ex "C9"
    int value;    // value of the card. 10-King is worth 10, Ace is 11

    public Card(String t_name) {
        this.name = t_name;

        switch (t_name.charAt(1)) {  // last character in name decides value
            case 'J', 'Q', 'K':
                value = 10;
                break;
            case 'A':
                value = 11;
                break;
            default:
                value = Integer.parseInt(t_name.substring(1));
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
