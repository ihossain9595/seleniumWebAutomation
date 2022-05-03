package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        /////////////////////////////////////////////////////////////////////////////////////
        // Navigate To
        chromeDriver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
        /////////////////////////////////////////////////////////////////////////////////////


        ///////////////////////////////////////////////////////////////////////////
        // Implicit Wait
        // chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ///////////////////////////////////////////////////////////////////////////


        /////////////////////////////////////////////////////////////////////////////
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        /////////////////////////////////////////////////////////////////////////////


        // JavaScript Alerts /////////////////////////////////////////////////////////
        /*
        chromeDriver.findElement(By.linkText("See an example alert")).click();
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent()); // GOOD to use
        Thread.sleep(3000);
        alert1.accept();
        Thread.sleep(3000);
        */
        //////////////////////////////////////////////////////////////////////////////


        // Confirmations /////////////////////////////////////////////////////
        /*
        chromeDriver.findElement(By.linkText("See a sample confirm")).click();
        Alert alert2 = chromeDriver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Alert: " + alert2.getText());
        alert2.dismiss();
        Thread.sleep(3000);
        */
        //////////////////////////////////////////////////////////////////////


        // Prompt ///////////////////////////////////////////////////////////
        chromeDriver.findElement(By.linkText("See a sample prompt")).click();
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Message: " + alert3.getText());
        Thread.sleep(3000);
        alert3.sendKeys("Not working");
        Thread.sleep(3000);
        alert3.accept();
        Thread.sleep(3000);
        /////////////////////////////////////////////////////////////////////

        chromeDriver.quit();
    }
}
