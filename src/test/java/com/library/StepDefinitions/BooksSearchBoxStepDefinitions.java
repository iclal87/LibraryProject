package com.library.StepDefinitions;

import com.library.Pages.BooksSearchBoxPage;
import com.library.Utilities.BrowserUtils;
import com.library.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BooksSearchBoxStepDefinitions {

    BooksSearchBoxPage searchBox= new BooksSearchBoxPage();

    @Given("user is on the given url page")
    public void userIsOnTheGivenUrlPage() {
        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");
    }

    @When("user clicks books module")
    public void user_clicks_books_module() {
        searchBox.clickOnBooksModule();
    }




    @When("user clicks on search box")
    public void user_clicks_on_search_box() {
       searchBox.clickOnBooksSearchBox();
    }
    @When("user puts {string} in the box")
    public void user_puts_in_the_box(String string) {
        searchBox.putNameInTheSearchBox(string);
    }
    @Then("user should see the given {string} in the table")
    public void user_should_see_the_given_in_the_table(String string) {
        BrowserUtils.wait(2);
        String expectedBookName=string;
        String  actualBookName= Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
        Assert.assertEquals("not matched",actualBookName,expectedBookName);


    }


}
