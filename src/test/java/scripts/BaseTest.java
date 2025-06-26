package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
//import java.util.logging.log4j.LogManager;
//import java.util.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {

    WebDriver driver; // Biến dùng để điều khiển browser
    static Logger logger = LogManager.getLogger(BaseTest.class); // Ghi log
    public WebDriver getDriver() {
        return driver;
    }
@Parameters("browser")// lay tham so tu testng.xml
@BeforeMethod


    public void setupTest(@Optional("chrome") String browser) {
        logger.info("susantest");
    if(browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        }
    logger.info("mo trinh duyet");



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit(); // dong toan bo browser va end session
        //driver.close() -> dong tab hien tai
    }

}
