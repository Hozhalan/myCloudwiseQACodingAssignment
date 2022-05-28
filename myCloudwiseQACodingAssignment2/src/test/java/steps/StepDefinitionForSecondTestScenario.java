package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.PathValues.OUTPUT_VALUE;
import static utils.PathValues.TXT_BOX_POINT;
import static utils.PathValues.TXT_SEARCH_BOX;

@Slf4j
public class StepDefinitionForSecondTestScenario extends BasicStepDefinition {

  public StepDefinitionForSecondTestScenario() {}

  @Given("open gatekeeper webpage for second test scenario")
  public void open_gatekeeper_webpage() throws InterruptedException {
    log.info("open gatekeeper webpage for second test scenario");
    openGatekeeperWebpage();
  }

  @And("click on the text search box")
  public void click_on_the_text_search_box() {
    wait = new WebDriverWait(webDriver, Duration.ofSeconds(GLOBAL_TIMEOUT));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TXT_BOX_POINT)));
    webDriver.findElement(By.xpath(TXT_BOX_POINT)).click();
  }

  @And("enter the key value as {string}")
  public void enter_the_key_value(String searchValue) {

    webDriver.findElement(By.xpath(TXT_SEARCH_BOX)).sendKeys(searchValue);
    webDriver.findElement(By.xpath(TXT_SEARCH_BOX)).sendKeys(Keys.ENTER);
  }

  @Then("validate the output")
  public void validate_the_output() {

    WebElement actualOutput = webDriver.findElement(By.xpath(OUTPUT_VALUE));
    Assert.assertTrue(actualOutput.isEnabled());
  }

  @Then("close gatekeeper webpage for second test scenario")
  public void close_gatekeeper_webpage() {

    log.info("close gatekeeper webpage for second test scenario");
    closeGatekeeperWebpage();
  }
}
