package hangman.models;

import java.util.ArrayList;

public interface IPlayer {
    String getName();
    int getLife();
    void loseLife();
    ArrayList<String> generateHangmanImages();
    void showPlayerHanging();
    boolean isAlive();
}
