package hangman.models;

public class PlayerLog implements ICommand{
    String playerName;
    int difficulty;

    public PlayerLog(String playerName, int difficulty) {
        this.playerName = playerName;
        this.difficulty = difficulty;

    }

    @Override
    public String exec() {
        return "PlayerName: " + playerName + "\n" + "Difficulty: " +  difficulty + "\n";
    }
}
