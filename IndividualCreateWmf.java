package individual.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

	public class IndividualCreateWmf {

		public static void main(String[] args) {
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
			driver.findElement(By.xpath("//div[@title='New']")).click();
			WebElement f = driver.findElement(By.xpath("//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']"));
			f.click();
			WebElement d = driver.findElement(By.xpath("//a[@title='Mr.']"));
		    driver.executeScript("arguments[0].click();", d);
		    WebElement g = driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']"));
		    g.sendKeys("Ganesh");
		    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		    String actual_Error=driver.findElement(By.xpath("//li[text()='Complete this field.']")).getText();
			String expected_Error= "Complete this field.";
		    Assert.assertEquals(actual_Error,expected_Error);
		    Assert.assertTrue(actual_Error.contains("Complete this field."));
	}

}
