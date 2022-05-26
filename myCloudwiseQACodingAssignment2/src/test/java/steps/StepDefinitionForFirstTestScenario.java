package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLibrary;

import java.util.concurrent.TimeUnit;

public class StepDefinitionForFirstTestScenario {

    private final String pointFirstTxtBox = "//div[1]/div[2]/div/mat-form-field[1]";
    private final String pointSecondTxtBox = "//div[1]/div[2]/div/mat-form-field[2]";
    private final String firstTxtBox = "//*[@id='mat-input-0']";
    private final String secondTxtBox = "//*[@id='mat-input-1']";
    private final String outputValue = "//*[@id='mat-input-2']";
    WebDriver webDriver;
    String route = "https://gatekeeper.codeshake.dev/test";
    private int total = 0;

    public StepDefinitionForFirstTestScenario() throws InterruptedException {
        super();
    }

    @Given("open cloudwise webpage for first test scenario")
    public void open_cloudwise_webpage() throws InterruptedException {
        webDriver = WebDriverLibrary.getChromeDriver();
        webDriver.navigate().to(route);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("enter the first value as {string}")
    public void enter_the_first_value(String firstValue) {
        int firstValuePoint = Integer.parseInt(firstValue);
        total = total + firstValuePoint;
        webDriver.findElement(By.xpath(pointFirstTxtBox)).click();
        webDriver.findElement(By.xpath(firstTxtBox)).sendKeys(firstValue);
    }

    @And("enter the second value as {string}")
    public void enter_the_second_value(String secondValue) {
        int secondValuePoint = Integer.parseInt(secondValue);
        total = total + secondValuePoint;
        webDriver.findElement(By.xpath(pointSecondTxtBox)).click();
        webDriver.findElement(By.xpath(secondTxtBox)).sendKeys(secondValue);
        webDriver.findElement(By.xpath(secondTxtBox)).getText();
    }

    @Then("verify the total value")
    public void verify_the_total_value() {
        String actualOutput = webDriver.findElement(By.xpath(outputValue)).getAttribute("value");
        String expectedOutput = Integer.toString(total);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Then("close cloudwise webpage for first test scenario")
    public void close_cloudwise_webpage() {
        webDriver.quit();
    }


}
