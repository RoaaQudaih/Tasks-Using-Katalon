package searchResultPageActions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable



public class SearchResultPageActions {
	public static void enterQTYField(int productIndex,String QTY) {
		TestObject QTYField= findTestObject('Object Repository/productPage/QTY')
		String newCssSelector= "div[data-test-selector='productListCards_undefined'] > :nth-child(${productIndex})  input[data-test-selector='product_qtyOrdered']"
		QTYField = WebUI.modifyObjectProperty(QTYField, 'css', 'equals', newCssSelector, true)
		WebUI.waitForElementVisible(QTYField, GlobalVariable.timeOut)
		WebUI.setText(QTYField, QTY)
	}

	public static void clickAddToCartButton(int targetProductIndex) {
		TestObject addToCartButton= findTestObject('Object Repository/searchResultPage/addToCartButton')
		String newCssSelector= "div[data-test-selector='productListCards_undefined'] > :nth-child(${targetProductIndex})  button[data-test-selector^='actionsAddToCart']"
		addToCartButton = WebUI.modifyObjectProperty(addToCartButton, 'css', 'equals', newCssSelector, true)
		WebUI.waitForElementVisible(addToCartButton, GlobalVariable.timeOut)
		WebUI.click(addToCartButton)
	}

	public static String getProductMFGNumber(int productIndex) {
		TestObject MFGProductNum= findTestObject('Object Repository/searchResultPage/MFG')
		String newCssSelectorForMFG= "div[data-test-selector='productListCards_undefined'] > :nth-child(${productIndex}) span[data-test-selector='manufacturerItem']"
		MFGProductNum = WebUI.modifyObjectProperty(MFGProductNum, 'css', 'equals', newCssSelectorForMFG, true)
		WebUI.waitForElementVisible(MFGProductNum, GlobalVariable.timeOut)
		String MFG=WebUI.getText(MFGProductNum)
		return MFG
	}
}
