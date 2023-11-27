import java.util.List;

class Player {
	private Hand hand;
	private int wallet;

	public Player() {
		hand = new Hand();
		wallet = 0;
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

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public void addWallet(int amount) {
		wallet += amount;
	}

	public void subtractWallet(int amount) {
		wallet -= amount;
	}

	public void resetHand() {
		hand = new Hand();
	}
}