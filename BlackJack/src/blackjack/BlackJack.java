package blackjack;
import java.util.*;
public class BlackJack {
    
    static Game game = new Game();
    
    public static void main(String[] args) {
        GUI gui = new GUI();
        System.out.println("==================BlackJack Game :)=================");
        
        game.genCardDeck();
        game.setInfo();
        gui.runGUI( game.cardDeck, game.players[0].getPlayerHand(), game.players[1].getPlayerHand(), game.players[2].getPlayerHand(), game.players[3].getPlayerHand() );
        
        playersTurn(gui);
        game.updateScore();
        
        dealerTurn(gui);
        game.updateScore();
          
        checkGame();
        showScores();
        
    }
    public static void giveCardToPlayers(int index, GUI gui){
        Card c = game.drowCard();
        game.players[index].giveCard(c);
        gui.updatePlayerHand(c, index);
    }
    public static void playersTurn(GUI gui){
        Scanner scanner = new Scanner(System.in);
        int Input;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                System.out.println(game.players[i].name +"!...What would you want?  press  1- for Hit or 2- for Stand");
                Input = scanner.nextInt();
                if(Input == 1)
                    giveCardToPlayers(i, gui);
                else if(Input == 2)
                    break;
            }
        }
    }
    public static void giveCardToDealer(GUI gui, int highScore){
        while(game.players[3].score < highScore){
            Card c = game.drowCard();
            game.players[3].giveCard(c);
            gui.updateDealerHand(c, game.cardDeck);
        }
    }
    public static void dealerTurn(GUI gui){
        boolean dealerWins = true;
        int highScore = 0;
        for(int i = 0; i < 3; i++){
            if(game.highScore[i] >= game.highScore[3])
                dealerWins = false;
            if(game.highScore[i] > highScore)
                highScore = game.highScore[i];
        }
        if(!dealerWins)
            giveCardToDealer(gui, highScore);
        else
            return;
    }
    public static void checkGame(){
        int highScore = 0;
        int winner = -1;
        for(int i = 0; i < 4; i++){
            if(game.highScore[i] > highScore){
                highScore = game.highScore[i];
                winner = i;
            }
        }
        boolean push = false;
        for(int i = 0; i < 4; i++){
            if (i == winner)
                continue;
            else{
                if(game.highScore[i] == highScore)
                    push = true;
            }
        }
        if (push) 
            System.out.println("PUSH");
        else
            System.out.println("The Winner is: "+ game.players[winner].name +" with Score: "+ highScore);
    }
    public static void showScores(){
        System.out.println("The Score for every player is.....");
        for(int i = 0; i < 4; i++){
            System.out.print(game.players[i].name + ": " + game.players[i].score + "      ");
            
        }
    }
}