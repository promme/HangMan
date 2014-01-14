package Hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanHandler {
	FileHandler fh = new FileHandler();
	String test = fh.readfile();
	String[] strListSecretWords = test.split("/");
	String[] strCorrectAnswers;
	
	Random randInt = new Random();
	int intRandom = randInt.nextInt(strListSecretWords.length);
	
	String strGuess;
	String strTempAnswer = "";
	String strSecretWordTest = "";
	String strCorrectLetter="";
	
	String actualWord = strListSecretWords[intRandom];
	String[] strSecretWord = new String[actualWord.length()];
	
	Boolean blCorrect;

	
	int intMaxGuesses, intGuesses;
//Start the game
	public void Start() {
//Lenght of the word
		int intArraySize = strSecretWord.length;
		strCorrectAnswers = new String[intArraySize];
		
		for (int i = 0; i < strCorrectAnswers.length; i++) {
			strCorrectAnswers[i] = "_";

		}
		for(int i=0; i < strCorrectAnswers.length; i++)
		System.out.print(strCorrectAnswers[i]);
		for (int i = 0; i < actualWord.length(); i++) {

			strSecretWord[i] = actualWord.substring(i, i + 1);
		}
		blCorrect = false;
		//IntMaxGuesses is used for how many lifes you start with
		intMaxGuesses = 10;
		intGuesses = 0;

		Scanner scnUserInput = new Scanner(System.in);

		for (int i = 0; i < strSecretWord.length; i++) {
			strSecretWordTest += strSecretWord[i];

		}
		while (!strTempAnswer.equals(strSecretWordTest)
				&& intGuesses != intMaxGuesses) {

			strGuess = scnUserInput.nextLine().toUpperCase();
			boolean blCorrect = false;
			if (strGuess.length() > 1) {
				System.out.println("Only one letter at the time!");
				continue;
			} else
				//Test if word contains guess
				for (int i = 0; i < strSecretWord.length; i++) {
					if (strGuess.contentEquals(strSecretWord[i])) {
						strCorrectLetter = strSecretWord[i];
						strCorrectAnswers[i] = strSecretWord[i];
						blCorrect = true;
						String strWriteProgrss = "";
						for (int i2 = 0; i2 < strCorrectAnswers.length; i2++) {

							strWriteProgrss += strCorrectAnswers[i2];
						}

						strTempAnswer = strWriteProgrss;
					}

				}
			//if it doesnt contain the guessed letter print it out
			if (blCorrect == false) {
				intGuesses++;
				System.out.println("im sorry, the word does not contain an "
						+ strGuess + ", you have "
						+ (intMaxGuesses - intGuesses) + " lives remaining.");

				System.out.println(strTempAnswer);
			}else{
				System.out
				.println("Correct, the secret word contains an "
						+ strCorrectLetter);

				System.out.println(strTempAnswer);

			}

		}
		//If you lose/win
		if (intGuesses >= intMaxGuesses) {
			System.out.println("You lost, the word was " + strSecretWordTest
					+ ".");
		} else if (intGuesses > 0) {
			System.out.println("Correct! you won and you only guessed wrong "
					+ intGuesses + " time(s)!");
		} else {
			System.out.println("Congratulations, flawless victory");
		}

	}

}
