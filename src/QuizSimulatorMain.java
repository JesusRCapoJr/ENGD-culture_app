import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class simulates the quiz creation and updating along with testing scenario
 * 
 * @author JESUS CAPO
 *
 */
public class QuizSimulatorMain {

	
	//DONE add instance variables
	private ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<QuizTester> quizTesters = new ArrayList<QuizTester>();
	
	//Used to remind user of commands available
	public final static String HELP_STRING = "create-question [id] [answer] [prompt]\n" 
											+ "create-quiz [id] \n"
											+ "create-quiz-tester [id] [searchString] \n"
											+ "report-overall-quiz-tester-score [id] \n"
											+ "report-quiz-tester-score-on-quiz [testerId] [quizId] \n"
											+ "add-question-to-quiz [questionId] [quizId] \n"
											+ "display-quiz [quizId] \n"
											+ "display-question-prompt [questionId]  \n"
											+ "update-question [questionId] [answer] [prompt]\n ";

	public static void main(String[] args) {
		QuizSimulatorMain simulator = new QuizSimulatorMain();
		System.out.println("Welcome to QuizTester.  Enter commands.  Type 'exit' to end.");
		System.out.println("Enter [help] for a list of commands.");
		System.out.println( HELP_STRING );
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String commandLine = scanner.nextLine();
			String result = simulator.handleCommand(commandLine);
			System.out.println(result);
		}
	}
	/**
	 *  Do not change this method, it parses the input from the user so you don't have to.
	 *  It then calls the handler methods that you are required to implement 
	 * 
	 * @param command
	 * @return
	 */
	public String handleCommand(String command) {
		Scanner input = new Scanner(command);
		String commandType = input.next();
		String toReturn = null;
		if(commandType.equals("help")) {
			toReturn= HELP_STRING;
		} else if(commandType.equals("create-question")) {
			int id = input.nextInt();
			boolean answer = input.nextBoolean();
			String prompt = input.nextLine();
			handleCreateQuestion(id, answer, prompt);
			toReturn = "OK: created question";	
		} else if (commandType.equals("create-quiz")) {
			int id = input.nextInt();
			handleCreateQuiz(id);
			toReturn = "OK: created quiz";
		} else if (commandType.equals("create-quiz-tester")) {
			int id = input.nextInt();
			String searchString = input.next();
			handleCreateQuizTester(id, searchString);
			toReturn = "OK: created quiz tester";
		} else if (commandType.equals("report-overall-quiz-tester-score")) {
			int id = input.nextInt();
			double score = handleGetQuizTesterOverallScore(id);
			toReturn = "OK: Overall Score:" + score;
		} else if (commandType.equals("report-quiz-tester-score-on-quiz")) {
			int testerId = input.nextInt();
			int quizId = input.nextInt();
			double score = handleGetQuizTesterScoreOnQuiz(testerId, quizId);
			toReturn = "OK: Individual Score:" + score;
		} else if (commandType.equals("add-question-to-quiz")) {
			int questionId = input.nextInt();
			int quizId = input.nextInt();
			handleAddQuestionToQuiz(questionId, quizId);
			toReturn = "OK: question added to quiz";
		} else if (commandType.equals("display-quiz")) {
			int quizId = input.nextInt();
			String quizString = handleGetQuizString(quizId);
			toReturn = "OK: Displaying Quiz\n" + quizString;
		} else if (commandType.equals("display-question-prompt")) {
			int questionId = input.nextInt();
			String questionPrompt = handleGetQuestionPrompt(questionId);
			toReturn = "OK: Displaying Question Prompt:\n" + questionPrompt;
		} else if (commandType.equals("update-question")) {
			int id = input.nextInt();
			boolean answer = input.nextBoolean();
			String prompt = input.nextLine();
			handleUpdateQuestion(id, answer, prompt);
			toReturn = "OK: question updated";
		} else if(commandType.equals("exit")) {
			input.close();
			System.exit(0);
		}
		else {
			toReturn = "Unknown command " + commandType;
		}
		input.close();
		
		return toReturn;
	}

	/**
	 * Creates a question with questionId, an answer, and a prompt
	 * 
	 * @param id
	 * @param answer
	 * @param prompt
	 */
	public void handleCreateQuestion(int id, boolean answer, String prompt) {
		//DONE complete this method
		Question newQuestion = new Question(id, answer, prompt);
		questions.add(newQuestion);
	}
	
	/**
	 * Get back the String prompt from a question with id questionId
	 * 
	 * @param questionId
	 * @return
	 */
	public String handleGetQuestionPrompt(int questionId) {
		//DONE complete this method
		for (Question i : questions) {
			if (i.getId()==questionId) {
				return i.getPrompt();
			}
		}
		return null;
	}
	/**
	 * Create a quiz with corresponding id, initially it should have no questions
	 * 
	 * @param id
	 */
	
	public void handleCreateQuiz(int id) {
		//DONE complete this method
		Quiz newQuiz = new Quiz(id);
		quizzes.add(newQuiz);
	}
	/**
	 * Adds an already created question with id=questionId to an already created quiz with id=quizId
	 * 
	 * @param questionId
	 * @param quizId
	 */
	
	public void handleAddQuestionToQuiz(int questionId, int quizId ) {
		//DONE complete this method
		for (Quiz i1 : quizzes) { 
			if (i1.getId()==quizId) {
				for (Question i2 : questions) {
					if (i2.getId()==questionId) {
						i1.addQuestionToQuiz(i2);
						break;
					}
				}
				break;
			}
		}
	}
	/**
	 * Updates a question with questionId  with a new answer and prompt
	 * 
	 * @param questionId
	 * @param answer
	 * @param prompt
	 */
	
	public void handleUpdateQuestion(int questionId, boolean answer, String prompt) {
		//DONE complete this method
		for (Question i : questions) {
			if (i.getId()==questionId) {
				i.updateQuestion(answer, prompt);
				break;
			}
		}
	}
	/**
	 * 
	 * This method should return a String presentation of a quiz which then gets displayed to the screen via handle command
	 * you can add "\n" to a String to create a line break, so that when printed it will go to the next line
	 * 
	 * This method is not unit tested, so you can represent it how you like, but test it manually for yourself
	 * 
	 * @param quizId
	 */
	
	public String handleGetQuizString(int quizId) {
		//DONE complete this method
		//Tested and works
		int questionNum = 1;
		String quizString = "";
		for (Quiz i1 : quizzes) { 
			if (i1.getId()==quizId) {
				for (Question i2 : questions) {
					quizString += "Question "+String.valueOf(questionNum)+":"+i2.getPrompt()+"\n";
					questionNum++;
				}
				break;
			}
		}
		return quizString;
	}
	/**
	 * Creates a new QuizTester with a provide id and searchString used to answer questions
	 * 
	 * @param id
	 * @param searchString
	 */
	public void handleCreateQuizTester(int id, String searchString) {
		//DONE complete this method
		QuizTester newTester = new QuizTester(id, searchString);
		quizTesters.add(newTester);
	}
	
	/**
	 * Returns a double with the percentage a given QuizTester with id quizTesterId
	 *  gets on a quiz with id quizId
	 * 
	 * @param quizTesterId
	 * @param quizId
	 * @return
	 */
	public double handleGetQuizTesterScoreOnQuiz( int quizTesterId, int quizId) {
		//DONE complete this method
		for (QuizTester i1 : quizTesters) { 
			if (i1.getId()==quizTesterId) {
				for (Quiz i2 : quizzes) {
					if (i2.getId()==quizId) {
						return i1.takeQuiz(i2);
					}
				}
				break;
			}
		}
		return -1;
	}
	
	/**
	 * Take an id for a QuizTester and then finds the average score of that QuizTester
	 * on ALL Quizzes in the simulator. Note this is different than the average on all the individual problems
	 * 
	 * @param quizTesterId
	 * @return
	 */
	public double handleGetQuizTesterOverallScore( int quizTesterId) {
		//DONE complete this method
		double totalGrade = 0;
		int quizzesNum = quizzes.size();
		for (Quiz i : quizzes) {
			totalGrade += handleGetQuizTesterScoreOnQuiz(quizTesterId,i.getId());
		}
		totalGrade /= quizzesNum;
		return totalGrade;
	}

	
}
