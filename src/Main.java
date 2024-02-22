import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    //Objects for changing the color of the text, as well as an object for randomizing words
    public static final String greenBackground = "\u001B[42m";
    public static final String yellowBackground = "\u001B[43m";
    public static final String resetBackground = "\u001B[0m";
    public static Random rand = new Random();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Variables
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.addAll(Arrays.asList("scram", "dream", "cream", "trust", "conquest", "bus", "stream", "bloom", "crest", "grown", "quest", "mrboolean"));
        ArrayList<String> filteredList = new ArrayList<String>();
        String wordle;
        String guess;
        int wordleIndex;
        boolean win = false;
        boolean playAgain = true;

        //Filters the list to only include words that have 5 letters
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).length() == 5) {
                filteredList.add(wordList.get(i));
            }
        }

        //Randomizes a word from the wordList and sets that word as the wordle that the user has to guess
        wordleIndex = rand.nextInt(filteredList.size());
        wordle = filteredList.get(wordleIndex);

        //Introduction
        System.out.println("Welcome to Wordle! You have to guess a 5 letter word in 6 tries! " +
                "Begin by entering a 5 letter word, and if any of the letters in your guess are " +
                "in the final word, the letter will show up yellow. If the letter is in the final " +
                "word AND the right place, it will show up green! The game will end when you've guessed the word. Good luck! ");
        System.out.println("_____");

        //Plays game in a while loop, breaks the for loop when the user wins
        //Breaks out of the while loop if the user does not want to play again
        while (playAgain) {
            for (int i = 0; i < 6; i++) {
                guess = InputHelper.getLengthFiveString(scan, "\nEnter a word!");
                for (int j = 0; j < wordle.length(); j++) {
                    if (guess.substring(j, j+1).equalsIgnoreCase(wordle.substring(j, j+1))) {
                        System.out.print(greenBackground + guess.substring(j, j+1) + resetBackground);
                    } else if (wordle.contains(guess.substring(j, j+1))) {
                        System.out.print(yellowBackground + guess.substring(j, j+1) + resetBackground);
                    } else {
                        System.out.print(resetBackground + guess.substring(j, j+1));
                    }
                }
                win = checkWin(guess, wordle);
                if (win) {
                    System.out.println("\nYou Win!");
                    break;
                }
            }
            if (!win) {
                System.out.println("\nYou lose!");
            }
            playAgain = InputHelper.getYNConfirm(scan, "Do you want to play again? [Enter Y/N]");
        }
    }

    //Method that checks if the user won
    public static boolean checkWin(String guess, String wordle) {
        boolean done = false;
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            if (guess.substring(i, i+1).equalsIgnoreCase(wordle.substring(i, i+1))) {
                counter++;
            }
        }
        if (counter == 5) {
            done = true;
        }
        return done;
    }
}