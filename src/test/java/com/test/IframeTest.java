package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        /////////////////////////////////////////////////////////////////////////////////////
        // Navigate To
        chromeDriver.get("https://demoqa.com/frames");
        /////////////////////////////////////////////////////////////////////////////////////


        ///////////////////////////////////////////////////////////////////////////
        // Implicit Wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ///////////////////////////////////////////////////////////////////////////

        // Not working. Have to switch frame before calling
        // String noTextFrame1 = chromeDriver.findElement(By.id("sampleHeading")).getText();
        // System.out.println(noTextFrame1);

        ///////////////////////////////////////////////////////////////////////////
        // iframe
        chromeDriver.switchTo().frame("frame1");
        String textFrame1 = chromeDriver.findElement(By.id("sampleHeading")).getText();
        System.out.println(textFrame1);
        Thread.sleep(2000);
        ///////////////////////////////////////////////////////////////////////////

        chromeDriver.quit();
    }
}
