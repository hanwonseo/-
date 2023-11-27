import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Deck {
	private List<Card> cards;
	private int index;

	public Deck() {
		String[] suits = { "♠", "♥", "♦", "♣" };
		String[] ranks = { "A","2","3","4","5","6","7","8","9", "10", "K", "Q", "J" };

		cards = new ArrayList<>();

		for (String suit : suits) {
			for (String rank : ranks) {
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}

		shuffle();
		index = 0;
	}

	private void shuffle() {
		Random random = new Random();
		for (int i = cards.size() - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			Card temp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, temp);
		}
	}

	public Card drawCard() {
		if (index >= cards.size()) {
			System.out.println("카드가 모두 소진되었습니다. 셔플합니다.");
			shuffle();
			index = 0;
		}

		return cards.get(index++);
	}
}