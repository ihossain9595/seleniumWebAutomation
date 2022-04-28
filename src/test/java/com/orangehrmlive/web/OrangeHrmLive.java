package com.orangehrmlive.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHrmLive {
    // Testing test-branch
    public static void main(String[] args) {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        // System.out.println(chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://google.com");
        chromeDriver.manage().window().maximize();

        ////////////////
        // Implicit Wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ////////////////
        // Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lnXdpd")));

        String region = chromeDriver.findElement(By.className("uU7dJb")).getText();
        // System.out.println(region);
        chromeDriver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(region);

        WebElement submitButton = chromeDriver.findElement(By.cssSelector("[class=gNO89b][type=submit]"));
        // submitButton.click();
        submitButton.sendKeys(Keys.RETURN);

        chromeDriver.close();
        chromeDriver.quit();
    }
}
