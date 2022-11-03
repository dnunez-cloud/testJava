package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage {

  WebDriver driver;
  By do1Btn = By.xpath("//*[@id='do1']");
  By do2Btn = By.xpath("//*[@id='do2']");
  By increaseFont = By.xpath("//*[@id='btnIncreaseFont']");
  By decreaseFont = By.xpath("//*[@id='btnDecreaseFont']");
  By textVariableFont = By.xpath("//*[@id='textFontSize']");
  By backgroundInput = By.xpath("//*[@id='bgColor']");
  By backgroundButton = By.xpath("//*[@id='btnSetBgColor']");
  By backgroundFrame = By.xpath("//*[@id='formToColorize']");

  public mainPage(WebDriver driver){
    this.driver = driver;
  }

  public void clickBtn1(){
    driver.findElement(do1Btn).click();
  }

  public void clickBtn2(){
    driver.findElement(do2Btn).click();
  }

  public boolean statusBtn1(){
    return driver.findElement(do1Btn).getTagName().contains("disabled");
  }

  public boolean statusBtn2(){
    return driver.findElement(do2Btn).getTagName().contains("disabled");
  }

  public void clickIncrease(){
    driver.findElement(increaseFont).click();
  }

  public void clickDecrease(){
    driver.findElement(decreaseFont).click();
  }

  //Get the text variableFont
  public String getTextVariableFont(){
    return driver.findElement(textVariableFont).getCssValue("font-size");
  }

  public void clickBackground(){
    driver.findElement(backgroundButton).click();
  }

   //Set background frame
  public void setBackgroundColor(String strBackground){
    driver.findElement(backgroundInput).sendKeys(strBackground);
  }

  public String getBackgroundColor(){
    return driver.findElement(backgroundFrame).getCssValue("style");
  }
  
 /**
  * @param strBackground
  * @return
  */
  public void setBackground(String strBackground){
    this.setBackgroundColor(strBackground);            
    this.clickBackground();
  }
}