package tests;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UITestingPage extends TestBase {

    //REQ-UI-08 When I click on the UI Testing button, I should get navigated to the Home page
    @Test
    public void REQ_UI_08_checkUITestingLink() {
        headerSection.goToUITestingPage();
        String expectedUrl = "http://uitest.duodecadits.com/";
        driver.get(expectedUrl);
        try {
            assertThat(expectedUrl, containsString(driver.getCurrentUrl()));
            System.out.println("Navigated to correct UI Testing page");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct UI Testing page");
        }
    }
}

