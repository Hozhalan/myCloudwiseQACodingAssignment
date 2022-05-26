package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public static final int GLOBAL_TIMEOUT = 15;
    protected List<String> totalUserDetails = new ArrayList<>();
    protected WebDriver webDriver;

    public BasePage() throws InterruptedException {

    }

    public BasePage(WebDriver driver) throws InterruptedException {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
        this.wait(5000);
    }

    protected List<WebElement> findLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webDriver.findElements(locator);
    }

    protected void wait(int milli) throws InterruptedException {
        Thread.sleep(milli);
    }

}
