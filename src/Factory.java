import java.util.Scanner;

public class Factory {
	Auctioner auctioner = Auctioner.getInstance();
	Scanner sc = new Scanner(System.in);

	public Factory() {

		System.out.println("Enter number of bidders");

		int bidders = sc.nextInt();

		for (int i = 0; i < bidders; i++) {
			auctioner.addBidder(new Bidder(i + 1));
		}
		System.out.println("Enter number of things");
		int things = sc.nextInt();

		for (int i = 0; i < things; i++) {
			auctioner.addThing(new Thing(i + 1));
		}
		startAuction();

	}

	public void startAuction() {
		while (auctioner.things.size() != 0) {
			try {
				auctioner.showThing();
				System.out.println("Enter bidder id and -1 to quit");
				int bidderId = sc.nextInt();
				if (bidderId == -1) {
					auctioner.removeThing();
				} else {
					auctioner.bid(bidderId);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error. Try again");
			}
		}

	}
}
