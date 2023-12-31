import java.util.ArrayList;
import java.util.List;

class Hand {
	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getValue() {
		int value = 0;
		int aceCount = 0;

		for (Card card : cards) {
			value += card.getValue();

			if (card.getValue() == 11) {
				aceCount++;
			}
		}

		while (value > 21 && aceCount > 0) {
			value -= 10;
			aceCount--;
		}

		return value;
	}
}