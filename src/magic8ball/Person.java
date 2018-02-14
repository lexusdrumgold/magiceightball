package magic8ball;

import java.util.ArrayList;

/**
 * Blueprint for a Person object. It stores the person's name, their question
 * for the magic eight ball, and their id number. Using a map, the class also
 * keeps track of their questions and how many times each question was asked.
 * 
 * @author LexusDrumgold
 *
 */
public class Person {
	private ArrayList<Question> questions = new ArrayList<Question>();
	private String name;
	private Question question;
	private int id;

	private static int idCount = 0;

	/**
	 * Default constructor for the class that takes a person's name and question (as
	 * a String) for the magic eight ball as arguments. It initializes name and
	 * question to the provided arguments if they both are non-null and non-empty.
	 * 
	 * @param name
	 *            person's name
	 * @param question
	 *            question person wants to ask the magic eight ball
	 */
	public Person(String name, String question) {
		try {
			this.name = Utilities.validateString(name);
			this.question = new Question(Utilities.validateString(question));
		} catch (IllegalArgumentException e) {
			System.out.print(e.getMessage());
		}
		updateQuestionsList(this.question);
		id = idCount++;
	}
	
	/**
	 * Returns the persons question for magic eight ball.
	 * 
	 * @return Question question to be asked
	 */
	public Question getQuestion() {
		return question;
	}
	
	/**
	 * This method takes a question for the magic ball as an argument. It adds the
	 * question to the person's question list and then returns the question.
	 * 
	 * @param question
	 *            question for the magic eight ball
	 */
	public void setQuestion(String question) {
		updateQuestionsList(new Question(Utilities.validateString(question)));
	}

	@Override
	public String toString() {
		return name + " asked " + "\'" + question.toString() + "\'";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Person)) {
			return false;
		} else {
			Person compare = (Person) obj;
			return (name.equals(compare.name) && id == compare.id) ? true : false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	/**
	 * This method takes a Question object as an argument and checks if the person
	 * has already asked the provided question. If so, the question's asked count is
	 * incremented by 1.
	 * 
	 * @param question
	 *            question to ask
	 */
	private void updateQuestionsList(Question question) {
		if (questions.contains(question)) {
			question.updateTimesAsked();
		} else {
			questions.add(question);
		}
	}
}
