package magic8ball;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a Magic Eight Ball. It has four responses, which are
 * stored in an external Enum class. The MagicEightBall class also keeps of the
 * people who asked it questions.
 * 
 * @author LexusDrumgold
 *
 */
public class MagicEightBall {
	private ArrayList<Person> people;

	/**
	 * Default, no argument constructor for the class.
	 */
	public MagicEightBall() {
		people = new ArrayList<Person>();
	}

	/**
	 * This method takes a Person object as argument and the object to the people
	 * list if the object is non-null and object isn't already contained in the
	 * list. It returns a string stating who shook the eight ball, what they asked,
	 * and the response.
	 * 
	 * @param person
	 *            person to shake the magic eight ball
	 * @return string stating who shook the eight ball, what they asked, and the
	 *         response
	 */
	public String shake(Person person) {
		if (person != null && !people.contains(person)) {
			people.add(person);
		} else if (person == null) {
			throw new IllegalArgumentException("Error: Not a person.");
		}

		int rand = (new Random()).nextInt(4);
		Responses response = Responses.values()[rand];
		Question question = person.getQuestion();

		question.updateTimesAsked();
		question.updateMap(response);

		return person.toString() + "\nThe magic eight ball said...\n" + response.toString();
	}

	/**
	 * Returns the number of people who have used the magic eight ball.
	 * 
	 * @return int number of people who have used the eight ball
	 */
	public int numberOfPeopleInList() {
		return people.size();
	}

}
