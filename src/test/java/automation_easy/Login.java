package automation_easy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
public static WebDriver driver;

 @Test public void verifyLoginWithValidCredentials() { 
	 driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
  driver.get("https://tutorialsninja.com/demo/");
  driver.findElement(By.xpath("//span[text()='My Account']")).click();
  driver.findElement(By.linkText("Login")).click();
  
  
  }
 
}
