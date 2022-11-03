package test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.mainPage;
import pages.loginPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLogin {

  String driverPath = "C:\\BrowserDrivers\\chromedriver.exe";
  WebDriver driver;
  loginPage objLogin;
  mainPage objHomePage;

  @BeforeTest
  public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://practis.co.il/automation/");
  }

  @Test
  public void test_Home_Page_Appear_Correct(){
    //Create Login Page object
    objLogin = new loginPage(driver);
    //Verify login page title
    String loginPageTitle = objLogin.getLoginTitle();
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("Welcome to the Automation test login page"));
    //login to application
    objLogin.loginUser("admin", "admin");
    // go the next page
    objHomePage = new mainPage(driver);
    //Verify home page
    String URL = driver.getCurrentUrl();
    Assert.assertEquals(URL, "https://practis.co.il/automation/main.php" );  }
}