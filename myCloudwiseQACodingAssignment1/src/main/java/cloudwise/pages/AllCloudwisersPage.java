package cloudwise.pages;

import cloudwise.pages.Departments.AcademyPage;
import cloudwise.pages.Departments.DevelopmentPage;
import cloudwise.pages.Departments.HRAndAdministrationPage;
import cloudwise.pages.Departments.ManagementPage;
import cloudwise.pages.Departments.MarketingPage;
import cloudwise.pages.Departments.ProjectsAndSupportPage;
import cloudwise.pages.Departments.SalesPage;
import cloudwise.pages.Departments.SupportPage;
import cloudwise.pages.Departments.WarehousePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AllCloudwisersPage extends BasePage {

  private static AllCloudwisersPage instance;
  private final List<String> departmentList = new ArrayList<>();

  @FindBy(how = How.XPATH, using = "//div[1]/div/h3")
  public List<WebElement> txtDepartments;

  @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/div/div/div[1]/div/h3")
  public WebElement txtDepartment;

  JavascriptExecutor js = (JavascriptExecutor) webDriver;
  Actions actions = new Actions(webDriver);

  private AllCloudwisersPage(WebDriver driver) {
    super(driver);
    this.webDriver = driver;
  }

  public static AllCloudwisersPage construct(WebDriver driver) {
    instance = new AllCloudwisersPage(driver);
    return instance;
  }

  public static AllCloudwisersPage getInstance() {
    return instance;
  }

  public List<String> scrollPageToAllCloudWisers() throws InterruptedException {

    for (WebElement findDepartment : txtDepartments) {
      String departmentName = findDepartment.getText();
      departmentList.add(departmentName);
    }

    for (String findDepartmentName : departmentList) {

      String UpdateFindDepartmentName = "//../h3[text()='" + findDepartmentName + "']";
      String updatedFindDepartments = "//../../../div[2]/div/a";
      WebElement findDepartment = txtDepartment.findElement(By.xpath(UpdateFindDepartmentName));
      actions.moveToElement(findDepartment).perform();
      switch (findDepartmentName) {
        case "Directie":
          String findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(
              goIntoPage(findDepartmentPath, () -> new ManagementPage(webDriver)));

          break;
        case "Support":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(goIntoPage(findDepartmentPath, () -> new SupportPage(webDriver)));

          break;
        case "Projecten & Support":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(
              goIntoPage(findDepartmentPath, () -> new ProjectsAndSupportPage(webDriver)));

          break;
        case "Sales":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(goIntoPage(findDepartmentPath, () -> new SalesPage(webDriver)));

          break;
        case "Marketing":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(
              goIntoPage(findDepartmentPath, () -> new MarketingPage(webDriver)));

          break;
        case "Academy":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(goIntoPage(findDepartmentPath, () -> new AcademyPage(webDriver)));

          break;
        case "Development":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(
              goIntoPage(findDepartmentPath, () -> new DevelopmentPage(webDriver)));

          break;
        case "HR & Administratie":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(
              goIntoPage(findDepartmentPath, () -> new HRAndAdministrationPage(webDriver)));

          break;
        case "Logistiek & Service":
          findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
          totalUserDetails.addAll(
              goIntoPage(findDepartmentPath, () -> new WarehousePage(webDriver)));
          break;
        default:
          throw new IllegalStateException("Unexpected value: " + findDepartmentName);
      }
    }

    return totalUserDetails;
  }

  public List<String> goIntoPage(String btnFindDepartment, Supplier<BasePage> pageSupplier)
      throws InterruptedException {
    WebElement pathElement = webDriver.findElement(By.xpath(btnFindDepartment));
    js.executeScript("arguments[0].click();", pathElement);
    List<String> userRecords = pageSupplier.get().getEmployeeRecords();
    webDriver.navigate().back();
    return userRecords;
  }
}
