package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        //////////////
        // Navigate To
        chromeDriver.get("https://demo.guru99.com/test/newtours/reservation.php");
        //////////////////////////////////////////////////////////////////////////

        ////////////////
        // Implicit Wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ////////////////////////////////////////////////////////////////////////

        chromeDriver.findElement(By.cssSelector("input[value='oneway']")).click();
        Thread.sleep(3000);

        WebElement passCount = chromeDriver.findElement(By.name("passCount"));
        passCount.isDisplayed();

        WebElement fromPort = chromeDriver.findElement(By.name("fromPort"));
        fromPort.isDisplayed();

        // Elements - Select Lists
        Select selectPassCount = new Select(passCount);
        selectPassCount.selectByIndex(2);
        Thread.sleep(3000);

        Select selectFromPort = new Select(fromPort);
        selectFromPort.selectByValue("Paris");
        Thread.sleep(3000);

        System.out.println("Multiple: " + selectFromPort.isMultiple());

        List<WebElement> optionFromPort = selectFromPort.getOptions();
        for (WebElement op : optionFromPort) {
            System.out.println(op.getText());
        }
        for (WebElement op : optionFromPort) {
            System.out.println(op.getAttribute("value"));
        }
        ///////////////////////////////////////////////////////////////

        // Browser - Windows
        chromeDriver.quit();
        ////////////////////
    }
}
