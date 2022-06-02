package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WorkArounds {
    private final String MENU_ITEM_TO_OPEN = "Sadzīves tehnika";
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final String CATALOGUE_URL = "https://www.1a.lv/c/sadzives-tehnika/virtuvei-maza-sadzives-tehnika/tejkannas-elektriskas/2y2";
    private final By COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By MENU_ITEMS = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By MENU = By.xpath(".//div[@class = 'submenu-lvl1 submenu-lvl1--invisible submenu-lvl1--index']");
    private final By CATALOG_ITEM = By.xpath(".//div[contains(@class, 'catalog-taxons-product--grid-view')]");
    private final By CATALOG_ITEM_NAME = By.xpath(".//a[@class='catalog-taxons-product__name']");
    private WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(COOKIES_BTN));
        driver.findElement(COOKIES_BTN).click();
    }

    @Test
    public void menuWorkaround() {


        List<WebElement> menuItems = driver.findElement(MENU).findElements(MENU_ITEMS);
        for (WebElement we : menuItems) {
            if (we.getText().equals(MENU_ITEM_TO_OPEN)) {
                we.click();
                break;
            }
        }
    }

    @Test
    public void catalogWorkaround() {
        driver.get(CATALOGUE_URL);

        List<WebElement> catalogItems = driver.findElements(CATALOG_ITEM);


        try {
            catalogItems.get(14).click();
        } catch (ElementClickInterceptedException e) {
            catalogItems.get(14).click();
        }

        catalogItems.get(14).findElement(CATALOG_ITEM_NAME).click();

    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
