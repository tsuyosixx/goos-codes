package actionsniper;

import org.junit.After;
import org.junit.Test;

/**
 * Created by tsuyosixx on 2014/09/15.
 */
public class AuctionSniperEndToEndTest {

    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinAuctionUntilAuctionClose() throws Exception {
        auction.startSellingItemk();
        application.startBiddingIn(auction);
        auction.hasReceivedJoinRequestFromSniper();
        auction.announceClose();
        application.showSniperHasLostAuction();

    }

    @After
    public void stopAuction() {
        auction.stop();
    }

    @After
    public void stopApplication() {
        application.stop();
    }

}
