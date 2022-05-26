package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.Route;

public class StepDefinition {

    Route route = new Route("https://cloudwise.nl/");

    public StepDefinition() throws InterruptedException {
    }

    @Given("open cloudwise webpage")
    public void open_cloudwise_webpage() throws InterruptedException {
        route.new CloudWise()
                .getIntoCloudWiseHomePage();
    }

    @And("go to 'This is cloudwise'")
    public void go_to_this_is_cloudwise() throws InterruptedException {
        route.new CloudWise()
                .goIntoThisIsCloudWise();
    }

    @And("go to 'All cloudwisers'")
    public void go_to_all_cloudwisers() throws InterruptedException {
        route.new CloudWise()
                .goIntoAllCloudWisers();
    }

    @And("go into all the departments")
    public void go_into_all_the_departments() throws InterruptedException {
        route.new CloudWise()
                .goIntoAllTheDepartments();
    }

    @And("get all the user details")
    public void get_all_the_user_details() throws InterruptedException {
        route.new CloudWise()
                .getAllTheUserDetailsAndValidateDuplicate();
    }


}
