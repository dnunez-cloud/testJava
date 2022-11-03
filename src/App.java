import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
				System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
    }
}