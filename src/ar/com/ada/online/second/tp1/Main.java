package ar.com.ada.online.second.tp1;

public class Main {

    public static void main(String[] args) {
        GameAction gameAction = new GameAction();
        Character player1 = gameAction.startPlayer1();
        Character player2 = gameAction.startPlayer2();

        gameAction.gamePlay(player1, player2);

    }
}

