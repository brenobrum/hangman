package hangman.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CommandExecuter {
    ArrayList<ICommand> list;

    public CommandExecuter() {
        this.list = new ArrayList<>();
    }

    void execAll() {

        for (ICommand command : list) {
            try {
                FileWriter myWriter = new FileWriter("src/hangman/GameLog.txt", true);
                myWriter.write(command.exec());
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    void add(ICommand command) {
        list.add(command);
    }
}
