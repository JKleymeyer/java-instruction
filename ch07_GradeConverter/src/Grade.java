

public class Grade {
	int number;
	String letter;
	
	public Grade() {
		super();
	}

	public Grade(int number, String letter) {
		super();
		this.number = number;
		this.letter = letter;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLetter() {
		
		if(number >= 88) {
			letter = "A";
		} else if (number >= 80) {
			letter = "B";
		} else if (number >= 67) {
			letter = "C";
		} else if (number >= 60) {
			letter = "D";
		} else {
			letter = "F";
		}
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
		
		
	}

	public String getGrade() {
		return "Letter Grade: " +getLetter();
	}
	

}
