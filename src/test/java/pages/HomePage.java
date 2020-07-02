package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageBase {

    @FindBy(xpath = "//div[@class='ui-test']")
    private WebElement homeText;
    @FindBy(xpath = "//p[@class='lead']")
    private WebElement homeParagraphText;
    @FindBy(xpath = "//img[@id='dh_logo']")
    private WebElement image;
    @FindBy(tagName = "a")
    private List<WebElement> linksElements;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromHomePage() {
        return homeText.getText();
    }

    public String getParagraphTextFromHomePage() {
        return homeParagraphText.getText();
    }

    public boolean verifyLogo(String link) {
        boolean imageStatus;// = false;
        if (image.isDisplayed() == true) {
            imageStatus = true;

        } else {
            imageStatus = false;
            System.out.println("on page" + link + "the image is not present");
        }
        return imageStatus;
    }

    public List<String> createListOfLinks() {
       // List<WebElement> linksElements = driver.findElements(By.tagName("a"));
        List<String> links = new ArrayList<>();

        for (WebElement link : linksElements) {
            if (link.getAttribute("href") != null && !link.getText().isEmpty()) {
                links.add(link.getAttribute("href"));
            }
        }
        return links;
    }
}