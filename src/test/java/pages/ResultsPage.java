package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends PageBase {
    @FindBy(xpath = "//h1[@id='hello-text']")
    private WebElement helloText;

    public ResultsPage(WebDriver driver) {
        super(driver);
         }
    public String getHelloMessage(){
        return helloText.getText();
    }

}