package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

  WebDriver driver;
  By user = By.xpath("/html/body/div/div/form/input[1]");
  By password = By.xpath("/html/body/div/div/form/input[2]");
  By titleText =By.xpath("/html/body/h1");
  By loginBtn = By.xpath("/html/body/div/div/form/button");

  public loginPage(WebDriver driver){
    this.driver = driver;
  }

  //Set user name in textbox
  public void setUserName(String strUserName){
    driver.findElement(user).sendKeys(strUserName);
  }

  //Set password in password textbox
  public void setPassword(String strPassword){
    driver.findElement(password).sendKeys(strPassword);
  }

  //Click on login button
  public void clickLogin(){
    driver.findElement(loginBtn).click();
  }

  //Get the title of Login Page
  public String getLoginTitle(){
    return driver.findElement(titleText).getText();
  }

  /**
  * @param strUserName
  * @param strPasword
  * @return
  */

  public void loginUser(String strUserName,String strPasword){
    //Fill user name
    this.setUserName(strUserName);
    //Fill password
    this.setPassword(strPasword);
    //Click Login button
    this.clickLogin();
  }
}