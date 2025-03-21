package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomPackage.CheckOutPage;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListener.class)
public class TC_BuyProduct_003_Test extends BaseTest {
	
	@Test
	public void buyProductMethod() throws EncryptedDocumentException, IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		ep.getSmartPhoneLink().click();
		
		wp.getShoppingCartLink().click();
		
	    ShoppingCartPage sp = new ShoppingCartPage(driver);
	    sp.getSmartPhonecheckBox().click();
	    sp.getTermsOdServiceCheckbox().click();
	    sp.getCheckOutButton().click();
	    
	    CheckOutPage cp = new CheckOutPage(driver);
	    cp.buyProduct();
	
		
	}

}
