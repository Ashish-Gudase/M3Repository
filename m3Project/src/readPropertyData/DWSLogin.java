package readPropertyData;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWSLogin implements IAutoConstant {
	
	public static void main(String[] args) throws IOException {
		
		FLib flib = new FLib();
		String url = flib.readDataFromPropertyFile(path, "url");
		String email = flib.readDataFromPropertyFile(path, "email");
		String pass = flib.readDataFromPropertyFile(path, "password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	
		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
		
			   
			   driver.findElement(By.id("Email")).sendKeys(email);
			   driver.findElement(By.id("Password")).sendKeys(pass);
			   driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

}
