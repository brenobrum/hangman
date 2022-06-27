package hangman.models;

public class GameLog implements ICommand{
    String message;

    public GameLog(String message) {
        this.message = message;
    }

    @Override
    public String exec() {
        return "playerState: \n" + message + "\n\n";
    }
}
