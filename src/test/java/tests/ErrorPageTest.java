package tests;

import org.junit.jupiter.api.Test;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ErrorPageTest extends TestBase {

    private ErrorPage errorPage;
    //REQ-UI-07 When I click on the Error button, I should get a 404 HTTP response code
    @Test
    public void REQ_UI_07_checkErrorMessageOnErrorPage() {
        headerSection.goToErrorPage();
        errorPage = new ErrorPage(driver);
        assertThat(errorPage.getTextFromErrorPage(), containsString("404 Error: File not found :-("));
    }
}