package automation_easy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class VerifyTitle {
	public WebDriver driver;
	public ChromeOptions options;
	
	@Test
	public void verifyHomePageTitle() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
	System.out.println(driver.getTitle());
	String actualTitle ="Your Store";
	String expectedTitle =driver.getTitle();
	if(expectedTitle.equals("Your Store")) {
		System.out.println("This is correct landing page of tutorialsninja");
	}else {
		System.out.println("This is incorrect landing page of tutorialsninja");
		driver.quit();
	}
	}
	

}
