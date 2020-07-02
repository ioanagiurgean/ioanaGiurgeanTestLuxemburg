package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormPage extends PageBase {

    @FindBy(xpath = "//div[@class='ui-test']")
    private WebElement homeText;
    @FindBy(xpath = "//input[@id='hello-input']")
    private WebElement helloInput;
    @FindBy(xpath = "//button[@id='hello-submit']")
    private WebElement helloSubmitButton;

    public FormPage(WebDriver driver) {
        super(driver);
       }

    public boolean getURLFromPage(){
        return wait.until(ExpectedConditions.urlContains("form"));
    }
    public boolean checkInputBoxIsDisplayed(){
        return helloInput.isDisplayed();
    }
    public boolean checkSubmitButtonIsDisplayed(){
        return helloSubmitButton.isDisplayed();
    }
    public ResultsPage setInputValue(String inputName){
        helloInput.clear();
        helloInput.sendKeys(inputName);
        helloSubmitButton.click();
        return new ResultsPage(driver);
    }
}