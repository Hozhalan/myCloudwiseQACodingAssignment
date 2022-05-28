package steps;

import cloudwise.panels.CWMainMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.WebDriverLibrary;

public class HomePageStepDefinition extends BasicStepDefinition {

  public HomePageStepDefinition() {}

  public void getIntoCloudWiseHomePage() throws InterruptedException {
    driver = WebDriverLibrary.getChromeDriver();
    driver.navigate().to("https://cloudwise.nl/");
  }

  @Given("open cloudwise webpage")
  public void open_cloudwise_webpage() throws InterruptedException {
    getIntoCloudWiseHomePage();
  }

  @And("go to 'This is cloudwise'")
  public void go_to_this_is_cloudwise() throws InterruptedException {
    new CWMainMenu(driver).clickOnThisIsCloudwise();
  }

  @Then("close cloudwise webpage")
  public void closeBrower() throws InterruptedException {
    WebDriverLibrary.quitChromeDriver();
  }
}
