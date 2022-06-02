package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebShopTest {

    private final String HOME_PAGE_URL = "http://1a.lv";
    private final By SEARCH_INPUT_FIELD = By.id("q");
    private final By PRODUCT_TYPE = By.xpath(".//span[@class='single-title']");
    private final By COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    @Test
    public void searchFieldChech() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(COOKIES_BTN));
        driver.findElement(COOKIES_BTN).click();

        WebElement searchField = driver.findElement(SEARCH_INPUT_FIELD);
        searchField.sendKeys("Apple");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> subMenuItems = driver.findElements(PRODUCT_TYPE);

        for (WebElement we : subMenuItems) {
            if (we.getText().equals("Apple AirPods")) {
                wait.until(ExpectedConditions.elementToBeClickable(we));
                /*we.click();*/
                try {
                    we.click();
                } catch (ElementClickInterceptedException e) {
                    System.out.println("Can't click from the first try");
                    we.click();
                }

                break;
            }
        }

    }
}
