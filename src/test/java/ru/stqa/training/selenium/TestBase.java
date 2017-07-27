package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

/**
 * Created by e.kutsenko on 24.07.2017.
 */
public class TestBase {

  public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
  public EventFiringWebDriver driver;
  public WebDriverWait wait;

  public static class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by +  " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }
  }

  @Before
  public void start() {
    if (tlDriver.get() != null){
      driver = tlDriver.get();
      wait = new WebDriverWait(driver, 10);
    }
    //FireFox
      /*DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability(FirefoxDriver.MARIONETTE, false);
      driver = new FirefoxDriver();
      wait = new WebDriverWait(driver, 10);*/
    //IE
      /*DesiredCapabilities caps = new DesiredCapabilities();
      driver = new InternetExplorerDriver(caps);*/
    //Chrome
      DesiredCapabilities cap = DesiredCapabilities.chrome();
      LoggingPreferences logPrefs = new LoggingPreferences();
      logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
      cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
      driver = new EventFiringWebDriver(new ChromeDriver(cap));
      driver.register(new MyListener());
      tlDriver.set(driver);
      wait = new WebDriverWait(driver, 10);
  }




  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
