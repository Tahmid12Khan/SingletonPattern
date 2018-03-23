
public class Bidder implements Observer{

	int id;
	public Bidder(int id) {
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void bid() {
		// TODO Auto-generated method stub
		System.out.println(id + " bidded");
		
	}
	@Override
	public void getNotifiedAboutPriceIncrease(int thingId, int price) {
		// TODO Auto-generated method stub
		System.out.println(id + " is notified. Price of thing#" + thingId + " is " + price);
		
	}
	@Override
	public void getNotifiedAboutBidEnding(int thingId) {
		// TODO Auto-generated method stub
		System.out.println(id + " is notified. Thing#" + thingId + " bidding is over");
		
	}
	
}
