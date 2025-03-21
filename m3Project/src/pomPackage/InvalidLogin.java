package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class InvalidLogin extends BaseTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		BaseTest bt = new BaseTest();
		bt.browserSetup();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		Flib flib = new Flib();
		int rc = flib.lastRowCount(EXCEL_PATH, INVALIDLOGINCREDS);
		
		LoginPage lp = new LoginPage(driver);
		
		for(int i=1; i<=rc; i++) {
		String email=flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 0);
		String password=flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 1);
		
		lp.invalidLoginMethod(email, password);
		
		}
		
	}

}
