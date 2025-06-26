package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyBookingPrice(String price) {
        //Chọn avatar góc phải để xem danh sách vé đã chọn
        WebElement clickAvatar = driver.findElement(By.xpath("//a[@href='/account']"));
        clickAvatar.click();

        String lastPurchasedPrice = driver.findElement(By.xpath("(//h3[contains(text(), 'Giá vé:')])[last()]")).getText();
        if(lastPurchasedPrice.equals(price+" VND")) {
            //== equals
            System.out.println("PASSED!!!");
        } else {
            System.out.println("FAILED!!!");
        }
    }
}
