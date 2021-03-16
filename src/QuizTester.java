//AUTHOR: JESUS CAPO

import java.util.ArrayList;

public class QuizTester {
	private int id;
	private String searchString;
	
	public QuizTester(int id, String searchString) {
		this.id = id;
		this.searchString = searchString;
	}
	
	public int getId() {
		return this.id;
	}

	
	public double takeQuiz(Quiz quiz) {
		double grade=0;
		ArrayList<Question> quizQuestions = quiz.getQuizQuestions();
		int questionsNum = quizQuestions.size();
		boolean currentAnswer = true;
		
		//Simply goes through all the quiz questions in the quiz questions array in the provided quiz, checking if each question prompt contains
		//the search string, sets the currentAnswer to true if it does, and then compares the result to the actual answer, increasing the grade
		//if it does then returning the average of the grade
		for (Question i : quizQuestions) {
			if (i.getPrompt().contains(this.searchString)) {
				currentAnswer = true;
			}
			else {
				currentAnswer = false;
			}
			if (i.getAnswer() == currentAnswer) {
				grade +=1;
			}
		}
		grade = grade/questionsNum;
		return grade;
	}	
}

