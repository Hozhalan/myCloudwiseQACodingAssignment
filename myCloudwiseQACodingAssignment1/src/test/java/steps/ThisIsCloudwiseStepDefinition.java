package steps;

import cloudwise.pages.ThisIsCloudwisePage;
import io.cucumber.java.en.And;

public class ThisIsCloudwiseStepDefinition extends BasicStepDefinition {

  @And("go to 'All cloudwisers'")
  public void go_to_all_cloudwisers() throws InterruptedException {
    ThisIsCloudwisePage.getInstance().scrollPageToDiscoverCloudwise().clickPageToAllCloudWisers();
  }
}
