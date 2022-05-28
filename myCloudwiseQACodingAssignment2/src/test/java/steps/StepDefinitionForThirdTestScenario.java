package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.PathValues.BTN_BATTLE;
import static utils.PathValues.POPUP_ELEMENT_PATHS;

@Slf4j
public class StepDefinitionForThirdTestScenario extends BasicStepDefinition {

  private WebElement currentElement = null;

  public StepDefinitionForThirdTestScenario() {}

  @Given("open gatekeeper webpage for third test scenario")
  public void open_gatekeeper_webpage() {
    log.info("open gatekeeper webpage for third test scenario");
    openGatekeeperWebpage();
  }

  @And("click on the battle button")
  public void click_on_the_battle_button() {
    wait = new WebDriverWait(webDriver, Duration.ofSeconds(GLOBAL_TIMEOUT));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_BATTLE)));
    webDriver.findElement(By.xpath(BTN_BATTLE)).click();
  }

  @And("get the value from popup")
  public WebElement get_the_value_from_popup() {
    List<WebElement> elements = webDriver.findElements(By.xpath(POPUP_ELEMENT_PATHS));
    for (WebElement element : elements) {
      if (element.getAttribute("style").contains("color: orange; cursor: pointer;")) {
        return currentElement = element;
      }
    }

    return null;
  }

  @Then("verify the selected element is clickable")
  public void verify_the_selected_element_is_clickable() {
    Assert.assertNotNull(currentElement);
    currentElement.click();
  }

  @Then("close gatekeeper webpage for third test scenario")
  public void close_gatekeeper_webpage() {
    log.info("open gatekeeper webpage for third test scenario");
    closeGatekeeperWebpage();
  }
}
