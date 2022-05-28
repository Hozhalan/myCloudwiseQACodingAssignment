package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverLibrary {

  protected static WebDriver driver;

  public static WebDriver getChromeDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(false);
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    return driver;
  }
}
