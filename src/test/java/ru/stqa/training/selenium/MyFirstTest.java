package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

      driver = new ChromeDriver();
      System.out.println(((HasCapabilities) driver).getCapabilities());
      wait = new WebDriverWait(driver, 10);
    }

    @Test
     public void myFirstTest() throws InterruptedException {
      driver.navigate().to("http://localhost:8080/litecart");
      driver.findElement(By.xpath("(//div[. ='New'])[1]"));
      driver.findElement(By.xpath("(//div[. ='New'])[2]"));
      driver.findElement(By.xpath("(//div[. ='New'])[3]"));
      driver.findElement(By.xpath("(//div[. ='New'])[4]"));
      driver.findElement(By.xpath("(//div[. ='New'])[5]"));
      driver.findElement(By.xpath("(//div[. ='New'])[6]"));
      driver.findElement(By.xpath("(//div[. ='New'])[7]"));
      driver.findElement(By.xpath("(//div[. ='New'])[8]"));
      driver.findElement(By.xpath("(//div[. ='Sale'])[1]"));
      driver.findElement(By.xpath("(//div[. ='Sale'])[2]"));
      driver.findElement(By.xpath("(//div[. ='Sale'])[3]"));
    }

    @After
  public void stop(){
    driver.quit();
    driver = null;
    }
}
