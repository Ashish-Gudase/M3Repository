package testNGPackage1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToUnderstandPriorityAttribute {
	
  @Test(priority=2)
  
  public void method1() {
	Reporter.log("Method1 called", true);  
  }
  
  @Test(priority = 1,invocationCount = 2)
  
  public void method2() {
	  
	  Reporter.log("Method2 called", true);  
  }
}
