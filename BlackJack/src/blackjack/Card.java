package blackjack;

public class Card {

    private final int suit;
    private final int rank;
    private final int value;

    private final String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    
    public Card(Card C) {
        this.suit = C.suit;
        this.rank = C.rank;
        this.value = C.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    } 
}
