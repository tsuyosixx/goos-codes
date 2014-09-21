package actionsniper;

import static org.hamcrest.core.IsEqual.equalTo;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

/**
 * Created by tsuyosixx on 2014/09/21.
 */
public class AuctionSniperDriver extends JFrameDriver {
    public AuctionSniperDriver(int timeoutMills) {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(Main.MAIN_WINDOW_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutMills, 100));
    }

    public void showsSniperStatus(String statusText) {
        new JLabelDriver(
                this, named(Main.SNIPER_STATUS_NAME)
        ).hasText(equalTo(statusText));
    }
}
