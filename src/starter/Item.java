package starter;

public class Item {
	public enum Type  {
		DOUBLESHOT, UP1, BURST, IVINC, DOUBLESCORE;
		}
	Type type;
	private boolean isUsed, isBought;
	int price;
	public Item(Type Ntype, int Nprice) {
		isUsed = false;
		isBought = false;
		type = Ntype;
		price = Nprice;
	}
	void useItem() {
		isUsed = true;
	}
	void buyItem() {
		isBought = true;
	}
	Type getType() {
		return type;
	}
	boolean getIsBought() {
		return isBought;
	}
	int getPrice(){
		return price;
	}
}
