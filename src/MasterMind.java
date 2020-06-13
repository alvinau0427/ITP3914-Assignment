/*
   FileName:	MasterMind
   StudentName:	Au Chi Chung
   StudentID:	150533022
   ClassName:	HDSE1A
   SubjectName:	IT114105 - Higher Diploma in Software Engineering
   Description:	A simple Mastermind game in JAVA command console.
   
   - MasterMind -
   Mastermind is a code-breaking game for two players. And the idea of the game is for one player (the code-breaker) to guess the secret code chosen by the other player (the code-maker).
   
   - How to play -
   (1)	The code-breaker can choose the game mode for playing with 'Computer' or 'Player'.
   (2)	Computer or the code-maker will generate the question of 4 numbers as '1' to '6'.
   (3)	Then the code-breaker should crack out the answer within 10 rounds or surrender.
*/

import java.util.*;
import java.io.*;

public class MasterMind {
	public static Scanner kb = new Scanner(System.in);
	public static void main(String [] args) {
		String question = "";
		String guess = "";
		String yesno = "";
		boolean switchOn = false;
		boolean choice = false;
		int[] secretAnswer = new int [4];
		int count = 1;
		
		// The statement which will check the input for user to choose the game mode.
		System.out.print("Computer VS Player (y/n)? ");
		yesno = kb.nextLine();
		
		while (switchOn == false) {
			// The result of yes case
			if ( (yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes")) ) {
				switchOn = true;
				choice = true;
			// The result of no case.
			}else if ( (yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no")) ) {
				switchOn = true;
				choice = false;
			// The input of other case that will resend the game mode picking request.
			}else {
				System.out.println("Please input y or n!");
				System.out.print("Computer VS Player (y/n)? ");
				yesno = kb.nextLine();
			}
		}
		
		// When user want to enter in the 'VS Computer Mode'.
		// 4 elements for a combination of the 4 numbers will guess as '1' to '6'.
		int[] randomAnswer = new int [4];
		int[] controlUnit = new int[4];
		controlUnit[0] = (int)(Math.random() * 100);
		controlUnit[1] = (int)(Math.random() * 100);
		controlUnit[2] = (int)(Math.random() * 100);
		controlUnit[3] = (int)(Math.random() * 100);

		for (int i = 0; i <= 3; i++) {
			if(controlUnit[i] <= 17) {
				randomAnswer[i] = 1;
			}else if (controlUnit[i] <= 34) {
				randomAnswer[i] = 2;
			}else if (controlUnit[i] <= 51) {
				randomAnswer[i] = 3;
			}else if (controlUnit[i] <= 68) {
				randomAnswer[i] = 4;
			}else if (controlUnit[i] <= 85) {
				randomAnswer[i] = 5;
			}else if (controlUnit[i] <= 100) {
				randomAnswer[i] = 6;
			}
		}
		
		// The switch for enter the game mode.
		if (choice == true) {
			Purge();
			ComputerMode(guess, randomAnswer, count);
		}else if (choice == false) {
			PlayerSetting(question, secretAnswer);
			Purge();
			PlayerMode(guess, secretAnswer, count);
		}
	}
		
	// The main game statement for checking the digits of the user input.
	// 'VS Computer Mode'.
	public static void ComputerMode(String guess, int[] randomAnswer, int count){
		Error err1 = new Error();
		Error err2 = new Error();
		Error err3 = new Error();
		String copyArray = (String.valueOf(randomAnswer[0]) + String.valueOf(randomAnswer[1]) + String.valueOf(randomAnswer[2]) + String.valueOf(randomAnswer[3]));
		int blackPins = 0;
		int whitePins = 0;
		boolean isDigit = false;
		boolean playAgain = false;
		String yesno = "";
		String zero = "0";
		String one = "1";
		String two = "2";
		String three = "3";
		String four = "4";
		String five = "5";
		String six = "6";
		
		System.out.print("Step " + count + ": Please input your guess: ");
		guess = kb.nextLine();
		
		// Check the digit is using the digit number or not.
		while (!isDigit) {
			try {
				Integer.parseInt(guess);
				isDigit = true;
			}catch (Exception e) {	
				System.out.println("Use digit '1' to '6' to represent Colour!");
				System.out.print("Step " + count + ": Please input your guess: ");
				guess = kb.nextLine();
			}
		}
		
		// When the 'Player2' want to surrender.
		if ((guess.charAt(0) == zero.charAt(0)) && (guess.length() == 1)) {
			System.out.println("You Lose! Correct Answer is " + copyArray);
			while (playAgain == false) {
				System.out.print("Do you want to continue (y/n)? ");
				yesno = kb.nextLine();
				err3.chkYesNoError(yesno);
				if(err3.getError()) {
					System.out.println(err3.getMessage());
					//System.out.println(err3);
				}else if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes"))) {
					playAgain = true;
					main(null);
				}else if ((yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
					playAgain = true;
					System.out.println("Bye Bye!");
					System.exit(0);
				}
			}
		}
		
		int[] guessAnswer = new int [6];
		int[] guessAnswer2 = new int [6];
		String[] stringAnswer = new String [4];
		int[] intAnswer = new int [4];
		
		if(chkError(guess) == true){
			for (int i = 0; i < 4; i++) {
				stringAnswer[i] = String.valueOf(guess.charAt(i));
				intAnswer[i] = Integer.parseInt(stringAnswer[i]);
				if (intAnswer[i] == 1) {
					guessAnswer[0] = guessAnswer[0] + 1;
				}else if (intAnswer[i] == 2) {
					guessAnswer[1] = guessAnswer[1] + 1;
				}else if (intAnswer[i] == 3) {
					guessAnswer[2] = guessAnswer[2] + 1;
				}else if (intAnswer[i] == 4) {
					guessAnswer[3] = guessAnswer[3] + 1;
				}else if (intAnswer[i] == 5) {
					guessAnswer[4] = guessAnswer[4] + 1;
				}else if (intAnswer[i] == 6) {
					guessAnswer[5] = guessAnswer[5] + 1;
				}
				if (randomAnswer[i] == 1) {
					guessAnswer2[0] = guessAnswer2[0] + 1;
				}else if (randomAnswer[i] == 2) {
					guessAnswer2[1] = guessAnswer2[1] + 1;
				}else if (randomAnswer[i] == 3) {
					guessAnswer2[2] = guessAnswer2[2] + 1;
				}else if (randomAnswer[i] == 4) {
					guessAnswer2[3] = guessAnswer2[3] + 1;
				}else if (randomAnswer[i] == 5) {
					guessAnswer2[4] = guessAnswer2[4] + 1;
				}else if (randomAnswer[i] == 6) {
					guessAnswer2[5] = guessAnswer2[5] + 1;
				}
			}
			System.out.print("Guess " + count + ": " + guess + " ");
			count++;
			
			// To calculate black pins.
			for (int j = 0; j <= 3; j++) {
				if (randomAnswer[j] == intAnswer[j]) {
					blackPins++;
				}
			}
			
			// To calculate white pins.
			for (int j = 0; j < 6 ; j++) {
				if (guessAnswer[j] <= guessAnswer2[j]) {
					whitePins = whitePins + guessAnswer[j];
				}else {
					whitePins = whitePins + guessAnswer2[j];
				}
			}
			whitePins = whitePins - blackPins;
			System.out.println("Black: " + blackPins + " " + "White: " + whitePins);
		}
		
		// When the 'Player2' win the game.
		if (blackPins == 4) {
			System.out.println("You Win");
			while (playAgain == false) {
				System.out.print("Do you want to continue (y/n)? ");
				yesno = kb.nextLine();
				err3.chkYesNoError(yesno);
				if(err3.getError()) {
					System.out.println(err3.getMessage());
					//System.out.println(err3);
				}else if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes"))) {
					playAgain = true;
					main(null);
				}else if ((yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
					playAgain = true;
					System.out.println("Bye Bye!");
					System.exit(0);
				}
			}
		}
		
		// When the 'Player2' lose the game.
		if (count > 10) {
			System.out.println("You Lose! Correct Answer is " + copyArray);
			while (playAgain == false) {
				System.out.print("Do you want to continue (y/n)? ");
				yesno = kb.nextLine();
				err3.chkYesNoError(yesno);
				if(err3.getError()) {
					System.out.println(err3.getMessage());
					//System.out.println(err3);
				}else if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes"))) {
					playAgain = true;
					main(null);
				}else if ((yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
					playAgain = true;
					System.out.println("Bye Bye!");
					System.exit(0);
				}
			}
		}
		ComputerMode(guess, randomAnswer, count);
	}
		
	// The main game statement for checking the digits of the user input.
	// 'VS Player Mode'.
	public static void PlayerMode(String guess, int[] secretAnswer, int count){
		Error err1 = new Error();
		Error err2 = new Error();
		Error err3 = new Error();
		String copyArray = (String.valueOf(secretAnswer[0]) + String.valueOf(secretAnswer[1]) + String.valueOf(secretAnswer[2]) + String.valueOf(secretAnswer[3]));
		int blackPins = 0;
		int whitePins = 0;
		boolean isDigit = false;
		boolean playAgain = false;
		String yesno = "";
		String zero = "0";
		String one = "1";
		String two = "2";
		String three = "3";
		String four = "4";
		String five = "5";
		String six = "6";
		
		System.out.print("Step " + count + ": Please input your guess: ");
		guess = kb.nextLine();
		
		// Check the digit is using the digit number or not.
		while (!isDigit) {
			try {
				Integer.parseInt(guess);
				isDigit = true;
			}catch (Exception e) {	
				System.out.println("Use digit '1' to '6' to represent Colour!");
				System.out.print("Step " + count + ": Please input your guess: ");
				guess = kb.nextLine();
			}
		}
		
		// When the 'Player2' want to surrender.
		if ((guess.charAt(0) == zero.charAt(0)) && (guess.length() == 1)) {
			System.out.println("You Lose! Correct Answer is " + copyArray);
			while (playAgain == false) {
				System.out.print("Do you want to continue (y/n)? ");
				yesno = kb.nextLine();
				err3.chkYesNoError(yesno);
				if(err3.getError()) {
					System.out.println(err3.getMessage());
					//System.out.println(err3);
				}else if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes"))) {
					playAgain = true;
					main(null);
				}else if ((yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
					playAgain = true;
					System.out.println("Bye Bye!");
					System.exit(0);
				}
			}
		}
		
		int[] guessAnswer = new int [6];
		int[] guessAnswer2 = new int [6];
		String[] stringAnswer = new String [4];
		int[] intAnswer = new int [4];
		
		if(chkError(guess) == true){
			for (int i = 0; i <= 3; i++) {
				stringAnswer[i] = String.valueOf(guess.charAt(i));
				intAnswer[i] = Integer.parseInt(stringAnswer[i]);
				if (intAnswer[i] == 1) {
					guessAnswer[0] = guessAnswer[0] + 1;
				}else if (intAnswer[i] == 2) {
					guessAnswer[1] = guessAnswer[1] + 1;
				}else if (intAnswer[i] == 3) {
					guessAnswer[2] = guessAnswer[2] + 1;
				}else if (intAnswer[i] == 4) {
					guessAnswer[3] = guessAnswer[3] + 1;
				}else if (intAnswer[i] == 5) {
					guessAnswer[4] = guessAnswer[4] + 1;
				}else if (intAnswer[i] == 6) {
					guessAnswer[5] = guessAnswer[5] + 1;
				}
				if (secretAnswer[i] == 1) {
					guessAnswer2[0] = guessAnswer2[0] + 1;
				}else if (secretAnswer[i] == 2) {
					guessAnswer2[1] = guessAnswer2[1] + 1;
				}else if (secretAnswer[i] == 3) {
					guessAnswer2[2] = guessAnswer2[2] + 1;
				}else if (secretAnswer[i] == 4) {
					guessAnswer2[3] = guessAnswer2[3] + 1;
				}else if (secretAnswer[i] == 5) {
					guessAnswer2[4] = guessAnswer2[4] + 1;
				}else if (secretAnswer[i] == 6) {
					guessAnswer2[5] = guessAnswer2[5] + 1;
				}
			}
			System.out.print("Guess " + count + ": " + guess + " ");
			count++;
			
			// To calculate black pins.
			for (int j = 0; j <= 3; j++) {
				if (secretAnswer[j] == intAnswer[j]) {
					blackPins++;
				}
			}
			
			// To calculate white pins.
			for (int j = 0; j < 6 ; j++) {
				if (guessAnswer[j] <= guessAnswer2[j]) {
					whitePins = whitePins + guessAnswer[j];
				}else {
					whitePins = whitePins + guessAnswer2[j];
				}
			}
			whitePins = whitePins - blackPins;
			System.out.println("Black: " + blackPins + " " + "White: " + whitePins);
		}
		
		// When the 'Player2' win the game.
		if (blackPins == 4) {
			System.out.println("You Win");
			while (playAgain == false) {
				System.out.print("Do you want to continue (y/n)? ");
				yesno = kb.nextLine();
				err3.chkYesNoError(yesno);
				if(err3.getError()) {
					System.out.println(err3.getMessage());
					//System.out.println(err3);
				}else if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes"))) {
					playAgain = true;
					main(null);
				}else if ((yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
					playAgain = true;
					System.out.println("Bye Bye!");
					System.exit(0);
				}
			}
		}
		
		// When the 'Player2' lose the game.
		if (count > 10) {
			System.out.println("You Lose! Correct Answer is " + copyArray);
			while (playAgain == false) {
				System.out.print("Do you want to continue (y/n)? ");
				yesno = kb.nextLine();
				err3.chkYesNoError(yesno);
				if(err3.getError()) {
					System.out.println(err3.getMessage());
					//System.out.println(err3);
				}else if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes"))) {
					playAgain = true;
					main(null);
				}else if ((yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
					playAgain = true;
					System.out.println("Bye Bye!");
					System.exit(0);
				}
			}
		}
		PlayerMode(guess, secretAnswer, count);
	}
	
	public static int[] PlayerSetting(String question, int[] secretAnswer) {
		Error err1 = new Error();
		Error err2 = new Error();
		Error err3 = new Error();
		boolean isDigit = false;
		boolean isColour = false;
		boolean isNumber = false;
		boolean isCorrect = false;
		
		// When the user wan to enter in the 'VS Player Mode'.
		System.out.print("Player1 input the answer: ");
		question = kb.nextLine();

		// Check the digit is using the digit number or not.
		while (!isDigit) {
			try {
				Integer.parseInt(question);
				isDigit = true;
			}catch (Exception e) {	
				System.out.println("Use digit '1' to '6' to represent Colour!");
				System.out.print("Player1 input the answer: ");
				question = kb.nextLine();
			}
		}

		// Check the 4 digit numbers is that using '1' to '6' to represent Colour or not.
		// Check the pegs number is in a range or not.
		while(chkError(question) == false) {
			System.out.print("Player1 input the answer: ");
			question = kb.nextLine();
		}

		if(chkError(question) == true) {
			for (int i = 0; i < question.length(); i++) {
				secretAnswer[i] = Integer.parseInt(String.valueOf(question.charAt(i)));
			}
		}
		return secretAnswer;
	}
	
	public static void Purge() {
		// Control the console like 'Clear Screen(CLS)' command for clear the player1 setting.
		for (int i = 1; i < 60; i++) {
			System.out.println();
		}
		
		// The player2 mastermind game will start in here.
		System.out.println("--- Player2 Starts to guess ---");
		System.out.println("Type '0' to give up the game.");
	}
	
	public static boolean chkError(String check) {
		Error err1 = new Error();
		Error err2 = new Error();
		
		err1.chkPegsColour(check);
		if(err1.getError()) {
			System.out.println(err1.getMessage());
			err2.chkPegsNumber(check);
			if(err2.getError()) {
				System.out.println(err2.getMessage());
				return false;
			}
		}else {
			err2.chkPegsNumber(check);
			if(err2.getError()) {
				System.out.println(err2.getMessage());
			}else {
				return true;
			}
		}
		return false;
	}
}