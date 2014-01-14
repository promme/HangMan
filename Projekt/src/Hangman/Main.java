package Hangman;

import java.util.Random;
import java.util.Scanner;

import Hangman.HangmanHandler;
/*###############################################
 * 												#
 * Olof Berg	 								#
 * 				Java13 							#
 * 							ProjektArbete		# 												
 * Might not be the best code since i wrote most#
 * of it in the start of the semester but its a	#
 * simple and ruthless hangman game without		#
 *  hints more than the words lenght.			#
 * ##############################################
 */
public class Main {
	public static void main(String[] args) {
		HangmanHandler h = new HangmanHandler();
		Scanner sc = new Scanner(System.in);

		System.out
				.println("What would you like to do?\n Quit: Quit. \n Anything else: Start the game. ");
		String userInput = sc.nextLine();
		while (!userInput.toUpperCase().equals("QUIT")) {
			// start the HangmanGame
		
			h.Start();
			System.out
			.println("What would you like to do?\n Quit: Quit. \n Anything else: Start the game. ");
			userInput = sc.nextLine();
		}
	}
}
