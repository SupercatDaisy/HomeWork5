package com.vytrack.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage extends PageBase {


    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(id = "remember_me")
    private WebElement rememberMe;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement warningMessage;



  public LoginPage()

  {//what is the page class ? this
      PageFactory.initElements(Driver.getDriver(),this);
  }

  public String getWarningMessage()
  {
      return warningMessage.getText();
  }


  //Login Method #1
    //login as specific user
  public void login (String username,String password, boolean ifRemember) {
      this.username.sendKeys(username);
      this.password.sendKeys(password);
      if (ifRemember) {
          rememberMe.click();
      }
      login.click();
  }

  //Loging Method #2 using properties file.
    //login as default user stated in properties file
  public void login()
  {
      username.sendKeys(ConfigurationReader.getProperty("store_manager"));
      password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
      BrowserUtils.waitForPageToLoad(10);
  }


  }


