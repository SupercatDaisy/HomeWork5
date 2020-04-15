package com.vytrack.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.Wait;

/**
 * This class will be extended by page classes. Common Webelements will be stored here.
 * Since navigation menu is same for all the pages.
 */

public abstract class PageBase {
  protected   WebDriver driver = Driver.getDriver();
  protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

//put here because this is same for all the users
    @FindBy(css = "#user-menu > a")
    protected WebElement CurrentUser;

    public String getCurrentUserName()
    {
        wait.until(ExpectedConditions.visibilityOf(CurrentUser));
        return CurrentUser.getText().trim();
    }






   public PageBase()
   {
       PageFactory.initElements(Driver.getDriver(),this);
   }


   public void navigateTo(String tabName,String moduleName)
   {
    String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
    String moduleXpath = "//span[@class='title title-level-2' and text() = '"+moduleName+"']";
       WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabNameXpath));
       WebElement moduleElement=Driver.getDriver().findElement(By.xpath(moduleXpath));
       Actions actions = new Actions(Driver.getDriver());
       Wait.wait(2);
       actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();
       Wait.wait(2);


   }



}
