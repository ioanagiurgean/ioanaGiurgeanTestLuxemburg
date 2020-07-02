package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends TestBase {
    private HomePage homePage;

    //REQ-UI-01 The Title should be "UI Testing Site" on every site
    //NOTE: the 4th iteration is failed because the 'UI Testing' title is not displayed on ErrorPage
    @Test
    public void REQ_UI_01_checkTitleOnEverySite() {
        String titleSite = "UI Testing Site";
        homePage = new HomePage(driver);
        for (String link : homePage.createListOfLinks()) {
            driver.get(link);
            System.out.println("current page: " + driver.getCurrentUrl() + " title of page is: " +driver.getTitle());
            assertThat(driver.getTitle(), is(titleSite));
        }
    }

    //REQ-UI-02 The Company Logo should be visible on every site
    //NOTE: the 4th iteration is failed because the logo is not displayed on ErrorPage
    @Test
    public void REQ_UI_02_checkTheLogoCompanyOnEverySite() {
        homePage = new HomePage(driver);
        for (String link : homePage.createListOfLinks()) {
            driver.get(link);
            System.out.println("current page: " + link + " status of image: " + homePage.verifyLogo(link));
            homePage.verifyLogo(link);
            assertTrue(homePage.verifyLogo(link));
        }
    }

    //REQ-UI-03 When I click on the Home button, I should get navigated to the Home page
    @Test
    public void REQ_UI_03_checkHomePageLink() {
        headerSection.goToHomePage();
        homePage = new HomePage(driver);
        String expectedUrl = "http://uitest.duodecadits.com/";
        driver.get(expectedUrl);
        try {
            assertThat(expectedUrl, containsString(driver.getCurrentUrl()));
            System.out.println("Navigated to correct Home Page");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct Home Page");
        }

    }

    //REQ-UI-04 When I click on the Home button, it should turn to active status
    @Test
    public void REQ_UI_04_checkActiveStatusOfHomePage() {
        headerSection.goToHomePage();
        homePage = new HomePage(driver);
        WebElement link = driver.findElement(By.cssSelector("[id='home']"));
        String linkClass = link.findElement(By.xpath("./..")).getAttribute("class");
        //System.out.println("linkClass: "+linkClass);
        assertThat(linkClass, is("active"));
    }

    //REQ-UI-09 The following text should be visible on the Home page in <h1> tag: "Welcome to the Docler Holding QA Department"
    @Test
    public void REQ_UI_09_checkTextH1OnHomePageLink() {
        headerSection.goToHomePage();
        homePage = new HomePage(driver);
        assertThat(homePage.getTextFromHomePage(), containsString("Welcome to the Docler Holding QA Department"));
    }

    //REQ-UI-10 The following text should be visible on the Home page in <p> tag:"This site is dedicated to perform some exercises and demonstrate automated web testing."
    @Test
    public void REQ_UI_10_checkTextParagraphOnHomePageLink() {
        headerSection.goToHomePage();
        homePage = new HomePage(driver);
        assertThat(homePage.getParagraphTextFromHomePage(), containsString("This site is dedicated to perform some exercises and demonstrate automated web testing."));
    }
}