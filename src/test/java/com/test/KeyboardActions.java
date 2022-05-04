package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        /////////////////////////////////////////////////////////////////////////////
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        /////////////////////////////////////////////////////////////////////////////


        //////////////////////////////////////////////////////////////////////////////////////////////////
        // Keyboard
        // chromeDriver.findElement(By.cssSelector("[name='q']")).sendKeys("Ismail hossain" + Keys.ENTER);
        //////////////////////////////////////////////////////////////////////////////////////////////////

        try {
        Actions actions = new Actions(chromeDriver);

        /*
        chromeDriver.get("https://mahmoodhossain.com");
        Action selectAll = actions.keyDown(Keys.CONTROL).sendKeys("a").build();
        Thread.sleep(3000);
        selectAll.perform();
        Thread.sleep(3000);
        */

        /*
        chromeDriver.get("https://google.com");
        WebElement search = chromeDriver.findElement(By.name("q"));
        actions.sendKeys(search, "Ismail Hossain").perform();
        Thread.sleep(3000);
        actions.sendKeys(search, Keys.ENTER).perform();
        Thread.sleep(3000);
        */

        chromeDriver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        WebElement sendKeysLink = chromeDriver.findElement(By.cssSelector("input.form-control"));
        actions.sendKeys(sendKeysLink, "sendkeys").perform();
        Thread.sleep(3000);
        sendKeysLink.clear();
        Thread.sleep(3000);
        actions.keyDown(Keys.SHIFT).sendKeys(sendKeysLink,"s").perform();
        actions.keyUp(Keys.SHIFT).sendKeys(sendKeysLink,"endkeys").perform();
        Thread.sleep(3000);

        } finally {
            chromeDriver.quit();
        }
    }
}
