import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static final String greenBackground = "\u001B[42m";
    public static final String yellowBackground = "\u001B[43m";
    public static final String resetBackground = "\u001B[0m";
    public static Random rand = new Random();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //variables
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.addAll(Arrays.asList("Scram", "Dream", "Cream", "Trust", "Conquest", "Bus", "Stream", "Bloom", "Crest", "Grown", "Quest", "MrBoolean"))
        ArrayList<String> filteredList = new ArrayList<String>();
        String guess;
        int wordleIndex;

        //5 letters
        //letter turns yellow if it is in the word but not in the right spot
        //letter turns green if it is in the word and the right spot
        //otherwise, letter stays gray
        //game ends when all letters are green
        //user has 6 tries, can only use letters on the keyboard
        //different outputs for what guess the user finishes on

        System.out.println("Welcome to Wordle! You have to guess a 5 letter word in 6 tries! " +
                "Begin by entering a 5 letter word, and if any of the letters in your guess are " +
                "in the final word, the letter will show up yellow. If the letter is in the final " +
                "word AND the right place, it will show up green! The game will end when you've guessed the word. Good luck! ");
        System.out.println("_____");

        guess = scan.nextLine();
        wordleIndex = rand.nextInt(wordList.size());

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).length() == 5) {
                filteredList.add(wordList.get(i));
            }
        }



    }
}