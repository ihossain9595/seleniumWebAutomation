package com.orangehrmlive.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String region = chromeDriver.findElement(By.className("uU7dJb")).getText();
        // System.out.println(region);
        chromeDriver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(region);
        chromeDriver.findElement(By.cssSelector("[class=gNO89b][type=submit]")).click();

        chromeDriver.close();
        chromeDriver.quit();
    }
}
