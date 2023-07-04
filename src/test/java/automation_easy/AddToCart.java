package automation_easy;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCart {
	public WebDriver driver;
	public ChromeOptions options;
	public SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void openBrowser() {
	options = new ChromeOptions();
	options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	options.addArguments("--start-maximized");
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	driver.get("https://tutorialsninja.com/demo/");

}
	@Test
	public void addToCart() {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys("iphone");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		driver.findElement(By.cssSelector("#content > p > label")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/product&product_id=40&search=iphone&description=true");
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		String actualWarningMessage =driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
		String expectedWarningMessage ="Success: You have added iPhone to your shopping cart!";
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();		
		
		
	}
	@Test
	public void addToCart1() {
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys("Apple Cinema 30");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		driver.findElement(By.cssSelector("#content > p > label")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/product&product_id=40&search=iphone&description=true");
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		//driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).click();
	    String actualWarningMessage =driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
		String expectedWarningMessage =" Success: You have added iPhone to your shopping cart!  ";
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
				
		
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
