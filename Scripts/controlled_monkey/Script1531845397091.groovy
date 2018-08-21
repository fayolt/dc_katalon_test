import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After
import org.openqa.selenium.By
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

protected String getXPathFromElement(WebElement element) {
	String elementDescription = element.toString();
	println elementDescription
	return elementDescription.substring(elementDescription.lastIndexOf("-> xpath: ") + 10, elementDescription.lastIndexOf("]"));
}

protected TestObject fromElement(WebElement element) {
	TestObject testObject = new TestObject();
	testObject.addProperty("xpath", ConditionType.EQUALS, getXPathFromElement(element));
	return testObject;
}

// WebUI.openBrowser("http://tupeuxpastest.csq.io");
WebUI.openBrowser("https://marksandspicy.com");

WebUI.delay(2);

WebDriver driver = DriverFactory.getWebDriver();
List<WebElement>elements = driver.findElements(By.xpath("//*"));

int count = 0;

//List<WebElement> filteredElements = elements.stream().filter{e ->
//	( e.getTagName() != "meta" || e.getTagName() != "script" || e.getAttribute("class") != "_blank")}.collect();  

10.times {
	try {
		Collections.shuffle elements
		WebElement element = elements.first();
		//while (e.getAttribute("id").contains("8")) {
		while (!element.isDisplayed()) {
			Collections.shuffle elements
			element = elements.first();
		}
		if (element.getTagName().equals("a") && element.getAttribute("href").startsWith("http://www.prestashop.com/")) {
			println element.toString();
			//TestObject updatedObject = fromElement(element);
			//println updatedObject.toString();
			//WebUI.modifyObjectProperty(updatedObject, null, null, null, false)
		}
		element.click();
		count ++;
	 } catch(Exception ex){
		println "Exception caught";
		elements = driver.findElements(By.xpath("//*"));
	 }
	WebUI.delay(1)
}
WebUI.closeBrowser();