package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for everyone
    private static WebDriver driver;
    //so noone can create object of class
    //everyone should call static getter method instead
    private Driver (){
    }

//SYNC Enabbles multi-threading works little slower but make sure
    //two different method can access here at the same time
    public synchronized static WebDriver getDriver() {
        if(driver==null){
        String browser = ConfigurationReader.getProperty("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "chromeheadless":
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Wrong browser name!");
        }
    }
    return driver;
    }

    public static void closeDriver()
    {
        if(driver!=null)
        {
            driver.quit();
            driver=null;
        }
    }

}
