package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

@Listeners(genericLibrary.MyListener.class)
public class TC_AddToCart_001_Test extends BaseTest {
	
	@Test
	public void addToCartMethod() throws IOException {
		
		WelcomePage wp = new WelcomePage(driver);
		
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		ep.getSmartPhoneLink().click();
		
		wp.getShoppingCartLink().click();
		
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sp.getSmartPhoneCartproduct().isDisplayed(), true, "Product is not added to cart");
		sa.assertAll();
		
		
		//boolean result = sp.getSmartPhoneCartproduct().isDisplayed();
		//System.out.println(result==true?"Product added sucessfully":"Product not added");
	}

}
