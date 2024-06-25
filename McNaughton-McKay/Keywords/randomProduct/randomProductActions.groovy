package randomProduct
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import searchResultPageActions.SearchResultPageActions
public class randomProductActions {
	public static int generateRandomValue(int minVal,int maxVal) {

		return  new Random().nextInt(minVal,maxVal)
	}

	public static int selectRandomProduct(String MFG) {
		TestObject selectedProduct= findTestObject('Object Repository/productPage/ProductInPage')
		TestObject MFGProductNum= findTestObject('Object Repository/searchResultPage/MFG')
		String productMFG=MFG
		int randomProductIndex
		while (productMFG == MFG) {
			randomProductIndex = generateRandomValue(1, GlobalVariable.numberOfProductInPage)
			System.out.println(randomProductIndex)
			String newCssSelector = "div[data-test-selector='productListCards_undefined'] > :nth-child(${randomProductIndex.toString()})"
			selectedProduct = WebUI.modifyObjectProperty(selectedProduct, 'css', 'equals', newCssSelector, true)
			productMFG=SearchResultPageActions.getProductMFGNumber(randomProductIndex)
			System.out.println(productMFG)
		}

		return randomProductIndex
	}

	public static String setRandomQTY (int productIndex) {
		TestObject QTYField= findTestObject('Object Repository/productPage/QTY')
		String newCssSelector= "div[data-test-selector='productListCards_undefined'] > :nth-child(${productIndex})  input[data-test-selector='product_qtyOrdered']"
		QTYField = WebUI.modifyObjectProperty(QTYField, 'css', 'equals', newCssSelector, true)
		WebUI.waitForElementVisible(QTYField, GlobalVariable.timeOut)
		String QTY= generateRandomValue(GlobalVariable.min,GlobalVariable.max).toString()
		WebUI.setText(QTYField, QTY)
		return QTY
	}
}


