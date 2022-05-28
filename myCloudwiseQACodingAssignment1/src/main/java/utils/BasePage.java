package utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BasePage {

  public static final int GLOBAL_TIMEOUT = 15;

  @FindBy(how = How.XPATH, using = "//div[1]/div/h3")
  public List<WebElement> txtName;

  protected List<String> totalUserDetails = new ArrayList<>();
  protected WebDriver webDriver;

  public BasePage() {}

  public BasePage(WebDriver driver) {
    this.webDriver = driver;
    PageFactory.initElements(driver, this);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public List<String> getEmployeeRecords() {
    log.info("Start Step : {}.getEmployeeRecords", this.getClass().getName());
    List<String> txtUserNames =
        txtName.stream().map(WebElement::getText).collect(Collectors.toList());
    log.info("End Step : {}.getEmployeeRecords", this.getClass().getName());
    return txtUserNames;
  }
}
