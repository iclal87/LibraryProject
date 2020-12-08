package com.library.Pages;

import com.library.Utilities.BrowserUtils;
import com.library.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksSearchBoxPage {

    public BooksSearchBoxPage (){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[.='Books']")
    private WebElement booksModule;

    @FindBy(xpath = "//input[@class='form-control input-sm input-small input-inline']")
    private WebElement booksSearchBox;

    public void clickOnBooksModule() {

        BrowserUtils.clickOnElement(booksModule);

    }

    public void clickOnBooksSearchBox(){
        BrowserUtils.clickOnElement(booksSearchBox);
    }

    public void putNameInTheSearchBox(String bookName){
       BrowserUtils.enterText(booksSearchBox,bookName);
    }
}
