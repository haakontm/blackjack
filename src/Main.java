public class Main {
    static Player sam;
    static Player dealer;

    public static void main(String[] args) {
        Deck deck;

        if (args.length > 0) {
            // read the file
            System.out.println(args[0]);
        }
        else {
            // create new deck
        }

        deck = new Deck();
        deck.shuffle();

        sam = new Player("sam");
        dealer = new Player("dealer");

        // sam and the dealer gets two cards each at the beginning
        sam.addCard(deck.draw());
        dealer.addCard(deck.draw());
        sam.addCard(deck.draw());
        dealer.addCard(deck.draw());
    }
}