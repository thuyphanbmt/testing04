package scripts;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

import java.time.Duration;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Listeners(SimpleListener.class)
public class cinemaBookingFromHomeToolTest extends BaseTest {




    @Test
    public void verifyBooking(){


        LoginPage loginPage = new LoginPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        Actions actions = new Actions(driver);



        loginPage.login("susantest04", "Abcd1234");
        WebElement filmPlayButton = driver.findElement(By.xpath("(//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')])[1]"));
        actions.moveToElement(filmPlayButton).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement muaVeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class ='jss424' and contains(.,'MUA VÉ')])[1]")));
        muaVeButton.click();
        System.out.println("Click thành công vào nút MUA VÉ");

//        WebElement bookTicket = driver.findElement(By.xpath("//a[@class =\"jss1511\" and contains(.,'MUA VÉ')]"));
//        bookTicket.click();

        // Chọn Thời gian
        WebElement bookTime = driver.findElement(By.xpath("(//a[contains(@href, '/purchase/')])[1]"));
        bookTime.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        purchasePage.purchaseSlot("12");
    }

    @Test
    public void verifyLoginWithInvalidPassword() {


        HomPage homPage = new HomPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homPage.clickSignInButton();

        //Nhập username
        //click login button
        loginPage.login("susantest04","1233");

//        loginPage.inputUsername("susantest04");
//        loginPage.inputPassword("sajdhaksjhd");

        //Verify if there is error message displays
        loginPage.verifyErrorMessageIsDisplay();

    }

}