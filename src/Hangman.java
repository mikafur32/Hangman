public class Hangman
{
    private String phrase;
    private char[] guessedChars;
    private char[] correctGuessedChars;

    public Hangman(String phrase)
    {
        this.phrase = phrase.trim();
        guessedChars = new char[6 + phrase.length()];
        correctGuessedChars = new char[phrase.length()];
    }

    public static boolean isValid(String phrase)
    {

        for(int i = 0; i < phrase.length(); i++)
        {
            if(!Character.isAlphabetic(phrase.charAt(i)))
            {
                System.out.println("INVALID GUESS. Try Again!");
                return false;
            }
        }
        return true;
    }
    public static boolean isValidGuess(String guess, int currentGuess, Hangman game)
    {
        if(game.getGuessedChars()[currentGuess] == guess.charAt(0))
        {
            System.out.println("INVALID GUESS. Try Again!");
            return false;
        }
        if(guess.length() > 1)
        {
            System.out.println("INVALID GUESS. Try Again!");
            return false;
        }
        if(guess.equalsIgnoreCase(game.getPhrase()))
        {
            return true;
        }

        return isValid(guess);
    }
    public boolean[] getSpacesIndex()
    {
        boolean[] indexOfSpaces = new boolean[phrase.length()];
        for (int i = 0; i < phrase.length(); i++)
        {
            if(phrase.charAt(i) == ' ')
            {
                indexOfSpaces[i] = true;
            }
        }
        return indexOfSpaces;
    }

    public void correct(String guess) //FIXME!!!!
    {
        for (int i = 0; i < phrase.length(); i++)
        {
            if(Character.toLowerCase(guess.charAt(0)) == phrase.charAt(i))
            {
                correctGuessedChars[i] = guess.charAt(0);
            }
        }
    }

    public String getPhrase()
    {
        return phrase;
    }

    public char[] getGuessedChars()
    {
        return guessedChars;
    }

    public char[] getCorrectGuessedChars()
    {
        return correctGuessedChars;
    }
}
