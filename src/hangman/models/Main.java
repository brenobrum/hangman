package hangman.models;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static boolean playAgain(Scanner scanner, Boolean play) {
        System.out.println("Deseja jogar novamente? (S/N)");
        String playConfirmation = scanner.next().toUpperCase();
        if (playConfirmation.equals("S")) {
            play = true;
        } else {
            play = false;
            System.out.println("Obrigado por jogar!");
        }
        return play;
    }


    public static void main(String[] args) {
        boolean play = true;
        do {
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

            while (play) {

                player.showPlayerHanging();
                game.showWord();

                System.out.print("Letras ja utilizadas: ");
                System.out.println(game.getUsedChars());
                System.out.print("\nChute uma letra: ");
                Character character = scanner.next().toUpperCase().charAt(0);
                player = game.addCharToList(character, player);

                if (player.isAlive()) {
                    System.out.println(player.getName() + " voce perdeu. Tente novamente.");
                    System.out.println("A palavra era: " + game.getWord().value());
                    System.out.println("A dificuldade era: " + game.getWord().difficulty());
                    play = playAgain(scanner, play);
                }
                if (game.isComplete()) {
                    System.out.println("**********");
                    System.out.println(player.getName() + " PARABENS!!! Voce ganhou!!!");
                    System.out.println("**********");
                    play = playAgain(scanner, play);
                }
            }
        } while (play);
    }
}