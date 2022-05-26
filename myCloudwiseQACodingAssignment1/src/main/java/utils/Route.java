package utils;

import cloudwise.pages.AllCloudwisersPage;
import cloudwise.pages.ThisIsCloudwisePage;
import cloudwise.panels.CWMainMenu;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Route {

    private final String url;
    WebDriver driver;
    List<String> verifyDuplicate;

    public Route(String site) {
        this.url = site;
    }

    public String getUrl() {
        return url;
    }

    public class CloudWise {

        public void getIntoCloudWiseHomePage() throws InterruptedException {
            driver = WebDriverLibrary.getChromeDriver();
            driver.navigate().to(Route.this.getUrl());
        }

        public void goIntoThisIsCloudWise() throws InterruptedException {
            new CWMainMenu(driver)
                    .clickOnThisIsCloudwise();
        }

        public void goIntoAllCloudWisers() throws InterruptedException {
            new ThisIsCloudwisePage(driver)
                    .scrollPageToDiscoverCloudwise()
                    .clickPageToAllCloudWisers();
        }

        public void goIntoAllTheDepartments() throws InterruptedException {
            verifyDuplicate = new AllCloudwisersPage(driver)
                    .scrollPageToAllCloudWisers();
        }

        public void getAllTheUserDetailsAndValidateDuplicate() throws InterruptedException {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < verifyDuplicate.size(); i++) {
                if (set.contains(verifyDuplicate.get(i))) {
                    System.out.println(verifyDuplicate.get(i) + " is duplicated");
                } else set.add(verifyDuplicate.get(i));
            }

        }

        public void deliverooOrderRejectionControl() throws InterruptedException {
            WebDriver driver = WebDriverLibrary.getChromeDriver();
            driver.navigate().to(Route.this.getUrl());
            WebDriverLibrary.quitChromeDriver();
        }

    }
}
