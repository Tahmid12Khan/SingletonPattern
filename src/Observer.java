
public interface Observer {
	public void bid();
	public void getNotifiedAboutPriceIncrease(int thingId, int price);
	public void getNotifiedAboutBidEnding(int thingId);
}
