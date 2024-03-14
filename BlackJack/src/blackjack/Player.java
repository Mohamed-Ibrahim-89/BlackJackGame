package blackjack;

public class Player {
    public String name;
    public int score = 0;
    private Card[] playerHand = new Card[11];
    private int counter = 0;

    public Card[] getPlayerHand() {
        return this.playerHand;
    }

    public void giveCard(Card c){
        if(counter < 11){
            playerHand[counter] = c;
            counter++;
            score += c.getValue();
        }
    }
}
