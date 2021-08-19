package starter;

import starter.Item.Type;

public class Shop {
	Item[] shopList = new Item[5];
	public Shop() {
		shopList[0] = new Item(Type.DOUBLESHOT,20);
		shopList[1] = new Item(Type.DOUBLESCORE,50);
		shopList[2] = new Item(Type.BURST,30);
		shopList[3] = new Item(Type.UP1,50);
		shopList[4] = new Item(Type.IVINC,30);
	}
	boolean buyItem(Type type, int coins) {
		for(Item x : shopList) {
			if(x.getType().equals(type) && !x.getIsBought() && x.price <= coins) {
				x.buyItem();
				return true;
			}
		}
		return false;
	}
}
