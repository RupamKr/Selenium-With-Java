package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class FlipkartSteps {

    WebDriver driver = BaseClass.getDriver();

    @Given("{string} open Flipkart application")
    public void actorOpenFlipkartApplication(String actor) {
        driver.get("https://www.flipkart.com/");
        BaseClass.waitUntilThePageLoad();
    }


    @Then("he validate the {title} page of Flipkart")
    public void heValidateTheTitlePageOfFlipkart(String title) {
        String actualTileOfPage = driver.getTitle();
        Assert.assertEquals(actualTileOfPage, title);
    }

    @And("he find out the broken link")
    public void heFindOutTheBrokenLink() {

    }

    @And("he quit the browser")
    public void heQuitTheBrowser() {
        driver.quit();
    }

}
