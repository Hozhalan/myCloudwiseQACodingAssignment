package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverLibrary;

import java.time.Duration;

public class BasicStepDefinition {

  public static final int GLOBAL_TIMEOUT = 30;
  WebDriver webDriver;
  WebDriverWait wait;
  String route = "https://gatekeeper.codeshake.dev/test";

  public BasicStepDefinition() {}

  public void openGatekeeperWebpage() {
    webDriver = WebDriverLibrary.getChromeDriver();
    webDriver.navigate().to(route);
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GLOBAL_TIMEOUT));
  }

  public void closeGatekeeperWebpage() {
    webDriver.quit();
  }
}
