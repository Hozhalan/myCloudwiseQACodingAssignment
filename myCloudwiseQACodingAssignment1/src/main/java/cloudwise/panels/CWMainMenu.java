package cloudwise.panels;

import cloudwise.pages.ThisIsCloudwisePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.time.Duration;

public class CWMainMenu extends BasePage {

  @FindBy(how = How.XPATH, using = "//*[@id='menu-item-6352']//a[text()='Dit is Cloudwise']")
  public WebElement btnThisIsCloudwise;

  public CWMainMenu(WebDriver driver) {
    super(driver);
    this.webDriver = driver;
  }

  public void clickOnThisIsCloudwise() {

    new WebDriverWait(webDriver, Duration.ofSeconds(GLOBAL_TIMEOUT))
        .until(ExpectedConditions.elementToBeClickable(btnThisIsCloudwise))
        .click();
    ThisIsCloudwisePage.construct(webDriver);
  }
}
