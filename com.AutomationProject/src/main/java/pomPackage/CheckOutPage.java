package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import genericLibrary.SelectUtility;

public class CheckOutPage extends BaseTest {
	
	//Declaration
	@FindBy(id = "BillingNewAddress_CountryId") private WebElement countryDropDown;
	@FindBy(id = "BillingNewAddress_City") private WebElement cityTextBox;
	@FindBy(id = "BillingNewAddress_Address1") private WebElement address1TextBox;
	@FindBy(id = "BillingNewAddress_Address2") private WebElement address2TextBox;
	@FindBy(id = "BillingNewAddress_ZipPostalCode") private WebElement pincodeTextBox;
	@FindBy(id = "BillingNewAddress_PhoneNumber") private WebElement phoneTextBox;
	@FindBy(xpath = "//input[@onclick='Billing.save()']") private WebElement billingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']") private WebElement shippingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']") private WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")  private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']") private WebElement  paymentInfoContinueButton;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']") private WebElement  confirmOrderButton;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']") private WebElement orderProcessedText;
    @FindBy(id = "billing-address-select") private WebElement oldAddressDropDown;
    
    
	// initialization


	public CheckOutPage (WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	
	
  // Utilization
	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getCityTextBox() {
		return cityTextBox;
	}

	public WebElement getAddress1TextBox() {
		return address1TextBox;
	}

	public WebElement getAddress2TextBox() {
		return address2TextBox;
	}

	public WebElement getPincodeTextBox() {
		return pincodeTextBox;
	}

	public WebElement getPhoneTextBox() {
		return phoneTextBox;
	}

	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}

	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}

	public WebElement getConfirmOrderButton() {
		return confirmOrderButton;
	}

	public WebElement getOrderProcessedText() {
		return orderProcessedText;
	}
	
	public WebElement getOldAddressDropDown() {
		return oldAddressDropDown;
	}

	
	// Operational method
	
	public void buyProduct() throws EncryptedDocumentException, IOException {
		
		SelectUtility su = new SelectUtility();
		try {
		if(oldAddressDropDown.isDisplayed()==true) {
			su.selectByVisibleText(oldAddressDropDown, "New Address");
		  }
		}
		catch(Exception e) {
			su.selectByVisibleText(countryDropDown, "India");
		}
		su.selectByVisibleText(countryDropDown, "India");
		
		Flib flib = new Flib();
		String city = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 0);
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 1);
		long pin = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 2);
		//String pin = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 2);
		long phone = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);
		 //String phone = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);
		 
		int rn = flib.randomNumber();
		String phoneNo = phone+""+rn;
		
		cityTextBox.sendKeys(city);
		address1TextBox.sendKeys(address1);
		pincodeTextBox.sendKeys(String.valueOf(pin));// used wrapper class
		phoneTextBox.sendKeys(String.valueOf(phoneNo));
		
		billingAddressContinueButton.click();
		shippingAddressContinueButton.click();
		shippingMethodContinueButton.click();
		paymentMethodContinueButton.click();
		paymentInfoContinueButton.click();
		confirmOrderButton.click();
		
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(orderProcessedText.isDisplayed(), true, "Order is not placed");
        sa.assertAll();
	}
	
	
	
}
