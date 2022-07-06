package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HelloWorldStepDefs {

    private int alexApplesCount;
    private int jekaterinaApplesCount;
    private int applesCount;



    @Given("Alex has {int} apples")
    public void set_apples_for_alex(int count) {
        alexApplesCount = count;
    }

    @Given("Jekaterina has {int} apples")
    public void set_apples_for_jekaterina(int count) {
        jekaterinaApplesCount = count;

    }

    @When("they are putting all apples together")
    public void put_apples_together() {
        applesCount = alexApplesCount + jekaterinaApplesCount;
    }

    @Then("they have {int} apples")
    public void check_apples_count(int count) {
        Assertions.assertEquals(count, applesCount, "Wrong total count");

    }
}
