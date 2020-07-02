package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderSection;

public class TestBase {
    protected WebDriver driver;
    protected HeaderSection headerSection;

    @BeforeEach
    public void baseSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\AutomationCIPO\\chromedriver_win32_Ch83\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://uitest.duodecadits.com");
        driver.manage().window().maximize();
        headerSection = new HeaderSection(driver);
    }

    @AfterEach
    public void tearDown() {
        if(driver!=null)
        driver.quit();
    }

}
