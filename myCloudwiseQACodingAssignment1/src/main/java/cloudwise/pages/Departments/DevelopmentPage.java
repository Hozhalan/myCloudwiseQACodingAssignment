package cloudwise.pages.Departments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BasePage;

import java.util.ArrayList;
import java.util.List;

public class DevelopmentPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[1]/div/h3/../..")
    public List<WebElement> userInfo;
    @FindBy(how = How.XPATH, using = "//div[1]/div/h3")
    public List<WebElement> txtName;

    public DevelopmentPage(WebDriver driver) throws InterruptedException {
        super(driver);
    }

    public List<String> getEmployeeRecords() throws InterruptedException {
        List<String> txtUserNames = new ArrayList<>();
        for (WebElement name : txtName) {
            String userNames = name.getText();
            txtUserNames.add(userNames);
        }
        return txtUserNames;
    }
}
