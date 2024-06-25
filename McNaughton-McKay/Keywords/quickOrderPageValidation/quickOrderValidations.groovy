package quickOrderPageValidation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import quickOrderPageActions.quickOrderActions as quickOrderActions



public class quickOrderValidations {
	public static boolean verifyAddToOrderButtonIsDisable() {
		TestObject addToOrderButton= findTestObject('Object Repository/quickOrderPage/addToOrderButton')
		boolean disable=WebUI.verifyElementNotClickable(addToOrderButton)
	}
	public static boolean verifyAddToCartAndCheckoutButtonIsEnable() {
		TestObject AddToCartAndCheckoutButton= findTestObject('Object Repository/quickOrderPage/addAllToCartAndCheckoutButton')
		boolean disable=WebUI.verifyElementClickable(AddToCartAndCheckoutButton)
	}
	public static boolean verifySearcFieldAndQTYArecleared() {
		TestObject searchField= findTestObject('Object Repository/quickOrderPage/searchField')
		TestObject QtyField= findTestObject('Object Repository/quickOrderPage/QTYField')
		String placeHolder= WebUI.getAttribute(searchField, "placeholder")
		String QTY= WebUI.getAttribute(QtyField, "value")
		if (placeHolder=="Type to search" && QTY=="1") {
			assert true==true
		}
	}
	
	public static boolean verifyTheProductsInOrderLineAreSameToTheAddedProduct(HashMap<String,Integer> info) {
		int numberOfProducts=GlobalVariable.numberOfAddedProducts
		String MFG=""
		for (int i=2;i<=numberOfProducts;i++) {
			quickOrderActions.getMFGNumber(i)
			if(info.containsKey(MFG)) {
				assert true==true
			}
		}
	}
	public static String getMFGNumberFromCart(int index) {
		TestObject MFGproduct= findTestObject('Object Repository/quickOrderPage/MFGInCartForQuickOrder',['index':index])
		WebUI.waitForElementVisible(MFGproduct, GlobalVariable.timeOut)
		String MFG= WebUI.getText(MFGproduct)
		return MFG
	}
	public static boolean verifyTheOrderInCartIsCorrect(HashMap<String,Integer> info) {
		int numberOfProducts=GlobalVariable.numberOfAddedProducts
		String MFG=""
		for (int i=2;i<=numberOfProducts;i++) {
			getMFGNumberFromCart(i)
			if(info.containsKey(MFG)) {
				assert true==true
			}
		}
	}
	public static boolean verifyTheOrderAddedToCartWithCorrectQuantity() {
		int numberOfProducts=GlobalVariable.numberOfAddedProducts
		for (int i=2;i<=numberOfProducts;i++) {
			TestObject QTYInput= findTestObject('Object Repository/quickOrderPage/QTYInCart',['index':i])
			String QTY= WebUI.getText(QTYInput)
			if(QTY == GlobalVariable.QTY) {
				assert true==true
			}
		}
	}
	public static boolean verifyTheOrderSummary(HashMap<String,Integer> info,String orderSummary) {
		TestObject totalInCart= findTestObject('Object Repository/quickOrderPage/totalPriceInCart') 
		TestObject totalInQuickOrder= findTestObject('Object Repository/quickOrderPage/totalInOrderSummary')
		String totalPriceInOrderSummary=""
		if (orderSummary == "InCart") {
			totalPriceInOrderSummary= WebUI.getText(totalInCart)
		}else if(orderSummary == "InQuickOrder") {
			totalPriceInOrderSummary= WebUI.getText(totalInQuickOrder)
		}
		 
		String cleanedPriceText = totalPriceInOrderSummary.replaceAll("[^0-9.]", "")
		BigDecimal price= Float.parseFloat(cleanedPriceText)
		double sum= 0.00
		for (int value : info.values()) {
			sum += value;
		}
		
		String convertSumWithTwoNumberAfterPoint = String.format("%.2f", sum);
		double totalPrice=Double.parseDouble(convertSumWithTwoNumberAfterPoint)
		assert totalPrice==sum
	}
	public static boolean verifyNavigatedToCartSuccessfully() {
		String currentURL=WebUI.getUrl()
		assert GlobalVariable.cartURL == currentURL
	}
	
	
	public static boolean verifyNumberOfProducsIsCorrect(int num) {
		TestObject header= findTestObject('Object Repository/quickOrderPage/numberOfProductInCart')
		String headerText=  WebUI.getText(header)
		String numberOfProducts=""
		def matcher = (headerText =~ /\d+/)
		if (matcher.find()) {
			numberOfProducts = matcher.group(0) 
		}
		int numberOfProduct=Integer.parseInt(numberOfProducts)
		assert num == numberOfProduct
}
public static boolean verifyLoginForYourPriceButtonIsVisible() {
	TestObject Button= findTestObject('Object Repository/quickOrderPage/LoginForYourPriceButton')
	WebUI.waitForElementVisible(Button, GlobalVariable.timeOut)
}
}

