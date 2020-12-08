package com.library.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


    /**
     Accepts a list of Web Element
     @param list
     @return List<String>
     Method should be returning a list of Strings
     */
    public static List<String> getElementsText(List<WebElement> list){

        List<String> webelementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webelementsAsString.add(each.getText());
        }
        return webelementsAsString;

    }

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);



    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /*
    Create a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that I pass as parameter should be accepted as SECONDS
    Handle checked exception with try/catch
     */

    public static void wait(int sec){

        try{
            Thread.sleep(1000*sec);
        }catch(InterruptedException e){
            e.printStackTrace();
        }


    }
    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: " + text);
    }


}


