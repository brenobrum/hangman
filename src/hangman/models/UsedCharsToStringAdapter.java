package hangman.models;

import java.util.ArrayList;

public class UsedCharsToStringAdapter {
    public String used;

    public UsedCharsToStringAdapter(ArrayList<Character> usedChars) {
        this.used = "";
        for (Character usedChar : usedChars) {
            used = usedChar.equals(usedChars.get(usedChars.size() - 1)) ? used + usedChar : used + usedChar + ", ";
        }
    }

    public String getUsed() {
        return used;
    }
}
