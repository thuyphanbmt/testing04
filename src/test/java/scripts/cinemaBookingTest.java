package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

import java.time.Duration;

public class cinemaBookingTest {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");

        Actions actions = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login("susantest04", "Abcd1234");

        Thread.sleep(10000);
        //WebElement homeTool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        //actions.scrollToElement(homeTool);

        // hover vao vùng phim
        WebElement filmPlayButton = driver.findElement(By.xpath("(//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')])[1]"));
        actions.moveToElement(filmPlayButton).perform();

        WebElement muave = driver.findElement(By.xpath("xpath nut mua ve"));
        muave.click();


        //cho nut mua ve hien thị roi click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement muaVeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class ='jss424' and contains(.,'MUA VÉ')])[1]")));
        muaVeButton.click();
        System.out.println("Click thành công vào nút MUA VÉ");

//        WebElement bookTicket = driver.findElement(By.xpath("//a[@class =\"jss1511\" and contains(.,'MUA VÉ')]"));
//        bookTicket.click();

        // Chọn Thời gian
        WebElement bookTime = driver.findElement(By.xpath("(//a[contains(@href, '/purchase/')])[1]"));
        bookTime.click();
        Thread.sleep(3000);
        purchasePage.purchaseSlot("12");
        profilePage.verifyBookingPrice("120000");
    }
}
