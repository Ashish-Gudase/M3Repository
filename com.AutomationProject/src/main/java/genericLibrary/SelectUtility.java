package genericLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {
	
	public void selectByVisibleText(WebElement dropdown, String text) {
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText(text);
		
	}

}
