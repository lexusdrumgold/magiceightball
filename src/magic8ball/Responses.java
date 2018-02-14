package magic8ball;

public enum Responses {
	YES("Yes"), NO("No"), MAYBE("Maybe"), LATER("Ask again later.");

	private final String response;

	private Responses(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return response;
	}
}
