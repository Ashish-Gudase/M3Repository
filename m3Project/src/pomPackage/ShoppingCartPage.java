package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']") private WebElement smartPhoneCartproduct;
	
	public ShoppingCartPage(WebDriver driver) {
		
		PageFactory.initElements( driver, this);
	}

	public WebElement getSmartPhoneCartproduct() {
		return smartPhoneCartproduct;
	}
}
