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
import java.util.List;

public class OrangeHrmLive {
    // Testing test-branch
    public static void main(String[] args) {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        // System.out.println(chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        //////////////
        // Navigate To
        chromeDriver.navigate().to("https://mahmoodhossain.com");
        chromeDriver.get("https://google.com");
        ////////////////////////////

        ////////////////
        // Implicit Wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ////////////////////////////////

        ////////////////
        // Explicit Wait
        // WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
        // explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lnXdpd")));
        ////////////////////////////////

        /////////////
        // Navigation
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();
        //////////////////////////

        String region = chromeDriver.findElement(By.className("uU7dJb")).getText();
        // System.out.println(region);

        ///////////////
        // Interactions
        By inputField = By.cssSelector("input.gLFyf.gsfi");
        chromeDriver.findElement(inputField).clear();
        chromeDriver.findElement(inputField).sendKeys(region);
        //////////////////////////////

        WebElement submitButton = chromeDriver.findElement(By.cssSelector("[class=gNO89b][type=submit]"));
        // submitButton.click();
        submitButton.sendKeys(Keys.RETURN);

        //////////
        // Finders
        List<WebElement> aElements = chromeDriver.findElements(By.tagName("a"));
        System.out.println("Element size: " + aElements.size());
        if (aElements.size() != 0) {
            for (WebElement a : aElements) {
                if (a.getAttribute("href") != null) {
                    System.out.println(a.getAttribute("href"));
                }
            }
        }
        ////////////////////

        //////////////
        // Information
        boolean isImageAvailable = chromeDriver.findElement(By.cssSelector("div.logo [alt='Google']")).isDisplayed();
        System.out.println(isImageAvailable);

        String imageHeight = chromeDriver.findElement(By.cssSelector("div.logo [alt='Google']")).getCssValue("height");
        System.out.println(imageHeight);
        ////////////////////////////

        chromeDriver.close();
        chromeDriver.quit();
    }
}
