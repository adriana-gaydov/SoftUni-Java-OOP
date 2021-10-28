package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Card card = createCard(sc);
        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardRank(), card.getCardSuit(), card.getPower());
    }

    private static Card createCard(Scanner sc) {
        CardRanks cardRank = CardRanks.valueOf(sc.nextLine());
        CardSuits cardSuit = CardSuits.valueOf(sc.nextLine());
        return new Card(cardRank, cardSuit);
    }
}
