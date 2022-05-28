package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.PathValues.TXT_BOX_FIRST;
import static utils.PathValues.TXT_BOX_OUTPUT_VALUE;
import static utils.PathValues.TXT_BOX_POINT_FIRST;
import static utils.PathValues.TXT_BOX_POINT_SECOND;
import static utils.PathValues.TXT_BOX_SECOND;

@Slf4j
public class StepDefinitionForFirstTestScenario extends BasicStepDefinition {

  private int total = 0;

  public StepDefinitionForFirstTestScenario() throws InterruptedException {
    super();
  }

  @Given("open gatekeeper webpage for first test scenario")
  public void open_gatekeeper_webpage() throws InterruptedException {
    log.info("open gatekeeper webpage for first test scenario");
    openGatekeeperWebpage();
  }

  @And("enter the first value as {string}")
  public void enter_the_first_value(String firstValue) {
    enterTheValue(firstValue, TXT_BOX_POINT_FIRST, TXT_BOX_FIRST);
  }

  @And("enter the second value as {string}")
  public void enter_the_second_value(String secondValue) {
    enterTheValue(secondValue, TXT_BOX_POINT_SECOND, TXT_BOX_SECOND);
  }

  public void enterTheValue(String value, String txtBoxPath, String txtBox) {
    wait = new WebDriverWait(webDriver, Duration.ofSeconds(GLOBAL_TIMEOUT));
    int secondValuePoint = Integer.parseInt(value);
    total = total + secondValuePoint;
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtBoxPath)));
    webDriver.findElement(By.xpath(txtBoxPath)).click();
    webDriver.findElement(By.xpath(txtBox)).sendKeys(value);
  }

  @Then("verify the total value")
  public void verify_the_total_value() {
    String actualOutput =
        webDriver.findElement(By.xpath(TXT_BOX_OUTPUT_VALUE)).getAttribute("value");
    String expectedOutput = Integer.toString(total);
    Assert.assertEquals(expectedOutput, actualOutput);
  }

  @Then("close gatekeeper webpage for first test scenario")
  public void close_gatekeeper_webpage() {
    log.info("Close gatekeeper webpage for first test scenario");
    closeGatekeeperWebpage();
  }
}
