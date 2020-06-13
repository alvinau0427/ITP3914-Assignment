/*
   FileName:	Error
   StudentName:	Au Chi Chung
   StudentID:	150533022
   ClassName:	HDSE1A
   SubjectName:	IT114105 - Higher Diploma in Software Engineering
   Description:	Test the error from the Java Mastermind game.
*/

public class Error {
	private int errorType;
	private String errorMessage;
	private boolean errorSwitch = false;
	
	public void chkPegsColour(String guess) {
		//Error Type = 1,
		//Error Message = Use digit '1' to '6' to represent Colour!
		errorSwitch = true;
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) < 49 || guess.charAt(i) > 54) {
				errorType = 1;
				errorMessage = ("Use digit '1' to '6' to represent Colour!");
			}
		}
	}
	
	public void chkPegsNumber(String guess) {
		//Error Type = 2,
		//Error Message = Only FOUR pegs are allowed!
		errorSwitch = true;
		if (guess.length() != 4) {
			errorType = 2;
			errorMessage = ("Only FOUR pegs are allowed!");
		}
	}
	
	public void chkYesNoError(String yesno) {
		//The chkYesNoError() method check the input for user to choose the game mode.
		//Error Type = 3,
		//Error Message = Please input y or n!
		
		errorSwitch = true;
		// The result of yes case and the result of no case
		if ((yesno.equals("Y")) || (yesno.equals("y")) || (yesno.equals("yes")) || (yesno.equals("N")) || (yesno.equals("n")) || (yesno.equals("no"))) {
			errorType = 0;
		}else {
			errorType = 3;
			errorMessage = ("Please input y or n!");
		}
	}
	
	public boolean getError() {
		//return true if any error is occurred
		//return false if no error
		if (errorType == 1 || errorType == 2 || errorType == 3){
			return true;
		}else
			return false;
	}
	
	public String getMessage() {
		return errorMessage;
	}
	
	public String toString() {
		return "Error Type: " + errorType + ", Error Message: " + errorMessage;
	}
}