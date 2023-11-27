import java.util.List;

class Dealer {
	private Hand hand;

	public Dealer() {
		hand = new Hand();
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getValue();
	}

	public List<Card> getHand() {
		return hand.getCards();
	}
	
	public void resetHand() {
		hand = new Hand();
	}
}