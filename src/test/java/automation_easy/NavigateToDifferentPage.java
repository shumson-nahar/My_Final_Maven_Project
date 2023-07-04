package automation_easy;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//Write a TestNG test to navigate to a website, click on a link to navigate to a different page, and verify
//the presence of certain elements on the new page.
public class NavigateToDifferentPage {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	}

	@Test(priority = 1)
	public void test1() throws Exception {

		// JavascriptExecutor js =(JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0, 500)");
		String parentWindowHandle = driver.getWindowHandle();
		driver.findElement(By.id("newWindowBtn")).click();

		System.out.println(parentWindowHandle);

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());

		Iterator<String> iterator = windows.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parentWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.manage().window().maximize();
				WebElement firstNameTextbox = driver.findElement(By.id("firstName"));
				Assert.assertTrue(firstNameTextbox.isDisplayed());
				firstNameTextbox.sendKeys("Shumson");
				driver.findElement(By.id("lastName")).sendKeys("Nahar");
				driver.findElement(By.id("malerb")).click();
				driver.findElement(By.id("englishchbx")).click();
				driver.findElement(By.id("email")).sendKeys("naharshumson2@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Farabi1234");
				driver.close(); // this will close the child window

			}
		}

		driver.switchTo().window(parentWindowHandle);
		WebElement parentWindowTextBox = driver.findElement(By.id("name"));
		Assert.assertTrue(parentWindowTextBox.isDisplayed());
		Thread.sleep(2000);
		parentWindowTextBox.sendKeys("I am back in the parent window");

	}

	@Test(priority = 2)
	public void test2() throws Exception {
		String parentWindowHandle = driver.getWindowHandle();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);

		driver.findElement(By.id("newTabBtn")).click();

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());

		Iterator<String> iterator = windows.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parentWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.id("alertBox")).click();

				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			}
		}

		driver.switchTo().window(parentWindowHandle);
		WebElement parentWindowTextBox = driver.findElement(By.id("name"));
		Assert.assertTrue(parentWindowTextBox.isDisplayed());
		Thread.sleep(2000);
		parentWindowTextBox.sendKeys("I am back in the parent window");

	}

	@Test(priority = 3)
	public void test3() throws Exception {
		String parentWindowHandle = driver.getWindowHandle();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);

		driver.findElement(By.id("newWindowsBtn")).click();

		Set<String> windows = driver.getWindowHandles();
		
		
		System.out.println(windows.size());

		Iterator<String> iterator = windows.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parentWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				// title of the child window
				if (driver.getTitle().equals("Basic Controls - H Y R Tutorials")) {
					driver.manage().window().maximize();
					WebElement firstNameTextbox = driver.findElement(By.id("firstName"));
					Assert.assertTrue(firstNameTextbox.isDisplayed());
					firstNameTextbox.sendKeys("Shumson");
					driver.findElement(By.id("lastName")).sendKeys("Nahar");
					driver.findElement(By.id("malerb")).click();
					driver.findElement(By.id("englishchbx")).click();
					driver.findElement(By.id("email")).sendKeys("naharshumson2@gmail.com");
					driver.findElement(By.id("password")).sendKeys("Farabi1234");
					driver.close(); // this will close the first child window
				}
			}
		}
		
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parentWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				// title of the child window
				if (driver.getTitle().equals("Xpath Practice - H Y R Tutorials")) {
					driver.manage().window().maximize();
                    driver.findElement(By.xpath("//div[@class = 'container']/input[1]")).sendKeys("Shumson");
                    driver.findElement(By.xpath("//div[@class = 'container']/input[2]")).sendKeys("Nahar");
                    driver.findElement(By.xpath("//div[@class = 'container']/input[3]")).sendKeys("naharshumson2@gmail.com");
				    driver.close();
				}

			}
		}

		driver.switchTo().window(parentWindowHandle);
		WebElement parentWindowTextBox = driver.findElement(By.id("name"));
		Assert.assertTrue(parentWindowTextBox.isDisplayed());
		Thread.sleep(2000);
		parentWindowTextBox.sendKeys("I am back in the parent window");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
