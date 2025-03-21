package testNGPackage1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToUnderstandDependsOnMethods {
	
	@Test (dependsOnMethods = "register")
	
	public void login() {
		Reporter.log("This is login method", true);
	}
	

   @Test (dependsOnMethods = {"register","login"})
	
	public void checkAccountBalance() {
		Reporter.log("This is check Account Balance method", true);
	}
	
  @Test (dependsOnMethods = "moneyTransfer")

   public void logout() {
	Reporter.log("This is logout method", true);
}
 
  @Test 

  public void register() {
	Reporter.log("This is register method", true);
}

 @Test (dependsOnMethods = "checkAccountBalance")

  public void moneyTransfer() {
	Reporter.log("This is money transfer method", true);
}



}
