package pomPackage;

import java.io.IOException;

public class ValidLogin extends BaseTest{
	public static void main(String[] args) throws IOException {
		BaseTest bt = new BaseTest();
		bt.browserSetup();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		Flib flib = new Flib();
		String email = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 0);
		String password = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.validLoginMethod(email, password);
		
//		lp.getEmailTB().sendKeys(email);
//		lp.getPasswordTB().sendKeys(password);
//		lp.getLoginButton().click();
		
	}

}
