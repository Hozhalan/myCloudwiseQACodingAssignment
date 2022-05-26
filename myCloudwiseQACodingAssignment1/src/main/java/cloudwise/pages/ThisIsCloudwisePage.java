package cloudwise.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BasePage;

public class ThisIsCloudwisePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h2[text()='Ontdek Cloudwise']")
    public WebElement titleDiscoverCloudwise;
    //@FindBy(how = How.XPATH, using = "//*[@id='core-features']//div[1]/div/h3[text()='Alle Cloudwisers']")
    @FindBy(how = How.XPATH, using = "//*[@id='core-features']/div[2]/div/div/div/div/div[1]/div/div[1]/div/div")
    public WebElement txtAllCloudWisers;
    @FindBy(how = How.XPATH, using = "//*[@id='core-features']/div[2]/div/div/div/div/div[1]/div/div[1]//div/a")
    public WebElement btnAllCloudwisers;
    @FindBy(how = How.XPATH, using = "//*[@id='core-features']/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div[1]")
    public WebElement performFlip;

    private Actions actions;

    public ThisIsCloudwisePage(WebDriver driver) throws InterruptedException {
        super(driver);
        this.webDriver = driver;
    }

    public ThisIsCloudwisePage scrollPageToDiscoverCloudwise() {
        actions = new Actions(webDriver);
        actions.moveToElement(txtAllCloudWisers).perform();
        return this;
    }

    public AllCloudwisersPage clickPageToAllCloudWisers() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", btnAllCloudwisers);
        return new AllCloudwisersPage(webDriver);
    }

}