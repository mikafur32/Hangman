import Sison.UI.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) //throws InterruptedException
    {
        Hangman game;
        String phrase;
        String guess;
        int numGuessesWrong = 0;
        int numGuesses = 0;

        do
        {
            phrase = Input.get("Enter your secret phrase").toLowerCase();
            game = new Hangman(phrase);
        }
        while(!Hangman.isValid(phrase));

        while(numGuessesWrong < 6 && !phrase.equals(charToString(game.getCorrectGuessedChars())))
        {
            System.out.print(printMasked(game, (game.getCorrectGuessedChars())));

            do
            {
                guess = Input.get(" Enter your one letter guess").toLowerCase();
            }
            while(!Hangman.isValidGuess(guess, numGuesses, game));
            numGuesses++;

            System.out.print("\u001B[H\u001B[2J");



            printMasked(game, game.getCorrectGuessedChars());


            char[] check = new char[game.getCorrectGuessedChars().length];
            System.arraycopy(game.getCorrectGuessedChars(), 0, check, 0, game.getCorrectGuessedChars().length);


            game.correct(guess);

            if(Arrays.equals(check, game.getCorrectGuessedChars()))
            {
                numGuessesWrong++;
                game.getGuessedChars()[numGuessesWrong] =  guess.charAt(0);
                System.out.println("WRONG");
            }
            printWrongs(numGuessesWrong);
            box(game.getGuessedChars());
        }
        if(numGuessesWrong == 6)
        {
            rip();
        }
        else
        {
            System.out.println("YOU WIN!!");
        }
    }

    private static String printMasked(Hangman game, char[] guessedPhrase)
    {
        boolean[] indexOfSpaces = game.getSpacesIndex();
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < indexOfSpaces.length; i++)
        {
            boolean indexOfSpace = indexOfSpaces[i];
            print.append(indexOfSpace ? "  " : guessedPhrase[i] == '\0' ? "_ " : guessedPhrase[i] + "");
        }
       return print.toString();
    }

    private static String charToString(char[] arr)
    {
        StringBuilder print = new StringBuilder();
        for (final char c : arr)
        {
            print.append(c);
        }
        return print.toString();
    }

    private static void box(char[] guesses)
    {
        System.out.println("_________________");
        System.out.println();
        for (final char guess : guesses)
        {
            System.out.print(guess + " ");
        }
        System.out.println();
        System.out.println("_________________");
        System.out.println();
    }


    private static void printWrongs(int numWrongGuesses)
    {
        if(numWrongGuesses == 0)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              =========");
        }

        if(numWrongGuesses == 1)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |   O");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              =========");

        }
        if(numWrongGuesses == 2)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |   O");
            System.out.println("              |   |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              =========");

        }
        if(numWrongGuesses == 3)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |   O");
            System.out.println("              |  /|");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              =========");
        }
        if(numWrongGuesses == 4)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |   O");
            System.out.println("              |  /|\\");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              =========");
        }
        if(numWrongGuesses == 5)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |   O");
            System.out.println("              |  /|\\");
            System.out.println("              |  /");
            System.out.println("              |");
            System.out.println("              =========");
        }
        if(numWrongGuesses == 6)
        {
            System.out.println("              +---+");
            System.out.println("              |   |");
            System.out.println("              |   O");
            System.out.println("              |  /|\\");
            System.out.println("              |  / \\");
            System.out.println("              |");
            System.out.println("              =========");

        }
    }

     private static void rip()
     {
          System.out.println("YOU HAVE BEEN HANGED");
          System.out.println();
          System.out.println();
          System.out.println("        _.---,._,'");
          System.out.println("       /' _.--.<");
          System.out.println("         /'     `'");
          System.out.println("       /' _.---._____");
          System.out.println("       \\.'   ___, .-'`");
          System.out.println("           /'    \\\\             .");
          System.out.println("         /'       `-.          -|-");
          System.out.println("        |                       |");
          System.out.println("        |                   .-'~~~`-.");
          System.out.println("        |                 .'         `.");
          System.out.println("        |                 |  R  I  P  |");
          System.out.println("        |                 |           |");
          System.out.println("        |                 |           |");
          System.out.println("         \\              \\\\|           |//");
          System.out.println("   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}

