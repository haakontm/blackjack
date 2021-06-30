import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // if the user has given an argument, we read the deck from a file
        if (args.length == 1) {
            try {
                File file = new File(args[0]);
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    deck = new Deck(data);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Could not find the file \"" + args[0] + "\"");
                e.printStackTrace();
                System.exit(-1);
            }
        }
        else if (args.length > 1) {
            System.out.println("One or less arguments expected.");
            System.exit(-1);
        }

        Player sam = new Player("sam");
        Player dealer = new Player("dealer");

        // sam and the dealer gets two cards each at the beginning
        sam.addCard(deck.draw());
        dealer.addCard(deck.draw());
        sam.addCard(deck.draw());
        dealer.addCard(deck.draw());

        // check if there are any winners after first draw
        if ((dealer.score == 22 || sam.score == 21) && sam.score != 22) {
            sam.win();
        }
        else if (sam.score == 22 || dealer.score == 21) {
            dealer.win();
        }

        // neither player wins after first hand. sam will start drawing cards
        else {
            while (sam.score < 17) {
                sam.addCard(deck.draw());
            }

            if (sam.score > 21) {  // sam busts
                dealer.win();
            }
            else {  // dealer will now draw cards
                while (dealer.score <= sam.score) {
                    dealer.addCard(deck.draw());
                }

                if (dealer.score <= 21) {
                    dealer.win();
                }
                else {
                    sam.win();
                }
            }
        }

        sam.printCards();
        dealer.printCards();
    }
}