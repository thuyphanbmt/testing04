package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
        driver.manage().window().maximize();

        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("homeTool"))).perform();

//        boolean isDisplay = driver.findElement(By.xpath("//div[@class='jss200']")).is();
//        System.out.println(isDisplay);
       String attribute =  driver.findElement(By.xpath("//a[@href='/sign-in']"))
                .getAttribute("justify");
        System.out.println(attribute);
        //Kiểm tra ô nhớ tài khoản đã check chưa?
        //Nếu chưa check -> Click vào
//        WebElement remember = driver.findElement(By.name("remember"));
//        boolean isRemember = remember.isSelected();
//        if (!isRemember){
//            remember.click();
//        }

//        driver.findElement(By.xpath("//input[@id=\"taiKhoan\"]")).sendKeys("huydao226");
//        driver.findElement(By.xpath("//input[@id=\"matKhau\"]")).sendKeys("asdEDZ12#");
//        driver.findElement(By.xpath("//span[text()='Đăng nhập']")).click();
    }
}