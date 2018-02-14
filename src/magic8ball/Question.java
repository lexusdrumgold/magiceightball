package magic8ball;

import java.util.HashMap;

/**
 * Blueprint for a Question object. The class stores the question text and also
 * keeps track of the answers to the question, and how many times those answers
 * were received.
 * 
 * @author LexusDrumgold
 *
 */
public class Question {

	private HashMap<Responses, Integer> answers = new HashMap<Responses, Integer>();
	private String text;
	private int asked;

	// initialization block -- there are only four possible responses
	{
		for (Responses response : Responses.values()) {
			answers.put(response, 0);
		}
	}

	/**
	 * The default constructor takes text for the question and initializes the
	 * question field if the string is non-empty and non-null.
	 * 
	 * @param text
	 *            question text
	 */
	public Question(String text) {
		this.text = Utilities.validateString(text);
		asked = 0;
	}

	/**
	 * Returns the question's map of answers and number of times those answers were
	 * received.
	 * 
	 * @return HashMap<String, Integer> map of answers and number of times those
	 *         answers were received
	 */
	public HashMap<Responses, Integer> getAnswersMap() {
		return answers;
	}

	/**
	 * Returns the number of times a question was asked.
	 * 
	 * @return int number of times a question was asked
	 */
	public int getTimesAsked() {
		return asked;
	}

	/**
	 * Increments the number of times a question was asked by 1.
	 */
	public void updateTimesAsked() {
		asked++;
	}

	/**
	 * This method takes an enum value from Responses to update the question's
	 * answers received map.
	 * 
	 * @param response
	 *            one of the four enum values
	 */
	public void updateMap(Responses response) {
		answers.replace(response, answers.get(response) + 1);
	}

	/**
	 * Returns the number of times each answer was received in the format: Received
	 * RESPONSE X times.
	 * 
	 * @return String number of times each answer was received
	 */
	public String getQuestionStats() {
		String stats = "";
		for (Responses response : Responses.values()) {
			if (answers.get(response) != 1) {
				stats += "Received " + response.toString() + " " + answers.get(response) + " times.\n";
			} else {
				stats += "Received " + response.toString() + " " + answers.get(response) + " time.\n";
			}
		}
		return stats;
	}

	@Override
	public String toString() {
		return text;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Question)) {
			return false;
		} else {
			Question compare = (Question) obj;
			return text.equals(compare.text);
		}
	}
}
