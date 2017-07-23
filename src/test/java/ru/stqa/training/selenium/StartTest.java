package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


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

    public void loginAdmin(){
        driver.navigate().to("http://localhost:8080/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public void openMainPage(){
        driver.navigate().to("http://localhost:8080/litecart/en/");
    }

    @Test
    public void test9_1() throws InterruptedException {
        loginAdmin();
        driver.findElement(By.xpath("//span[.='Countries']")).click();
        List<WebElement> lines = driver.findElements(By.xpath("//tr[@class='row']"));
        List<String> names = new ArrayList();
        for(int i = 0; i < lines.size(); i++){
            names.add(lines.get(i).findElement(By.xpath(".//td[5]/a")).getText());
        }
        List<String> namesSorted = new ArrayList<String>(names);
        java.util.Collections.sort(namesSorted);
        Assert.assertEquals(namesSorted, names);
        List<String> zones = new ArrayList<String>();
        for (int i = 0; i < lines.size(); i++){
            if(Integer.parseInt(lines.get(i).findElement(By.xpath(".//td[6]")).getText()) != 0){
                zones.add(lines.get(i).findElement(By.xpath(".//td[3]")).getText());
            }
        }
        for (int i = 0; i < zones.size(); i++){
            driver.findElement(By.xpath("//tr[@class='row']/td[3][.='"+zones.get(i) +"']")).findElement(By.xpath("..//td[5]/a")).click();
            List<WebElement> linesZones = driver.findElements(By.xpath("//table[@id='table-zones']//tr"));
            List<String> namesZones = new ArrayList<String>();
            for (int a = 1; a < linesZones.size() - 1; a++){
                namesZones.add(linesZones.get(a).findElement(By.xpath(".//td[3]")).getText());
            }
            List<String> namesZoneaSorted = new ArrayList<String>(namesZones);
            java.util.Collections.sort(namesZoneaSorted);
            Assert.assertEquals(namesZoneaSorted, namesZones);
            driver.findElement(By.xpath("//span[.='Countries']")).click();
        }
    }

    @Test
    public  void test9_2() throws InterruptedException {
        loginAdmin();
        driver.findElement(By.xpath("//span[.='Geo Zones']")).click();
        int cuntriesCount = driver.findElements(By.xpath("//tr[@class='row']")).size();
        for(int i = 1; i <= cuntriesCount; i++) {
            WebElement lines = driver.findElement(By.xpath("//tr[@class='row'][" + i + "]"));
            lines.findElement(By.xpath(".//td[5]/a")).click();
            List<WebElement> lineZones = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
            List<String> names = new ArrayList<String>();
            for (int a = 1; a < lineZones.size() - 1; a++) {
                names.add(lineZones.get(a).findElement(By.xpath("./td[3]//option [@selected='selected']")).getText());
            }
            List<String> namesSorted = new ArrayList<String>(names);
            java.util.Collections.sort(namesSorted);
            Assert.assertEquals(namesSorted, names);
            driver.findElement(By.xpath("//span[.='Geo Zones']")).click();
        }
    }

    @Test
    public void test8() throws InterruptedException {
        openMainPage();
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        for (int i = 0; i < list.size(); i++){
            List<WebElement> stikers = list.get(i).findElements(By.xpath(".//div[@class='sticker new' or @class='sticker sale']"));
            Assert.assertEquals(stikers.size(), 1);
        }
    }

    @Test
    public void test7(){
        loginAdmin();
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

    @After
    public void stop(){
    driver.quit();
    driver = null;
    }
}
