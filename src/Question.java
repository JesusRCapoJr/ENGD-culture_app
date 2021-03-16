/**
  * 
  * Question class that stores question data
  *
  * 
 */

//AUTHOR: JESUS CAPO

public class Question {
	private int id;
	private boolean answer;
	private String prompt;
	
	public Question(int id, boolean answer, String prompt) {
		this.id = id;
		this.answer = answer;
		this.prompt = prompt;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getPrompt() {
		return this.prompt;
	}
	
	public boolean getAnswer() {
		return this.answer;
	}
	
	public void updateQuestion(boolean answer, String prompt) {
		this.answer = answer;
		this.prompt = prompt;
	}
	
}
