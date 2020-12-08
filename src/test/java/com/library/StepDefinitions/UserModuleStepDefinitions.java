package com.library.StepDefinitions;

import com.library.Pages.LibraryUserModulePage;
import com.library.Utilities.BrowserUtils;
import com.library.Utilities.ConfigurationReader;
import com.library.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserModuleStepDefinitions {

    WebDriver driver = Driver.getDriver();
    LibraryUserModulePage library = new LibraryUserModulePage();
    //AC-1 ***********************************************************************************************************
    @Given("user is on the given url")
    public void user_is_on_the_given_url() {
        Driver.getDriver().get("http://library2.cybertekschool.com/login.html");
    }

    @When("user enters user name")
    public void user_enters_user_name() {
        library.userName.sendKeys(ConfigurationReader.getProperty("libraryUserName"));
    }

    @When("user enters password and clicks the enter button")
    public void user_enters_password_and_clicks_the_enter_button() {
        library.password.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
        BrowserUtils.wait(2);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        String expectedTitle = "Library";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("not matched", expectedTitle, actualTitle);
        System.out.println(actualTitle);
    }

    //AC2 ***********************************************************************************************************
    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        String expectedTitle = "Library";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("not matched", expectedTitle, actualTitle);
    }

    @When("user clicks users module")
    public void user_clicks_users_module() {
        library.usersModule.click();
    }

    @Then("user should see user management page")
    public void user_should_see_user_management_page() {

        String actual = library.usersManagementText.getText();
        String expected = "User Management";
        Assert.assertEquals("User not on the user management page", actual, expected);
    }

//AC3 ******************************************************************************************************************88
    @And("user clicks to add user button")
    public void userClicksToAddUserButton() {
        library.addUserButton.click();
    }

    @And("user fills out fullname {string}")
    public void userFillsOutFullname(String arg0)  {

       BrowserUtils.wait(2);
        library.fullName.sendKeys(arg0);
    }

    @And("User fills out password {string}")
    public void userFillsOutPassword(String arg0) {


        library.passwordOfUser.sendKeys(arg0);
    }

    @And("user fills out email {string}")
    public void userFillsOutEmail(String arg0) {
        library.email.sendKeys(arg0);
    }

    @And("user choose userGroup")
    public void userChooseUserGroup() {

        Select userGroup = new Select(driver.findElement(By.xpath("//select[@id='user_group_id']")));

        userGroup.getFirstSelectedOption();
    }

    @And("user chooses status")
    public void userChoosesStatus() {
        Select status = new Select(driver.findElement(By.xpath("//select[@id='status']")));

        status.getFirstSelectedOption();

    }


    @And("User enters startDate {string}")
    public void userEntersStartDate(String arg0) {
        library.startDate.sendKeys(arg0);
    }

    @And("User enters endDate {string}")
    public void userEntersEndDate(String arg0) {
        library.endDate.sendKeys(arg0);
    }

    @And("User enters address {string}")
    public void userEntersAddress(String arg0) {
        library.address.sendKeys(arg0);

    }

    @And("user clicks save changes button")
    public void userClicksSaveChangesButton() {
         BrowserUtils.wait(2);
        library.saveButton.click();

    }
    @Then("user should see {string} user")
    public void userShouldSeeUser(String arg0) {
        BrowserUtils.wait(4);
        String actual = Driver.getDriver().findElement(By.xpath("//tr[1]//td[3]")).getText();

        String expected = arg0;
        Assert.assertEquals("not matched", actual, expected);

    }



//AC-6 *******************************************************************************************************************************
    @And("user clicks user group dropdown")
    public void userClicksUserGroupDropdown() {

        Select userGroupDropDown = new Select(driver.findElement(By.xpath("//select[@id='user_groups']")));

        userGroupDropDown.selectByValue("3");

    }


    @Then("user should see {string} option on the table")
    public void userShouldSeeOptionOnTheTable(String arg0) throws InterruptedException {

        Thread.sleep(2000);
        String actual = Driver.getDriver().findElement(By.xpath("//tr//td[5]")).getText();
        String expected = "Students";
        Assert.assertEquals("not matched", actual, expected);
    }


    @When("user clicks forward button")
    public void userClicksForwardButton() {

        library.forwardButton.click();
    }

    @Then("user should see selected option")
    public void userShouldSeeSelectedOption() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-right']")).click();
        Thread.sleep(2000);
       int lastPage=Integer.parseInt(Driver.getDriver().findElement(By.xpath("//li[@class='page-item active']")).getText());
        System.out.println("lastPage = " + lastPage);
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        String actual = Driver.getDriver().findElement(By.xpath("//tr//td[5]")).getText();
        String expected = "Students";
        Assert.assertEquals("not matched", actual, expected);

        //locating all the names from all the rows and storing in a list of web element
        List<WebElement> groupNameList = driver.findElements(By.xpath("//tr//td[5]"));
        System.out.println("groupNameList = " + groupNameList.size());




        for (int i = 0; i <lastPage-1; i++) {

            for (int j = 1; j < groupNameList.size() ; j++) {
                Driver.getDriver().findElement(By.xpath("(//tr//td[5])["+j+"]"));
                String actualTitle= Driver.getDriver().findElement(By.xpath("(//tr//td[5])["+j+"]")).getText();
                String expectedTitle = "Students";
                Assert.assertEquals("not matched", actualTitle, expectedTitle);

            }
            library.forwardButton.click();
            Thread.sleep(2000);
            String actualTitle = Driver.getDriver().findElement(By.xpath("//tr//td[5]")).getText();
            String expectedTitle = "Students";
            Assert.assertEquals("not matched", actualTitle, expectedTitle);

        }
    }

   // @AC-5****************************************************************************************************************
    @And("user clicks search box")
    public void userClicksSearchBox() {
     library.searchButton.click();
    }


    @And("user puts {string} in the search box")
    public void userPutsInTheSearchBox(String arg0) throws InterruptedException {
      library.searchButton.sendKeys(arg0);
      Thread.sleep(2000);

    }

    @Then("user see given {string} in the table")
    public void userSeeGivenInTheTable(String arg0) {

        String givenId=arg0;
        String actualId=Driver.getDriver().findElement(By.xpath("//tr//td[2]")).getText();
        Assert.assertEquals("not matched", givenId,actualId);
    }
    //AC-5SC2***********************************************************************************************************************

    @And("user hits search box")
    public void userHitsSearchBox() {
        library.searchButton.click();
    }


    @And("user enters {string} in the search box")
    public void userEntersInTheSearchBox(String arg0) throws InterruptedException {
        library.searchButton.sendKeys(arg0);
        Thread.sleep(2000);

    }

    @Then("user should see given {string} in the table")
    public void userShouldSeeGivenInTheTable(String arg0) {

        String givenName=arg0;
        String actualName=Driver.getDriver().findElement(By.xpath("//tr//td[3]")).getText();
        Assert.assertEquals("not matched", givenName,actualName);
    }


    @Then("user is clicking search box")
    public void userIsClickingSearchBox() {
    }

    @Then("user is entering {string} in the search box")
    public void userIsEnteringInTheSearchBox(String arg0) {
    }

    @Then("user should be able to see given {string} in the table")
    public void userShouldBeAbleToSeeGivenInTheTable(String arg0) {
    }

//AC-7****************************************************************************************************
    @And("user clicks status dropdown")
    public void userClicksStatusDropdown() {

        Select userStatusDropDown = new Select(driver.findElement(By.xpath("//select[@id='user_status']")));

        userStatusDropDown.selectByValue("INACTIVE");

    }

    @And("user selects {string} from status dropdown")
    public void userSelectsFromStatusDropdown(String arg0) {
    }

    @When("user hits forward button")
    public void userHitsForwardButton() {
    }

    @Then("user should be able to see selected option on the table")
    public void userShouldBeAbleToSeeSelectedOptionOnTheTable() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-right']")).click();
        Thread.sleep(2000);
        int lastPage=Integer.parseInt(Driver.getDriver().findElement(By.xpath("//li[@class='page-item active']")).getText());
        System.out.println("lastPage = " + lastPage);
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        String actual = Driver.getDriver().findElement(By.xpath("//tr//td[5]")).getText();
        String expected = "Librarian";
        Assert.assertEquals("not matched", actual, expected);

        //locating all the names from all the rows and storing in a list of web element
        List<WebElement> groupNameList = driver.findElements(By.xpath("//tr//td[5]"));
        System.out.println("groupNameList = " + groupNameList.size());




        for (int i = 0; i <lastPage-1; i++) {

            for (int j = 1; j < groupNameList.size() ; j++) {
                Driver.getDriver().findElement(By.xpath("(//tr//td[5])["+j+"]"));
                String actualTitle= Driver.getDriver().findElement(By.xpath("(//tr//td[5])["+j+"]")).getText();
                String expectedTitle = "Librarian";
                Assert.assertEquals("not matched", actualTitle, expectedTitle);

            }
            library.forwardButton.click();
            Thread.sleep(2000);
            String actualTitle = Driver.getDriver().findElement(By.xpath("//tr//td[5]")).getText();
            String expectedTitle = "Librarian";
            Assert.assertEquals("not matched", actualTitle, expectedTitle);

        }
    }


}
