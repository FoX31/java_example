package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Parameters;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by e.kutsenko on 24.07.2017.
 */
public class TestBase {
  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() {
    //FireFox
     /* DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability(FirefoxDriver.MARIONETTE, false);
      driver = new FirefoxDriver();
      wait = new WebDriverWait(driver, 10);*/
    //IE
      DesiredCapabilities caps = new DesiredCapabilities();
      driver = new InternetExplorerDriver(caps);
    /*//Chrome
      driver = new ChromeDriver();
      System.out.println(((HasCapabilities) driver).getCapabilities());
      wait = new WebDriverWait(driver, 10);*/
  }




  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
