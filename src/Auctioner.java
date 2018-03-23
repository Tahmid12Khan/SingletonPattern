import java.util.ArrayList;

public class Auctioner {
	private static Auctioner instance = null;

	private Auctioner() {
	}

	public static Auctioner getInstance() {
		if(instance == null) {
			instance = new Auctioner();
		}
		return instance;
	}

	public ArrayList<Observer> bidders = new ArrayList();
	public ArrayList<Thing> things = new ArrayList();

	public void addBidder(Observer o) {
		bidders.add(o);
	}

	public void addThing(Thing t) {
		things.add(t);
	}

	public void showThing() {
		System.out.println("Now showing thing#" + things.get(0).index);
	}

	public void removeThing() {
		soldUnsold(things.get(0));
		notifyPeopleAboutEnding();
		things.remove(0);
	}

	public void soldUnsold(Thing t) {
		if (t.price == 50) {
			System.out.println("Thing#" + t.index + " not Sold");
		} else {
			System.out.println("Thing#" + t.index + " is sold for " + t.price);
		}
	}

	public void bid(int id) {
		if(checker(id) == false) {
			return;
		}
		Observer o = bidders.get(id - 1);
		o.bid();
		things.get(0).setLastBidder(id);
		things.get(0).increasePrice();
		notifyPeopleAboutPriceIncrease();
	}
	
	public boolean checker(int id) {
		if(things.get(0).lastBidder == id) {
			System.out.println("Last bidder was already id#" + id);
			return false;
		}
		return true;
	}

	public void notifyPeopleAboutPriceIncrease() {
		for (int i = 0; i < bidders.size(); i++) {
			bidders.get(i).getNotifiedAboutPriceIncrease(things.get(0).index, things.get(0).price);
		}
	}

	public void notifyPeopleAboutEnding() {
		for (int i = 0; i < bidders.size(); i++) {
			bidders.get(i).getNotifiedAboutBidEnding(things.get(0).index);
		}
	}
}
