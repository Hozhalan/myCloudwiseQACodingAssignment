package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLibrary;

import java.util.List;

public class BasicStepDefinition {

  WebDriver driver;
  List<String> verifyDuplicate;

  public BasicStepDefinition() {}

  public BasicStepDefinition(WebDriver driver) {
    this.driver = driver;
    driver.navigate().to("https://cloudwise.nl/");
  }

  public BasicStepDefinition(WebDriver driver, String url) throws InterruptedException {
    driver = WebDriverLibrary.getChromeDriver();
    driver.navigate().to(url);
  }

}
