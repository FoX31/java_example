package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


/**
 * Created by e.kutsenko on 19.06.2017.
 */
public class StartTest {

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
        menu(true);
    }
    public void menu(Boolean click){
        if (click){
            int b = driver.findElements(By.xpath("//li[@id ='app-']")).size();
            for (int i=0; i<b; i++){
                List<WebElement> list = driver.findElements(By.xpath("//li[@id ='app-']"));
                list.get(i).click();
                int o = driver.findElements(By.xpath("//ul[@class='docs']//span[@class ='name']")).size();
                for (int a=1; a<o; a++){
                    List<WebElement> list1 = driver.findElements(By.xpath("//ul[@class='docs']//span[@class ='name']"));
                    list1.get(a).click();
                }
            }
        }
    }

    @After
    public void stop(){
    driver.quit();
    driver = null;
    }
}
