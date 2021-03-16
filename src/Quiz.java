/**
  * 
  * Quiz class that stores list of questions for the particular quiz
  *
  * 
 */

//AUTHOR: JESUS CAPO
import java.util.ArrayList;

public class Quiz {
	private int id;
	private ArrayList<Question> quizQuestions = new ArrayList<Question>();
	
	public Quiz(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void addQuestionToQuiz(Question question) {
		this.quizQuestions.add(question);
	}
	
	public ArrayList<Question> getQuizQuestions() {
		return this.quizQuestions;
	}

}
