
public class Thing {
	public int price;
	public int index;
	public int lastBidder;
	public Thing(int index){
		this.index = index;
		price = 50;
	}
	public void increasePrice() {
		price += 25;
	}
	public void setLastBidder(int lastBidder) {
		this.lastBidder = lastBidder;
	}
}
