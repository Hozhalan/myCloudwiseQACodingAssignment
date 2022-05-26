package cloudwise.panels;

import cloudwise.pages.ThisIsCloudwisePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;


public class CWMainMenu extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-6212']//a[text()='Home']")
    public WebElement btnHome;
    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-6381']//a[text()='ICT-Oplossingen']")
    public WebElement btnItSolutions;
    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-20007']//a[text()='Academy']")
    public WebElement btnAcademy;
    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-6352']//a[text()='Dit is Cloudwise']")
    public WebElement btnThisIsCloudwise;
    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-17672']//a[text()='Vacatures']")
    public WebElement btnVacatures;
    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-6772']//a[text()='Nieuws & blog']")
    public WebElement btnNewsAndBlog;
    @FindBy(how = How.XPATH, using = "//*[@id='enu-item-6626']//a[text()='Contact']")
    public WebElement btnContact;

    public CWMainMenu(WebDriver driver) throws InterruptedException {
        super(driver);
        this.webDriver = driver;
    }

    public ThisIsCloudwisePage clickOnThisIsCloudwise() throws InterruptedException {

        new WebDriverWait(webDriver, GLOBAL_TIMEOUT).until(ExpectedConditions.elementToBeClickable(btnThisIsCloudwise))
                .click();
        return new ThisIsCloudwisePage(webDriver);
    }

}
