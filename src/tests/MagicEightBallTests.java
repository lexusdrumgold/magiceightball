package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import magic8ball.MagicEightBall;
import magic8ball.Person;

class MagicEightBallTests {
	
	/**
	 * Tests the shake method from the MagicEightBall class. It specifically tests
	 * that when a new person asks a question, they're added to the magic eight
	 * ball's people list.
	 */
	@Test
	void testShake() {
		MagicEightBall ball = new MagicEightBall();
		Person lex = new Person("Lex", "Will I be famous one day?");

		assertTrue(ball.numberOfPeopleInList() == 0);
		System.out.println(ball.shake(lex));
		assertTrue(ball.numberOfPeopleInList() == 1);
	}
	
	/**
	 * Tests the updateAnswerMap method from the Question class. It specifically tests
	 * that the map is being correctly updated.
	 */
	@Test
	void testUpdateQuestionAnswerMap() {
		MagicEightBall ball = new MagicEightBall();
		Person lex = new Person("Lex", "Will I be famous one day?");

		System.out.println(ball.shake(lex));
		System.out.println(ball.shake(lex));
		System.out.println(ball.shake(lex));
		System.out.println(ball.shake(lex));
		System.out.println(ball.shake(lex));
		System.out.println(ball.shake(lex));
		System.out.println(ball.shake(lex));
		
		assertTrue(lex.getQuestion().getTimesAsked() == 7);
		System.out.println(lex.getQuestion().getAnswersMap());
	}


}
