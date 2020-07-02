package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSection extends PageBase {
    @FindBy(xpath = "//a[@id='home']")
    private WebElement homeLink;
    @FindBy(xpath = "//a[@id='form']")
    private WebElement formLink;
    @FindBy(xpath = "//a[@id='error']")
    private WebElement errorLink;
    @FindBy(xpath = "//a[@id='site']")
    private WebElement uiTestingLink;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }
    public FormPage goToFormPage(){
        formLink.click();
        return new FormPage(driver);
    }

    public ErrorPage goToErrorPage(){
        errorLink.click();
        return new ErrorPage(driver);
    }

    public UITestingPage goToUITestingPage(){
        uiTestingLink.click();
        return new UITestingPage(driver);
    }
}

