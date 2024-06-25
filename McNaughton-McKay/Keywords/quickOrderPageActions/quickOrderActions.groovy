package quickOrderPageActions

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import randomProduct.randomProductActions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import internal.GlobalVariable

public class quickOrderActions {
	public static List <String> MFGs=new ArrayList<String>()
	public static void enterSearchField(String searchTerm) {
		TestObject searchField= findTestObject('Object Repository/quickOrderPage/searchField')
		WebUI.clearText(searchField)
		WebUI.setText(searchField, searchTerm)
	}
	public static int numberOfProductsInDropDown() {
		TestObject productsInDropDown=findTestObject('Object Repository/quickOrderPage/dropDown')
		WebUI.waitForElementPresent(productsInDropDown, GlobalVariable.timeOut)
		List <WebElement> products= WebUI.findWebElements(productsInDropDown, GlobalVariable.timeOut)
		System.out.println(products.size())
		return products.size()
	}
	public static String selectRandomProduct () {
		int numberOfProducts= numberOfProductsInDropDown()
		int productIndex = randomProductActions.generateRandomValue(1,numberOfProducts)
		System.out.println(productIndex)
		TestObject choosenProduct=findTestObject('Object Repository/quickOrderPage/productInDropDown',['productIndex':productIndex])
		WebUI.waitForElementPresent(choosenProduct, GlobalVariable.timeOut)
		TestObject mfgForTheAddedProduct= findTestObject('Object Repository/quickOrderPage/MFGForTheAddedProduct',['index':productIndex])
		String MFGForProduct=WebUI.getText(mfgForTheAddedProduct)
		while (isMFGAlreadyAdded(MFGForProduct)) {
			productIndex = randomProductActions.generateRandomValue(1,numberOfProducts)
			System.out.println(productIndex)
			choosenProduct=findTestObject('Object Repository/quickOrderPage/productInDropDown',['productIndex':productIndex])
			MFGForProduct = getMFGNumber(productIndex);
		}
		MFGs.add(MFGForProduct)
		WebUI.click(choosenProduct)		
		return MFGForProduct
	}
	public static boolean isMFGAlreadyAdded(String productMFG) {
		for (String MFG : MFGs) {
			if (MFG.equals(productMFG)) {
				return true;
			}
		}
		return false;
	}


	public static void enterQTY(String QTY) {
		TestObject QTYField= findTestObject('Object Repository/quickOrderPage/QTYField')
		WebUI.clearText(QTYField)
		WebUI.sendKeys(QTYField, QTY)
	}
	public static String clickAddToOrderButton(String term,String MFG) {
		TestObject addToOrderButton= findTestObject('Object Repository/quickOrderPage/addToOrderButton')
		if(WebUI.waitForElementNotClickable(addToOrderButton, GlobalVariable.timeOut)) {
			enterSearchField(term)
			return selectRandomProduct()
		}

		WebUI.click(addToOrderButton)
		(GlobalVariable.numberOfAddedProducts)++
		return MFG
	}
	public static String getMFGNumber(int index) {
		TestObject mfgForTheAddedProduct= findTestObject('Object Repository/quickOrderPage/MFGInOrderLine',['index':index])
		String MFGForProduct=WebUI.getText(mfgForTheAddedProduct)
		return MFGForProduct
	}
	public static double getProductTotalPrice(int index) {
		TestObject productPrice= findTestObject('Object Repository/quickOrderPage/productTotalPrics',['index':index])
		String totalPrice=""
		try {
			WebUI.waitForElementPresent(productPrice, GlobalVariable.timeOut)
			WebUI.waitForElementVisible(productPrice, GlobalVariable.timeOut)
			totalPrice= WebUI.getText(productPrice)
		} catch (Exception e) {
			e.printStackTrace()
			return BigDecimal.ZERO
		}

		String cleanedPriceText = totalPrice.replaceAll("[^0-9.]", "")
		double doubleCleanedText= Double.parseDouble(cleanedPriceText)
		String priceWithTwoNumberAfterPoint = String.format("%.2f", doubleCleanedText)
		double price=Double.parseDouble(priceWithTwoNumberAfterPoint)
		return price
	}
	public static void clickAddToCartAndCheckoutButton() {
		TestObject AddToCartAndCheckoutButton= findTestObject('Object Repository/quickOrderPage/addAllToCartAndCheckoutButton')
		WebUI.click(AddToCartAndCheckoutButton)
	}
}
