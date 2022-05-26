package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverLibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefinitionForThirdTestScenario {

    private final String btnBattle = "//div/div[1]/div[4]/button";
    private final String outputValue = "//div/div/div[1]/div[3]/div/div";
    private final String popupPath = "//div/mat-dialog-container[@id='mat-dialog-0']/app-popup-dialog/div/div/i";
    String route = "https://gatekeeper.codeshake.dev/test";
    private WebDriver webDriver;
    private WebElement currentElement = null;

    public StepDefinitionForThirdTestScenario() throws InterruptedException {
    }

    @Given("open cloudwise webpage for third test scenario")
    public void open_cloudwise_webpage() throws InterruptedException {
        webDriver = WebDriverLibrary.getChromeDriver();
        webDriver.navigate().to(route);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @And("click on the battle button")
    public void click_on_the_battle_button() {
        webDriver.findElement(By.xpath(btnBattle)).click();
    }

    @And("get the value from popup")
    public WebElement get_the_value_from_popup() {
        List<WebElement> elements = webDriver.findElements(By.xpath(popupPath));
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

    @Then("close cloudwise webpage for third test scenario")
    public void close_cloudwise_webpage() {
        webDriver.quit();
    }

}
