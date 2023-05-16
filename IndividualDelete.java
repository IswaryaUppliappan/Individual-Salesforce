package individual.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class IndividualDelete {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement drop = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", drop);
		WebElement s = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		s.sendKeys("Kumar");
		s.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement c = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		driver.executeScript("arguments[0].click();", c);
		WebElement e = driver.findElement(By.xpath("//div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", e); 
		 driver.findElement(By.xpath("//span[text()='Delete']")).click();
	        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
			String expected_Result="Individual \"Ganesh Kumar\" was deleted. Undo";
			Assert.assertEquals(actual_Result,expected_Result);

	}

}
