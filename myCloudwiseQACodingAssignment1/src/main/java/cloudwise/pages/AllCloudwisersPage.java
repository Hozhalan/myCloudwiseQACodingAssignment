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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllCloudwisersPage extends BasePage {

    private final String updatedFindDepartments = "//../../../div[2]/div/a";
    private final List<String> departmentList = new ArrayList<>();
    @FindBy(how = How.XPATH, using = "//div[1]/div/h3")
    public List<WebElement> txtDepartments;
    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/div/div/div[1]/div/h3")
    public WebElement txtDepartment;
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    Actions actions = new Actions(webDriver);
    private List<String> managementUserRecords;
    private List<String> supportUserRecords;
    private List<String> projectsAndSupportUserRecords;
    private List<String> salesUserRecords;
    private List<String> marketingUserRecords;
    private List<String> academyUserRecords;
    private List<String> developmentPageUserRecords;
    private List<String> administrationUserRecords;
    private List<String> warehouseUserRecords;

    private WebElement departmentPath;
    private String findDepartmentPath;

    public AllCloudwisersPage(WebDriver driver) throws InterruptedException {
        super(driver);
        this.webDriver = driver;
    }

    public List<String> scrollPageToAllCloudWisers() throws InterruptedException {

        for (WebElement findDepartment : txtDepartments) {
            String departmentName = findDepartment.getText();
            departmentList.add(departmentName);
        }

        for (String findDepartmentName : departmentList) {

            String UpdateFindDepartmentName = "//../h3[text()='" + findDepartmentName + "']";
            WebElement findDepartment = txtDepartment.findElement(By.xpath(UpdateFindDepartmentName));
            actions.moveToElement(findDepartment).perform();

            if (findDepartmentName.equals("Directie")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoManagementPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Support")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoSupportPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Projecten & Support")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoProjectsAndSupportPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Sales")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoSalesPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Marketing")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoMarketingPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Academy")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoAcademyPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Development")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoDevelopmentPage(findDepartmentPath);

            } else if (findDepartmentName.equals("HR & Administratie")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoHRAndAdministrationPage(findDepartmentPath);

            } else if (findDepartmentName.equals("Logistiek & Service")) {
                findDepartmentPath = UpdateFindDepartmentName.concat(updatedFindDepartments);
                goIntoWarehousePage(findDepartmentPath);
            }
        }

        return totalUserDetails;

    }

    //Department1
    public List<String> goIntoAcademyPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        AcademyPage academyPage = new AcademyPage(webDriver);
        academyUserRecords = academyPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(academyUserRecords);
        return academyUserRecords;
    }

    //Department2
    public List<String> goIntoDevelopmentPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        DevelopmentPage developmentPage = new DevelopmentPage(webDriver);
        developmentPageUserRecords = developmentPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(developmentPageUserRecords);
        return developmentPageUserRecords;
    }

    //Department3
    public List<String> goIntoHRAndAdministrationPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        HRAndAdministrationPage hrAndAdministrationPage = new HRAndAdministrationPage(webDriver);
        administrationUserRecords = hrAndAdministrationPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(administrationUserRecords);
        return administrationUserRecords;
    }

    //Department4
    public List<String> goIntoManagementPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        ManagementPage managementPage = new ManagementPage(webDriver);
        managementUserRecords = managementPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(managementUserRecords);
        return managementUserRecords;

    }

    //Department5
    public List<String> goIntoMarketingPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        MarketingPage marketingPage = new MarketingPage(webDriver);
        marketingUserRecords = marketingPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(marketingUserRecords);
        return marketingUserRecords;
    }

    //Department6
    public List<String> goIntoProjectsAndSupportPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        ProjectsAndSupportPage projectsAndSupportPage = new ProjectsAndSupportPage(webDriver);
        projectsAndSupportUserRecords = projectsAndSupportPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(projectsAndSupportUserRecords);
        return projectsAndSupportUserRecords;
    }

    //Department7
    public List<String> goIntoSalesPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        SalesPage salesPage = new SalesPage(webDriver);
        salesUserRecords = salesPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(salesUserRecords);
        return salesUserRecords;
    }

    //Department8
    public List<String> goIntoSupportPage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        SupportPage supportPage = new SupportPage(webDriver);
        supportUserRecords = supportPage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(supportUserRecords);
        return supportUserRecords;
    }

    //Department9
    public List<String> goIntoWarehousePage(String btnFindDepartment) throws InterruptedException {
        departmentPath = webDriver.findElement(By.xpath(btnFindDepartment));
        js.executeScript("arguments[0].click();", departmentPath);
        WarehousePage WarehousePage = new WarehousePage(webDriver);
        warehouseUserRecords = WarehousePage.getEmployeeRecords();
        webDriver.navigate().back();
        totalUserDetails.addAll(warehouseUserRecords);
        return warehouseUserRecords;
    }

    public void findDuplicate() throws InterruptedException {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < totalUserDetails.size(); i++) {
            if (set.contains(totalUserDetails.get(i))) {
                System.out.println(totalUserDetails.get(i) + " is duplicated");
            } else set.add(totalUserDetails.get(i));
        }
    }


}

