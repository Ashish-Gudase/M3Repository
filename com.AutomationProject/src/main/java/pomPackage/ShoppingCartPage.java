package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']") private WebElement smartPhoneCartproduct;
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']/../..//input[@name='removefromcart']") private WebElement smartPhonecheckBox;
	@FindBy(name="updatecart") private WebElement updateShoppingCartButton;
	@FindBy(name="continueshopping") private WebElement continueShoppingButton;
	@FindBy(name="termsofservice") private WebElement termsOdServiceCheckbox;
	@FindBy(name="checkout") private WebElement checkOutButton;
	
	public WebElement getSmartPhonecheckBox() {
		return smartPhonecheckBox;
	}

	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getTermsOdServiceCheckbox() {
		return termsOdServiceCheckbox;
	}

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public ShoppingCartPage(WebDriver driver) {
		
		PageFactory.initElements( driver, this);
	}

	public WebElement getSmartPhoneCartproduct() {
		return smartPhoneCartproduct;
	}
}
