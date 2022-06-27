package hangman.models;

import java.util.ArrayList;

public class Player{
    private final String name;
    private int life;
    private final ArrayList<String> hangManImages;

    public Player(String name) {
        this.hangManImages = generateHangmanImages();
        this.name = name;
        this.life = 6;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public void loseLife() {
        life -= 1;
    }

    public ArrayList<String> generateHangmanImages() {
        ArrayList<String> hangman_images = new ArrayList<>();
        hangman_images.add("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 / \\  |
                      |
                =========""");
        hangman_images.add("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 /    |
                      |
                =========""");
        hangman_images.add("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                      |
                      |
                =========""");
        hangman_images.add("""
                  +---+
                  |   |
                  O   |
                 /|   |
                      |
                      |
                =========""");
        hangman_images.add("""
                  +---+
                  |   |
                  O   |
                  |   |
                      |
                      |
                =========""");
        hangman_images.add("""
                  +---+
                  |   |
                  O   |
                      |
                      |
                      |
                =========""");
        hangman_images.add("""
                  +---+
                  |   |
                      |
                      |
                      |
                      |
                =========""");
        return hangman_images;
    }

    public String showPlayerHanging() {
        return this.hangManImages.get(this.getLife());
    }

    public boolean isAlive(){
        return life == 0;
    }
}
