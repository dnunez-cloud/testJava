package test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.mainPage;
import pages.loginPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class testMain {

  String driverPath = "C:\\BrowserDrivers\\chromedriver.exe";
  WebDriver driver;
  loginPage objLogin;
  mainPage objMainPage;

  @BeforeTest
  public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://practis.co.il/automation/");
    //Create Login Page object
    objLogin = new loginPage(driver);
    //login to application
    objLogin.loginUser("admin", "admin");
    // go the next page
    objMainPage = new mainPage(driver);
   }

  @Test
  public void testdo1do2(){
    objMainPage.clickBtn1();
    Assert.assertTrue(objMainPage.statusBtn2());
    objMainPage.clickBtn2();
    Assert.assertTrue(objMainPage.statusBtn1());
    objMainPage.clickBtn1();
    objMainPage.clickBtn2();
    Assert.assertTrue(objMainPage.statusBtn1());
  }

  @Test
  public void testIncreaseDecrease(){
    objMainPage.clickIncrease();
    Assert.assertTrue(objMainPage.getTextVariableFont().toLowerCase().contains("23"));
    objMainPage.clickIncrease();
    Assert.assertTrue(objMainPage.getTextVariableFont().toLowerCase().contains("26"));
    objMainPage.clickDecrease();
    objMainPage.clickDecrease();
    Assert.assertTrue(objMainPage.getTextVariableFont().toLowerCase().contains("20"));
  }

  @Test
  public void testBackground(){
    objMainPage.setBackground("red");
    Assert.assertTrue(objMainPage.getBackgroundColor().toLowerCase().contains("red"));
    objMainPage.setBackground("green");
    Assert.assertTrue(objMainPage.getBackgroundColor().toLowerCase().contains("green"));
    objMainPage.setBackground("asdasdasdasd");
    Assert.assertTrue(objMainPage.getBackgroundColor().toLowerCase().contains("green"));
  }
}