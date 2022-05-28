package steps;

import cloudwise.pages.AllCloudwisersPage;
import io.cucumber.java.en.And;

import java.util.HashSet;
import java.util.Set;

public class AllCloudwisersStepDefinition extends BasicStepDefinition {

  @And("go into all the departments")
  public void go_into_all_the_departments() throws InterruptedException {
    verifyDuplicate = AllCloudwisersPage.getInstance().scrollPageToAllCloudWisers();
  }

  @And("get all the user details")
  public void get_all_the_user_details() throws InterruptedException {
    getAllTheUserDetailsAndValidateDuplicate();
  }

  public void getAllTheUserDetailsAndValidateDuplicate() throws InterruptedException {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < verifyDuplicate.size(); i++) {
      if (set.contains(verifyDuplicate.get(i))) {
        System.out.println(verifyDuplicate.get(i) + " is duplicated");
      } else set.add(verifyDuplicate.get(i));
    }
  }
}
