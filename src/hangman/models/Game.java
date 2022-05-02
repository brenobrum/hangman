package hangman.models;

import java.util.ArrayList;

public class Game {
    private ArrayList<Character> usedChars;
    private Word word;

    public Game(int difficulty) {
        this.word = new WordList(difficulty).getRandomWord();
        this.usedChars = new ArrayList<>();
    }

    public Player addCharToList(Character character, Player player) {
        if (!this.getUsedChars().contains(character) && !validChar(character) && character.toString().matches("[A-Z]*")) {
            player.loseLife();
        }if (!this.getUsedChars().contains(character) && character.toString().matches("[A-Z]*")) {
            usedChars.add(character);
        }
        return player;
    }

    public boolean validChar(Character character) {
        for (Character wordChar : this.getWord().value().toUpperCase().toCharArray()) {
            if (wordChar.equals(character)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Character> getUsedChars() {
        return usedChars;
    }

    public void newWord(int difficulty) {
        this.word = new WordList(difficulty).getRandomWord();
    }

    public void showWord() {
        for (Character i : this.getWord().value().toUpperCase().toCharArray()) {
            boolean valid = false;
            for (Character character : this.getUsedChars()){
                if (i.equals(character)) {
                    valid = true;
                }
            }
            if (valid) {
                System.out.print(i);
            }else{
                System.out.print('_');
            }
            valid = false;
        }
        System.out.println();
    }

    public boolean isComplete() {
        int count = 0;
        for (Character character : getWord().value().toUpperCase().toCharArray()) {
            for (Character usedChar : usedChars) {
                if (usedChar == character) {
                    count += 1;
                }
            }
        }
        return count == getWord().value().length();
    }

    public Word getWord() {
        return word;
    }}
