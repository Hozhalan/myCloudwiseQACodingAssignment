package cloudwise.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BasePage;

public class ThisIsCloudwisePage extends BasePage {
  private static ThisIsCloudwisePage instance;

  @FindBy(how = How.XPATH, using = "//*[@id='core-features']/div[2]//div[1]/div/div[1]/div/div")
  public WebElement txtAllCloudWisers;

  @FindBy(how = How.XPATH, using = "//*[@id='core-features']/div[2]//div[1]/div/div[1]//div/a")
  public WebElement btnAllCloudwisers;

  private ThisIsCloudwisePage(WebDriver driver) {
    super(driver);
    this.webDriver = driver;
  }

  public static ThisIsCloudwisePage construct(WebDriver driver) {
    instance = new ThisIsCloudwisePage(driver);
    return instance;
  }

  public static ThisIsCloudwisePage getInstance() {
    return instance;
  }

  public ThisIsCloudwisePage scrollPageToDiscoverCloudwise() {
    Actions actions = new Actions(webDriver);
    actions.moveToElement(txtAllCloudWisers).perform();
    return this;
  }

  public void clickPageToAllCloudWisers() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("arguments[0].click();", btnAllCloudwisers);
    AllCloudwisersPage.construct(webDriver);
  }
}
