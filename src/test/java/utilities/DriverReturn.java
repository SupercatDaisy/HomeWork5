package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverReturn {

    public static WebDriver driverReturn (String browsername)

    {
        if(browsername.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();}
        else{
            WebDriverManager.chromedriver().setup();
        return new FirefoxDriver();}

    }
}


/*

 String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows") && type.equalsIgnoreCase("safari"))
            return null;
        else if (os.contains("mac") && type.equalsIgnoreCase("edge"))
            return null;
         else if (type.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (type.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (type.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }


















 */