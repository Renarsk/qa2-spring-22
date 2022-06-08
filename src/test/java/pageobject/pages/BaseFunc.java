package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseFunc {

    private WebDriver driver;

    public BaseFunc(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void closeBrowser(){
        driver.close();
    }

}
