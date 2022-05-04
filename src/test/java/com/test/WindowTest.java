package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        //////////////////////////////////////////////
        // Navigate To
        chromeDriver.get("https://demoqa.com/frames");
        //////////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        ////////////////////////////////////////////////////////////////////////////


        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Window and Tab
        String originalWindow = chromeDriver.getWindowHandle();

        // Tab
        chromeDriver.switchTo().newWindow(WindowType.TAB);

        wait.until(numberOfWindowsToBe(2));

        chromeDriver.navigate().to("https://google.com");
        chromeDriver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Get married already!");
        chromeDriver.findElement(By.cssSelector("input.gLFyf.gsfi")).clear();
        chromeDriver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Just kidding!");
        chromeDriver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);

        chromeDriver.close();
        chromeDriver.switchTo().window(originalWindow);

        System.out.println("Title: " + chromeDriver.findElement(By.className("main-header")).getText());

        // chromeDriver.switchTo().newWindow(WindowType.WINDOW);
        // Thread.sleep(2000);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        chromeDriver.quit();
    }
}
