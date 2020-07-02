package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends PageBase {

    @FindBy(xpath = "//h1[contains(text(),'404 Error: File not found :-(')]")
    private WebElement errorText;

    public ErrorPage(WebDriver driver) { super(driver); }

    public String getTextFromErrorPage(){

        return errorText.getText();
    }
}