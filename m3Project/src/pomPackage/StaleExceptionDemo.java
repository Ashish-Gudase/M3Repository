package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleExceptionDemo {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Log in")).click();
        WebElement email = driver.findElement(By.id("Email"));
        driver.navigate().refresh();// refreshing page
        email.sendKeys("gudaseashish007@gmail.com");//throws exception
        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("Demo@123");
        WebElement button = driver.findElement(By.xpath("//input[@value='Log in']"));
        button.click();
	}

}
