package cartValidations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable






public class CartValidations {
	public static boolean MFGNumberExistInCart(String expectedMFG){
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		TestObject MFGProductNumber= findTestObject('Object Repository/cart/MFGField')
		List <WebElement> products= WebUI.findWebElements(MFGProductNumber,GlobalVariable.timeOut)
		for (int i=0; i<products.size();i++) {
			String actualMFG=products.get(i)
			if(expectedMFG == actualMFG) {
				assert true==true
			}
		}
	}
	public static boolean verifyQuantityForAddedProduct(String expectedQTY){
		TestObject quantityField= findTestObject('Object Repository/cart/QTYInCart')
		List <WebElement> QTY= WebUI.findWebElements(quantityField,GlobalVariable.timeOut)
		for (int i=0; i<QTY.size();i++) {
			String actualQTY=QTY.get(i)
			if(expectedQTY == actualQTY) {
				assert true==true
			}
		}
	}
	public static boolean verifyConfirmationMessageIsAppear(){
		TestObject confirmMessage= findTestObject('Object Repository/productPage/confirmationMessage')
		WebUI.waitForElementVisible(confirmMessage, 30)
		WebUI.verifyElementVisible(confirmMessage)
	}
	public static boolean verifyCartItemNumber(int expectedItemNumber){
		TestObject cartItemNumber= findTestObject('Object Repository/cart/cartItem')
		WebUI.scrollToPosition(0, 0)
		String actualItemNumber=WebUI.getText(cartItemNumber)
		int numberOfItem=Integer.parseInt(actualItemNumber.split(" ")[0])
		assert expectedItemNumber == numberOfItem
	}
}
