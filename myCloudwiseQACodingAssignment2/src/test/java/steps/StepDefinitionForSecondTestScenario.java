package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverLibrary;

import java.util.concurrent.TimeUnit;

public class StepDefinitionForSecondTestScenario {

    private final String txtBox = "//*[@id='mat-input-3']";
    private final String pointTxtBox = "//div/div[1]/div[3]/div/mat-form-field";
    private final String outputValue = "//div/div/div[1]/div[3]/div/div";
    WebDriver webDriver;
    String route = "https://gatekeeper.codeshake.dev/test";
    private WebElement actualOutput;

    public StepDefinitionForSecondTestScenario() throws InterruptedException {
    }

    @Given("open cloudwise webpage for second test scenario")
    public void open_cloudwise_webpage() throws InterruptedException {
        webDriver = WebDriverLibrary.getChromeDriver();
        webDriver.navigate().to(route);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("click on the text search box")
    public void click_on_the_text_search_box() {
        webDriver.findElement(By.xpath(pointTxtBox)).click();
    }

    @And("enter the key value as {string}")
    public void enter_the_key_value(String searchValue) {
        webDriver.findElement(By.xpath(txtBox)).sendKeys(searchValue);
        webDriver.findElement(By.xpath(txtBox)).sendKeys(Keys.ENTER);
    }

    @Then("validate the output")
    public void validate_the_output() {
        actualOutput = webDriver.findElement(By.xpath(outputValue));
        Assert.assertTrue(actualOutput.isEnabled());
    }

    @Then("close cloudwise webpage for second test scenario")
    public void close_cloudwise_webpage() {
        webDriver.quit();
    }

}
