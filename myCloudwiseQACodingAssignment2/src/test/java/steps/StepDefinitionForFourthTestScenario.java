package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverLibrary;

import java.util.concurrent.TimeUnit;

public class StepDefinitionForFourthTestScenario {

    WebDriver webDriver;
    String route = "https://gatekeeper.codeshake.dev/test";
    WebElement iframe;
    private final String addressPath = "//*[@id='comp-kvi6khho']/p/span/span";
    private String actualAddress;

    public StepDefinitionForFourthTestScenario() throws InterruptedException {
    }

    @Given("open cloudwise webpage for fourth test scenario")
    public void open_cloudwise_webpage() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver = WebDriverLibrary.getChromeDriver();
        webDriver.navigate().to(route);
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
        actualAddress = webDriver.findElement(By.xpath(addressPath)).getText();
    }

    @Then("verify retrieved address is equal to {string}")
    public void verify_retrieved_address(String expectedAddress) {
        Assert.assertEquals(expectedAddress, actualAddress);
    }

    @Then("close cloudwise webpage for fourth test scenario")
    public void close_cloudwise_webpage() {
        webDriver.quit();
    }


}
