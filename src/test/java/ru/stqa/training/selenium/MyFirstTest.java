package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by e.kutsenko on 19.06.2017.
 */
public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
  public void start() {
      FirefoxOptions options = new FirefoxOptions().setLegacy(true);
      //options.setBinary("C:\\Program Files\\Nightly\\firefox.exe");
      WebDriver driver = new FirefoxDriver(options);
      System.out.println(((HasCapabilities) driver).getCapabilities());
      wait = new WebDriverWait(driver, 10);
    }

    @Test
     public void myFirstTest() {
      driver.get("http://www.google.com");
      driver.findElement(By.name("q")).sendKeys("webdriver");
      driver.findElement(By.name("btnG")).click();
    }

    @After
  public void stop(){
    driver.quit();
    driver = null;
    }
}
