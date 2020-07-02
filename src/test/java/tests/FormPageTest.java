package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FormPageTest extends TestBase {

    private FormPage formPage;
    private ResultsPage resultsPage;

    //REQ-UI-05 When I click on the Form button, I should get navigated to the Form page
    @Test
    public void REQ_UI_05_checkFormPageLink() {
        headerSection.goToFormPage();
        formPage = new FormPage(driver);
        assertTrue(formPage.getURLFromPage());
    }

    //REQ-UI-06 When I click on the Form button, it should turn to active status
    @Test
    public void REQ_UI_06_checkActiveStatusOfFormPage() {
        headerSection.goToFormPage();
        formPage = new FormPage(driver);
        WebElement link = driver.findElement(By.cssSelector("[id='form']"));
        String linkClass = link.findElement(By.xpath("./..")).getAttribute("class");
        assertThat(linkClass, is("active"));
    }
    //REQ-UI-11 On the Form page, a form should be visible with one input box and one submit button
    @Test
    public void REQ_UI_11_checkInputBoxAndSubmitButtonOnFormPage() {
        headerSection.goToFormPage();
        formPage = new FormPage(driver);
        assertTrue(formPage.checkInputBoxIsDisplayed());
        //I used two asserts in one test because AND logic is present between two requests in according with the requirement.
        assertTrue(formPage.checkSubmitButtonIsDisplayed());
    }

    /*REQ-UI-12
    On the Form page, if you type <value> the input field and submit the form, you should get redirect to the
    Hello page, and the following text should appear: <result>
     */
    @Test
    public void REQ_UI_12_checkInputAndSubmitFunctionality() {
        headerSection.goToFormPage();
        formPage = new FormPage(driver);
        List<String> inputName = Arrays.asList("", "John", "Sophia", "Charline", "Emily");
        for (int index = 0; index < inputName.size(); index++) {
            formPage.setInputValue(inputName.get(index));
            resultsPage = new ResultsPage(driver);
            if (inputName.get(index) == "") {
                assertThat(resultsPage.getHelloMessage(), containsString("Hello !"));
                driver.navigate().back();
            } else {
                assertThat(resultsPage.getHelloMessage(), containsString("Hello " + inputName.get(index) + "!"));
                driver.navigate().back();
            }
        }
    }
}