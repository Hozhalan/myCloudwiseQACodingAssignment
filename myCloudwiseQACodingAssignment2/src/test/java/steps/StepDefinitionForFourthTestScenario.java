package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static utils.PathValues.TXT_ADDRESS_PATH;

@Slf4j
public class StepDefinitionForFourthTestScenario extends BasicStepDefinition {

  WebElement iframe;
  private String actualAddress;

  public StepDefinitionForFourthTestScenario() throws InterruptedException {}

  @Given("open gatekeeper webpage for fourth test scenario")
  public void open_gatekeeper_webpage() throws InterruptedException {
    log.info("open gatekeeper webpage for second fourth scenario");
    openGatekeeperWebpage();
  }

  @And("switch to iFrame")
  public void switch_to_popup() {
    iframe = webDriver.findElement(By.id("iframe"));
    webDriver.switchTo().frame(iframe);
  }

  @And("scroll down to bottom of the page")
  public void scroll_down_to_bottom_of_the_page() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }

  @And("get the address field value")
  public void get_the_address_field_value() {

    actualAddress = webDriver.findElement(By.xpath(TXT_ADDRESS_PATH)).getText();
  }

  @Then("verify retrieved address is equal to {string}")
  public void verify_retrieved_address(String expectedAddress) {
    Assert.assertEquals(expectedAddress, actualAddress);
  }

  @Then("close gatekeeper webpage for fourth test scenario")
  public void close_gatekeeper_webpage() {

    log.info("open gatekeeper webpage for second fourth scenario");
    closeGatekeeperWebpage();
  }
}
