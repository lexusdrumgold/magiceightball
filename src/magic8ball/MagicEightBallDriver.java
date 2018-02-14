package magic8ball;

/**
 * Driver for the Magic Eight Ball program.
 *  
 * @author LexusDrumgold
 *
 */
public class MagicEightBallDriver {
	private final static MagicEightBall MAGIC_EIGHT_BALL = new MagicEightBall();
	
	public static void main(String[] args) {
		Person johnSmith = new Person("John", "Will I be famous one day?");
		Person janeDoe = new Person("Jane", "Will I win the lottery?");

		MAGIC_EIGHT_BALL.shake(johnSmith);
		MAGIC_EIGHT_BALL.shake(janeDoe);
		MAGIC_EIGHT_BALL.shake(johnSmith);
		MAGIC_EIGHT_BALL.shake(janeDoe);
		MAGIC_EIGHT_BALL.shake(johnSmith);
		MAGIC_EIGHT_BALL.shake(janeDoe);
		
		Question johnQuestion = johnSmith.getQuestion();
		Question janeQuestion = janeDoe.getQuestion();
		
		String johnString = johnSmith.toString() + " " + johnQuestion.getTimesAsked();
		String janeString = janeDoe.toString() + " " + janeQuestion.getTimesAsked();
		
		if (johnQuestion.getTimesAsked() != 1) {
			johnString += " times.";
		} else {
			johnString += " time.";
		}
		if (janeQuestion.getTimesAsked() != 1) {
			janeString += " times.";
		} else {
			janeString += " time.";
		}
		
		System.out.println(johnString);
		System.out.println(johnQuestion.getQuestionStats());
		
		System.out.println(janeString);
		System.out.println(janeQuestion.getQuestionStats());	
	}
}
