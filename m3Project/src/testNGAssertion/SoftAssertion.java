package testNGAssertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test
	public void invalidLoginTC() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		
		String expectedWelcomePageTitle="Demo Web Shop ";
		String expectedLoginPageTitle="Demo Web Shop. Login ";// added space to check soft assert 
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), expectedWelcomePageTitle, "Welcome page not found");
		
		
		driver.findElement(By.linkText("Log in")).click();
		sa.assertEquals(driver.getTitle(), expectedLoginPageTitle, "Login page not found");
		
		
		driver.findElement(By.id("Email")).sendKeys("gudaseashish007@gmail.com");
	    driver.findElement(By.id("Password")).sendKeys("Demo@123");
	    driver.findElement(By.xpath("//input[@value='Log in']")).click();
	    Thread.sleep(2000);
	    
	    sa.assertAll();
	}

}
