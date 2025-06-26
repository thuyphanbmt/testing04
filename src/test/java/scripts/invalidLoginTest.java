package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomPage;
import pages.LoginPage;

import java.time.Duration;

public class invalidLoginTest {

    public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://demo1.cybersoft.edu.vn/");

            HomPage homPage = new HomPage(driver);

            LoginPage loginPage = new LoginPage(driver);

            homPage.clickSignInButton();
            //Nhập username
            //click login button
            loginPage.login("susantest04","");

            loginPage.inputUsername("susantest04");
            loginPage.inputPassword("sajdhaksjhd");

            //Verify if there is error message displays
            loginPage.verifyErrorMessageIsDisplay();
    }
}
