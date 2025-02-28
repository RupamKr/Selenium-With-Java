package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.io.IOException;
import java.util.List;

public class FlipkartSteps {

    WebDriver driver = BaseClass.getDriver();

    @Given("{string} open Flipkart application")
    public void actorOpenFlipkartApplication(String actor) {
        driver.get("https://www.flipkart.com/");
        BaseClass.waitUntilThePageLoad();
    }


    @Then("he validate the {string} page of Flipkart")
    public void heValidateTheTitlePageOfFlipkart(String title) {
        String actualTileOfPage = driver.getTitle();
        Assert.assertEquals(actualTileOfPage, title);
    }

    @And("he find out the broken link")
    public void heFindOutTheBrokenLink() throws IOException {
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement link : list) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                boolean isBroken = BaseClass.isBrokenLink(url);
                if (isBroken) {
                    System.out.println(url + "->" + "is not broken url");
                } else {
                    System.out.println(url + "->" + "is broken");
                }
            }
        }
    }

    @And("he quit the browser")
    public void heQuitTheBrowser() {
        driver.quit();
    }

}
