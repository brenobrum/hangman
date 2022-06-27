package hangman.models;

import java.util.Scanner;

public class Main {

    public static boolean playAgain(Scanner scanner, Boolean play) {
        System.out.println("Deseja jogar novamente? (S/N)");
        String playConfirmation = scanner.next().toUpperCase();
        if (playConfirmation.equals("N")) {
            System.out.println("Obrigado por jogar!");
            System.exit(0);
        }
        return false;
    }


    public static void main(String[] args) {
        do {
            CommandExecuter commands = new CommandExecuter();
            boolean play = true;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite seu nome: ");
            String name = scanner.nextLine();
            boolean valid = false;
            int difficulty = 0;
            do {
                System.out.print("Dificuldade(1-8): ");
                String difficultyS = scanner.next();
                if (difficultyS.matches("[0-9]")) {
                    difficulty = Integer.parseInt(difficultyS);
                    if (difficulty < 1 || difficulty > 8) {
                        System.out.println("Dificuldade deve ser entre 1 e 8, escolha outra dificuldade: ");
                    } else {
                        valid = true;
                    }
                } else {
                    System.out.println("Dificuldade invalida, por favor, digite um numero.");
                }
            } while (!valid);
            Player player = new Player(name);
            Game game = new Game(difficulty);
            commands.add(new PlayerLog(name, difficulty));
            while (play) {

                System.out.println(player.showPlayerHanging());
                game.showWord();

                System.out.print("Letras ja utilizadas: ");
                System.out.println(game.getUsedChars());
                System.out.print("\nChute uma letra: ");
                Character character = scanner.next().toUpperCase().charAt(0);
                player = game.addCharToList(character, player);

                if (player.isAlive()) {
                    UsedCharsToStringAdapter usedCharsToStringAdapter = new UsedCharsToStringAdapter(game.getUsedChars());
                    System.out.println(player.getName() + " voce perdeu. Tente novamente.");
                    System.out.println("A palavra era: " + game.getWord().value().toUpperCase());
                    System.out.println("Letras utilizadas: " + usedCharsToStringAdapter.getUsed());
                    System.out.println("A dificuldade era: " + game.getWord().difficulty());

                    commands.add(new WordsLog(game.getWord().value().toUpperCase(), usedCharsToStringAdapter.getUsed()));
                    commands.add(new GameLog(player.showPlayerHanging()));
                    commands.execAll();

                    play = playAgain(scanner, play);

                }
                if (game.isComplete()) {
                    UsedCharsToStringAdapter usedCharsToStringAdapter = new UsedCharsToStringAdapter(game.getUsedChars());
                    System.out.println("**********");
                    System.out.println(player.showPlayerHanging());
                    System.out.println("A palavra era: " + game.getWord().value().toUpperCase());
                    System.out.println("Letras utilizadas: " + usedCharsToStringAdapter.getUsed());
                    System.out.println(player.getName() + " PARABENS!!! Voce ganhou!!!");
                    System.out.println("**********");

                    commands.add(new WordsLog(game.getWord().value().toUpperCase(), usedCharsToStringAdapter.getUsed()));
                    commands.add(new GameLog(player.showPlayerHanging()));
                    commands.execAll();

                    play = playAgain(scanner, play);
                }
            }
        } while (true);
    }
}