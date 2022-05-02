package hangman.models;

import java.util.ArrayList;

public class Player {
    private final String name;
    private int life;
    private ArrayList<String> hangManImages;

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

    public int loseLife() {
        life -= 1;
        return life;
    }

    public ArrayList<String> generateHangmanImages() {
        ArrayList<String> hangman_images = new ArrayList<>();
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "  O   |\n" +
                            " /|\\  |\n" +
                            " / \\  |\n" +
                            "      |\n" +
                            "=========");
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "  O   |\n" +
                            " /|\\  |\n" +
                            " /    |\n" +
                            "      |\n" +
                            "=========");
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "  O   |\n" +
                            " /|\\  |\n" +
                            "      |\n" +
                            "      |\n" +
                            "=========");
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "  O   |\n" +
                            " /|   |\n" +
                            "      |\n" +
                            "      |\n" +
                            "=========");
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "  O   |\n" +
                            "  |   |\n" +
                            "      |\n" +
                            "      |\n" +
                            "=========");
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "  O   |\n" +
                            "      |\n" +
                            "      |\n" +
                            "      |\n" +
                            "=========");
        hangman_images.add("  +---+\n" +
                            "  |   |\n" +
                            "      |\n" +
                            "      |\n" +
                            "      |\n" +
                            "      |\n" +
                            "=========");
        return hangman_images;
    }

    public void showPlayerHanging() {
        System.out.println(this.hangManImages.get(this.getLife()));
    }

    public boolean isAlive(){
        return life == 0;
    }
}
