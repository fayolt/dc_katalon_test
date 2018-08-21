import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.MobileBy.ByIosUIAutomation as ByIosUIAutomation
import io.appium.java_client.MobileDriver as MobileDriver
import io.appium.java_client.MobileElement as MobileElement
import io.appium.java_client.ios.IOSDriver as IOSDriver
import oracle.net.aso.x

import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import io.appium.java_client.AppiumDriver as AppiumDriver

def driver = DriverFactory.getWebDriver();


Mobile.startApplication('/Users/hanqingwang/Downloads/Shopstore.apk', true, FailureHandling.OPTIONAL)

Mobile.startApplication('/Users/hanqingwang/Downloads/CSTestApp.app', true, FailureHandling.OPTIONAL)

Mobile.startApplication('C:\\Users\\Hippolyte\\Katalon Studio\\Android Mobile Tests with Katalon Studio\\androidapp\\APIDemos.apk',
	true, FailureHandling.OPTIONAL)

def height = Mobile.getDeviceHeight()

def width = Mobile.getDeviceWidth()

def run_time = 20

def tap_percent = 0.5

def swipe_percent = 1 - tap_percent

run_time.times({
		random = (Math.abs(new Random().nextInt()%11)-1) / 10
		if (random < tap_percent){
			Mobile.tapAtPosition(Math.abs(new Random().nextInt() % width) + 1, Math.abs(new Random().nextInt() % height) + 1)
		}else {
			Mobile.swipe(Math.abs(new Random().nextInt() % width) + 1, Math.abs(new Random().nextInt() % height) + 1, Math.abs(new Random().nextInt() % width) + 1, Math.abs(new Random().nextInt() % height) + 1)
		}
	})

Mobile.closeApplication()

