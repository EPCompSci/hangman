import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("words.txt"));
		// Reads the word database file
		Scanner console = new Scanner(System.in);
		// Allows user to type

		for (int i = 0; i < Math.random() * 82159; i++) {
			input.nextLine();
		}
		// Jumps to a random line number and selects that word

		String chosenWord1 = input.nextLine();
		String chosenWord = chosenWord1.toLowerCase();
		// Takes the chosen word and makes it lower case
		char[] words = new char[chosenWord.length()];
		for (int i = 0; i < words.length; i++) {
			words[i] = '*';
		}
		// Creates a place to store the masked word, asterisks until the
		// character is discovered
		boolean running = true;
		// Declaring boolean to let the game run until it is won

		System.out.println("Word: ");
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i]);
		}
		// Printing out the masked word for the first time
		System.out.println();
		while (running) {
			System.out.print("Please enter a letter: ");
			// Printing to the console requesting a guess
			char guess = console.nextLine().charAt(0);
			// Takes user input and converts it to a char for guessing
			for (int i = 0; i < chosenWord.length(); i++) {
				// Runs for as many characters there are in the word
				if (guess == chosenWord.charAt(i)) {
					// Compares guess to every letter in the word
					words[i] = guess;
					// If the character is in the word it unmasks it
				}
			}

			String checker = "";
			// String version, compiles all characters into a String
			for (int i = 0; i < words.length; i++) {
				checker += words[i];
			}
			// Creates the full word in String format
			if (checker.equals(chosenWord)) {
				running = false;
			}
			// Checks to see if the word is fully unmasked. If it is the game is
			// over

			System.out.println("Word: " + checker);
			// Prints the word and what is masked or not.

		}
		System.out.println("You won!");
		// When the game is over(boolean running is set to false) this will be
		// printed out.

	}

}
