package ru.stqa.training.selenium;

import org.apache.bcel.ExceptionConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by e.kutsenko on 19.06.2017.
 */
public class StartTest extends TestBase{


    public ExpectedCondition<String> anyWindowOtherThan(Set<String>oldWindows){
      return new ExpectedCondition<String>(){
        public String apply(WebDriver driver){
          Set<String> handles = driver.getWindowHandles();
          handles.removeAll(oldWindows);
          return handles.size() > 0 ? handles.iterator().next(): null;
        }
      };
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
  public void myFirstTest() throws InterruptedException {
    loginAdmin();
    int b = driver.findElements(By.xpath("//li[@id ='app-']")).size();
    for (int i=0; i<b; i++){
      List<WebElement> list = driver.findElements(By.xpath("//li[@id ='app-']"));
      list.get(i).click();
      int o = driver.findElements(By.xpath("//ul[@class='docs']//span[@class ='name']")).size();
      for (int a=1; a<o; a++){
        List<WebElement> list1 = driver.findElements(By.xpath("//ul[@class='docs']//span[@class ='name']"));
        list1.get(a).click();
        driver.findElement(By.xpath("//h1"));
      }
    }
  }


    @Test
    public void test14() throws InterruptedException{
      loginAdmin();
      driver.findElement(By.xpath("//span[.='Countries']")).click();
      driver.findElement(By.xpath("//a[.=' Add New Country']")).click();
      String winHandleBefore = driver.getWindowHandle();
      driver.findElement(By.xpath("(//a[@target='_blank'])[5]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);

      driver.findElement(By.xpath("(//a[@target='_blank'])[6]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);

      driver.findElement(By.xpath("(//a[@target='_blank'])[7]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);

      driver.findElement(By.xpath("(//a[@target='_blank'])[8]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);

      driver.findElement(By.xpath("(//a[@target='_blank'])[9]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);

      driver.findElement(By.xpath("(//a[@target='_blank'])[10]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);

      driver.findElement(By.xpath("(//a[@target='_blank'])[11]")).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
      }
      driver.close();
      driver.switchTo().window(winHandleBefore);
    }

    @Test
    public void test13() throws InterruptedException{
        openMainPage();
        driver.findElement(By.xpath("(//li[@class='product column shadow hover-light'])[1]")).click();
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart']//span[.='1']")));
        driver.findElement(By.xpath("//li[@class='general-0']")).click();

        driver.findElement(By.xpath("(//li[@class='product column shadow hover-light'])[1]")).click();
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
        WebElement cart2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart']//span[.='2']")));
        driver.findElement(By.xpath("//li[@class='general-0']")).click();

        driver.findElement(By.xpath("(//li[@class='product column shadow hover-light'])[1]")).click();
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
        WebElement cart3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart']//span[.='3']")));
        driver.findElement(By.xpath("//li[@class='general-0']")).click();

        driver.findElement(By.xpath("//a[.='Checkout »']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']//tr"));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='remove_cart_item']")));
        element.click();
        wait.until(ExpectedConditions.stalenessOf(list.get(0)));

        list = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']//tr"));
        WebElement element2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='remove_cart_item']")));
        element2.click();
        wait.until(ExpectedConditions.stalenessOf(list.get(0)));

        list = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']//tr"));
        WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='remove_cart_item']")));
        element3.click();
        wait.until(ExpectedConditions.stalenessOf(list.get(0)));
    }

    @Test
    public void test12() throws InterruptedException {
        String path = new File(".").getAbsolutePath();
        String productName = "Name" + (int) (Math.random() * 1000);
        loginAdmin();
        driver.findElement(By.xpath("//span[.='Catalog']")).click();
        driver.findElement(By.xpath("//a[.=' Add New Product']")).click();
        driver.findElement(By.xpath("(//input[@name='status'])[1]")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys(productName);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(path + "\\src\\test\\resources\\qwerty.jpg");
        driver.findElement(By.xpath("//a[.='Information']")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("Short description");
        driver.findElement(By.xpath("//textarea[@name='description[en]']")).sendKeys("Description");
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys("head title");
        driver.findElement(By.xpath("//a[.='Prices']")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//input[@name='purchase_price']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")).click();
        driver.findElement(By.xpath("//option[@value='USD']")).click();
        driver.findElement(By.xpath("//input[@name='prices[USD]']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name='prices[EUR]']")).sendKeys("11");
        driver.findElement(By.xpath("//button[@name='save']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[.='" + productName + "']")).getText(), productName);
    }

    @Test
    public void test11() throws InterruptedException {
        openMainPage();
        driver.findElement(By.xpath("//*[@id='box-account-login']//tr[5]/td/a")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Иван");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Брайтон бич");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("00000");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Vice city");
        driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();

        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("United States");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();
        TimeUnit.SECONDS.sleep(1);
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String email = sb.toString() + "@mail.ru";
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+10000000000");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@name='create_account']")).click();
        driver.findElement(By.xpath("//*[@id='box-account']//li[4]/a")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.findElement(By.xpath("//*[@id='box-account']//li[4]/a")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void test10() throws InterruptedException {
        openMainPage();
        String nameMP = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).getText();
        String regularPriceMP = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getText();
        String campaingPriceMP = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getText();
        String regularPriceMPColor = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getCssValue("color");
        String[] hexValue = regularPriceMPColor.replace("rgba(", "").replace("rgb(", "").replace(")", "").split(",");
        //System.out.println(regularPriceMPColor);
        Assert.assertEquals(hexValue[0].trim(), hexValue[1].trim());
        Assert.assertEquals(hexValue[1].trim(), hexValue[2].trim());

        String regularPriceMPDecoration = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getCssValue("text-decoration");
        hexValue = regularPriceMPDecoration.split(" ");
        Assert.assertEquals(hexValue[0], "line-through");

        String campaingPriceMPColor = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getCssValue("color");
        hexValue = campaingPriceMPColor.replace("rgba(", "").replace(")", "").split(",");
        Assert.assertEquals(hexValue[1].trim(), "0");
        Assert.assertEquals(hexValue[2].trim(), "0");

        String campaingriceMPFontWeight = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getCssValue("font-weight");
        assertThat(campaingriceMPFontWeight, anyOf(is("bold"), is("900")));

        String regularPriceMPFontSize = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getCssValue("font-size");
        String campaingPriceMPFontSize = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getCssValue("font-size");
        Assert.assertTrue("", Double.parseDouble(regularPriceMPFontSize.replace("px","")) < Double.parseDouble(campaingPriceMPFontSize.replace("px","")));

        driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']")).click();
        String namePP = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        Assert.assertEquals(nameMP, namePP);

        String regularPricePP = driver.findElement(By.xpath("//div[@class='price-wrapper']//s[@class='regular-price']")).getText();
        Assert.assertEquals(regularPriceMP, regularPricePP);

        String campaingPricePP = driver.findElement(By.xpath("//div[@class='price-wrapper']//strong[@class='campaign-price']")).getText();
        Assert.assertEquals(campaingPriceMP, campaingPricePP);

        String regularPricePPColor = driver.findElement(By.xpath("//div[@class='price-wrapper']//s[@class='regular-price']")).getCssValue("color");
        hexValue = regularPricePPColor.replace("rgba(", "").replace("rgb(", "").replace(")", "").split(",");
        Assert.assertEquals(hexValue[0].trim(), hexValue[1].trim());
        Assert.assertEquals(hexValue[1].trim(), hexValue[2].trim());

        String regularPricePPDecoration = driver.findElement(By.xpath("//div[@class='price-wrapper']//s[@class='regular-price']")).getCssValue("text-decoration");
        hexValue = regularPricePPDecoration.split(" ");
        Assert.assertEquals(hexValue[0], "line-through");

        String campaingPricePPColor = driver.findElement(By.xpath("//div[@class='price-wrapper']//strong[@class='campaign-price']")).getCssValue("color");
        hexValue = campaingPricePPColor.replace("rgba(", "").replace(")", "").split(",");
        Assert.assertEquals(hexValue[1].trim(), "0");
        Assert.assertEquals(hexValue[2].trim(), "0");

        String campaingricePPFontWeight = driver.findElement(By.xpath("//div[@class='price-wrapper']//strong[@class='campaign-price']")).getCssValue("font-weight");
        assertThat(campaingricePPFontWeight, anyOf(is("bold"), is("700")));

        String regularPricePPFontSize = driver.findElement(By.xpath("//div[@class='price-wrapper']//s[@class='regular-price']")).getCssValue("font-size");
        String campaingPricePPFontSize = driver.findElement(By.xpath("//div[@class='price-wrapper']//strong[@class='campaign-price']")).getCssValue("font-size");
        Assert.assertTrue("", Double.parseDouble(regularPricePPFontSize.replace("px","")) < Double.parseDouble(campaingPricePPFontSize.replace("px","")));


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


}
