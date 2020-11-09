package com.library.Pages;

import com.library.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LibraryUserModulePage {

    public LibraryUserModulePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement password;

    @FindBy(xpath = "(//span[@class='title'])[2]")
    public WebElement usersModule;

    @FindBy(xpath = "//h3[.='User Management']")
    public WebElement usersManagementText;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUserButton;


    @FindBy(xpath = "(//input)[2]")
    public WebElement fullName;


    @FindBy(xpath = "(//input)[3]")
    public WebElement passwordOfUser;


    @FindBy(xpath = "(//input)[4]")
    public WebElement email;


    @FindBy(xpath = "(//input)[5]")
    public WebElement startDate;


    @FindBy(xpath = "(//input)[6]")
    public WebElement endDate;


    @FindBy(xpath = "//textarea[@id='address']")
    public WebElement address;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//i[@class='fa fa-angle-right']")
    public WebElement forwardButton;





}
