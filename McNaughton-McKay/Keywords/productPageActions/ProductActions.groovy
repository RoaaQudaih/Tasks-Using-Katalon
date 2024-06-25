package productPageActions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable




public class ProductActions {
	
	public static void enterSearchTerm(String productName) {
		TestObject searchField= findTestObject('Object Repository/productPage/searchInputField')
		WebUI.setText(searchField,'')
		WebUI.setText(searchField, productName)
	}

	public static void clickSearchButton() {
		TestObject searchButton= findTestObject('Object Repository/productPage/searchButton')
		WebUI.click(searchButton)
	}
}
