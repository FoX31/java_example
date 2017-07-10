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
      driver = new ChromeDriver();
      System.out.println(((HasCapabilities) driver).getCapabilities());
      wait = new WebDriverWait(driver, 10);
    }

    @Test
     public void myFirstTest() throws InterruptedException {
      driver.navigate().to("http://localhost:8080/litecart/admin/");
      driver.findElement(By.name("username")).sendKeys("admin");
      driver.findElement(By.name("password")).sendKeys("admin");
      driver.findElement(By.name("login")).click();
      driver.findElement(By.xpath("//span[. = 'Appearence']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Template']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Logotype']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("(//span[. = 'Catalog'])[1]")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Product Groups']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Option Groups']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Manufacturers']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Suppliers']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Delivery Statuses']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Sold Out Statuses']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Quantity Units']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'CSV Import/Export']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Countries']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Currencies']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("(//span[. = 'Customers'])[1]")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'CSV Import/Export']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Newsletter']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Geo Zones']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("(//span[. = 'Languages'])[1]")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Storage Encoding']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("(//span[. = 'Modules'])[1]")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Customer']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Shipping']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Payment']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Order Total']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Order Success']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Order Action']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("(//span[. = 'Orders'])[1]")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Order Statuses']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Pages']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Reports']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Most Sold Products']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Most Shopping Customers']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Settings']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Defaults']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'General']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Listings']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Images']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Checkout']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Advanced']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Security']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Slides']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Tax']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Tax Rates']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Translations']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Scan Files']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'CSV Import/Export']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'Users']")).click();
      driver.findElement(By.xpath("//h1"));
      driver.findElement(By.xpath("//span[. = 'vQmods']")).click();
      driver.findElement(By.xpath("//h1"));
    }

    @After
  public void stop(){
    driver.quit();
    driver = null;
    }
}
