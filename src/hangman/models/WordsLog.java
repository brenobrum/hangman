package hangman.models;

public class WordsLog implements ICommand{
    String word;
    String chars;

    public WordsLog(String word, String chars) {
        this.word = word;
        this.chars = chars;
    }

    @Override
    public String exec() {
        return "Word: " + word + "\n" + "Chars: " + chars + "\n";
    }
}
