package hangman.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class WordList {
    private final ArrayList<Word> wordList;

    public WordList(int difficulty) {
        File file = new File("C:\\Users\\breno\\IdeaProjects\\hangman\\src\\hangman\\db\\words.json");
        this.wordList = new ArrayList<>();
        try {
            JsonElement jsonElement = JsonParser.parseReader(new FileReader(file));
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement object : jsonArray){
                JsonObject word = object.getAsJsonObject();
                String value = word.get("value").getAsString();
                int wordDifficulty = word.get("difficulty").getAsInt();
                if (wordDifficulty == difficulty) {
                    this.wordList.add(new Word(value, wordDifficulty));
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo \"words.json\" não foi encontrado.");
        }
    }

    public Word getRandomWord() {
        Random random = new Random();
        int low = 0;
        int high = this.wordList.size()-1;
        int randomIndex = random.nextInt(high-low) + low;
        return wordList.get(randomIndex);
    }
}
