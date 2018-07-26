import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.MobileDriver
import io.appium.java_client.MobileElement

import org.openqa.selenium.WebElement

Mobile.startApplication('C:\\Users\\Hippolyte\\Katalon Studio\\Android Mobile Tests with Katalon Studio\\androidapp\\APIDemos.apk', 
    true)

def driver = MobileDriverFactory.getDriver();
def elements = driver.findElementsByXPath("//*");

10.times {
	Collections.shuffle elements
	MobileElement e = elements.first();
	def innerElements = e.findElementsByXPath("//*");
	if(!innerElements.empty) {
		e.click();
		Mobile.pressBack();
		println("back pressed")
	}
	else {
		e.click()
	}
}

/*Mobile.tap(findTestObject('recorded_mobile/android.widget.TextView2 - Item 1'), 0)

Mobile.tap(findTestObject('recorded_mobile/android.widget.ImageButton0'), 0)

Mobile.tap(findTestObject('recorded_mobile/android.widget.ImageButton0 (1)'), 0)

Mobile.tap(findTestObject('recorded_mobile/android.widget.TextView24 - Item 12'), 0)

Mobile.tap(findTestObject('recorded_mobile/android.widget.ImageButton1'), 0)

Mobile.tap(findTestObject('recorded_mobile/android.widget.ImageButton0'), 0)*/
Mobile.closeApplication()

