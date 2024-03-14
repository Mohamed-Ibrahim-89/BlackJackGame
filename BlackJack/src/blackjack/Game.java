package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public Player[] players = new Player[4];
    public Card[] cardDeck = new Card[52];
    int[] highScore = new int[4];
    
    public void genCardDeck(){
        int index = 0;
        for(int suit = 0; suit < 4; suit++){
            for(int rank = 0; rank < 13; rank++){
                int value = (rank < 10)? rank+1 : 10;
                Card card = new Card(suit, rank, value);
                 cardDeck[index++] = card;
            }
        }
    }
    public Card drowCard(){
        Card c = null;
        Random rand = new Random();
        do{
            int randChoice = rand.nextInt(51);
            c = cardDeck[randChoice];
            cardDeck[randChoice] = null;
            
        }while(c == null);
        return c;
    } 
    public void setInfo(){
        Scanner Input = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            System.out.print("Please Enter Name of Player#"+ (i+1) +": ");  
            players[i] = new Player();
            players[i].name = Input.next();
            players[i].giveCard(drowCard());
            players[i].giveCard(drowCard());
        }
        players[3] = new Player();
        players[3].name = "Dealer";
        players[3].giveCard(drowCard());
        players[3].giveCard(drowCard());
    }
    public void updateScore(){
        for(int i = 0; i < 4; i++)
            highScore[i] = players[i].score <= 21 ? players[i].score : 0;
    }
}
